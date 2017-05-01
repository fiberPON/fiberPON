package fiberPON.dialogo;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fiberPON.Objetos.objetosPON;
import fiberPON.main.fiberPON;

public class GraficaUp extends JDialog {
	
	public GraficaUp(JDialog dialogo,objetosPON objeto){
		super(dialogo,true);
		setBounds(fiberPON.anchoPantalla/4, fiberPON.altoPantalla/4, fiberPON.anchoPantalla/2, fiberPON.altoPantalla/2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		Font fuente2=new Font("fuente",Font.BOLD,12);
		CavasGraficosUp cg=new CavasGraficosUp(objeto);		
		add(cg,BorderLayout.CENTER);
		
		
		JLabel Titulo=new JLabel("POWER BUDGET");
		Font fuente=new Font("fuente",Font.BOLD,18);
		Titulo.setFont(fuente);
		Titulo.setPreferredSize(new Dimension(800, 40));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);	
		add(Titulo,BorderLayout.NORTH);
		
		
		JLabel PotenciaTx=new JLabel("Tx");
		PotenciaTx.setFont(fuente2);
		PotenciaTx.setPreferredSize(new Dimension(30, 450));
		add(PotenciaTx,BorderLayout.WEST);
		
		JLabel PotenciaRx=new JLabel(" ");		
		PotenciaRx.setPreferredSize(new Dimension(20, 450));
		add(PotenciaRx,BorderLayout.EAST);
		
		
		
		JLabel Distancia=new JLabel("Distancia [Km]");		
		Distancia.setFont(fuente2);
		Distancia.setPreferredSize(new Dimension(800, 30));
		Distancia.setHorizontalAlignment(SwingConstants.CENTER);	
		add(Distancia,BorderLayout.SOUTH);
		setVisible(true);
		
	}
}


class CavasGraficosUp extends Canvas {
	
	private Vector<GeneralPath> gp;
	private GeneralPath sp;
	private double sensibilidadOLT,potenciaONT,escalarEjeDistancia,escalarEjePotencia,x,y,primeroConector;
	public CavasGraficosUp(objetosPON objeto){
		
		setBackground(Color.white);
		
		gp=new Vector<GeneralPath>();
		sp=new GeneralPath();
		
		sp.moveTo(65, 0);
		//linea por el primero conector
		
		potenciaONT=objeto.getdatosFibraPro().get(0).getObjeto2().getdatosObjeto().getPotTrasmision();
		sensibilidadOLT=objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getSensibilidad();
		escalarEjeDistancia=617/objeto.getdatosObjeto().getSumaDistancia();
		escalarEjePotencia=328/(potenciaONT-sensibilidadOLT);
		//linea por el primero conector
		primeroConector=objeto.getdatosFibraPro().get(0).getConector2()*escalarEjePotencia;
		sp.lineTo(65, primeroConector);
	
		x=0;
		y=0;
		double pru2=0;
		double pru3=0;
		for(int i=0;i<objeto.getdatosFibraPro().size();i++){
			
			//calculo de pendiente
			double m=(objeto.getdatosFibraPro().get(i).getAtenuacionEnlaceDown()*escalarEjePotencia)/(objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia);
		
			double pru=0;
			double pru1=0;
			
			for(int z=0;z<objeto.getdatosFibraPro().get(i).getPerdidaConectoresArrayUp().size();z+=2){
				pru=0;
		
				x=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArrayUp().get(z+1)*escalarEjeDistancia+x;
				pru=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArrayUp().get(z+1)*escalarEjeDistancia;
				pru1=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArrayUp().get(z+1)*escalarEjeDistancia+pru1;
			
				y=(m*pru)+y;
				
				sp.lineTo(x+65, y+primeroConector);
				y=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArrayUp().get(z)*escalarEjePotencia+y;
				
				sp.lineTo(x+65, y+primeroConector);
			
				
			}
			double w=objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia-pru1;
			
			pru2=objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia+pru2;
			//pru3=pru2-x;

			//x=x+pru3;
			x=pru2;		
		
			y=(m*w)+y;			
		
			sp.lineTo(x+65,y+primeroConector);
			y=objeto.getdatosFibraPro().get(i).getObjeto1().getdatosObjeto().getAtenuacion()*escalarEjePotencia+y+(objeto.getdatosFibraPro().get(i).getConector1()*escalarEjePotencia+
					(objeto.getdatosFibraPro().get(i).getmSeguridad()*escalarEjePotencia));			
			sp.lineTo(x+65, y+primeroConector);
			
		}
		
		gp.add(sp);
		
		
	
		
	}
		
	public void paint(Graphics g) {
		
		super.paint(g);
		g.drawString("Holass", 100, 100);
		g.drawString("Tx "+potenciaONT, 2,10);
		g.drawString("RxMin "+sensibilidadOLT, 2, 328);
	    g.drawRect(65, 0, 617, 328);
		Graphics2D g2D=(Graphics2D)g;
		g2D.setStroke(new BasicStroke(3));
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < gp.size(); i++) {
			
				g2D.draw((Shape)gp.elementAt(i));
			
				
		}
	}
	
}
