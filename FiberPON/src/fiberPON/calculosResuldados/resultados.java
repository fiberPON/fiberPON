package fiberPON.calculosResuldados;

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
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import fiberPON.Objetos.objetosPON;
import fiberPON.main.fiberPON;



public class resultados extends JDialog {
	private objetosPON objeto;
		
	public resultados(JDialog dialogo,objetosPON objeto,String distanciaDiferencial){
		super(dialogo,true);
	
		setBounds(fiberPON.anchoPantalla/4, fiberPON.altoPantalla/4, fiberPON.anchoPantalla/2, fiberPON.altoPantalla/2+25);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		Font fuente2=new Font("fuente",Font.BOLD,12);
		CavasGraficos cg=new CavasGraficos(objeto);	
		repaint();
		add(cg,BorderLayout.CENTER);
		//formato para mostrar decimlaes
	    
		
		
		JLabel Titulo=new JLabel("RESULTADOS "+objeto.getdatosObjeto().getNombre1());
		Font fuente=new Font("fuente",Font.BOLD,18);
		Titulo.setFont(fuente);
		Titulo.setPreferredSize(new Dimension(800, 40));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);	
		add(Titulo,BorderLayout.NORTH);
		
		//solo se usa esta parte para gerar espaciones laterales 
		//--------------------------------------------------------------------------------------------------
		JLabel PotenciaTx=new JLabel(" ");
		PotenciaTx.setFont(fuente2);
		PotenciaTx.setPreferredSize(new Dimension(10, 450));
		add(PotenciaTx,BorderLayout.WEST);
		
		JLabel PotenciaRx=new JLabel(" ");		
		PotenciaRx.setPreferredSize(new Dimension(10, 450));
		add(PotenciaRx,BorderLayout.EAST);
		//--------------------------------------------------------------------------------------------------
		
	
		
		panelResultado panel=new panelResultado(objeto,distanciaDiferencial);
		add(panel,BorderLayout.SOUTH);
		setVisible(true);
		
		
		
	}
}
class panelResultado extends JPanel{
	
	private DecimalFormat decimales;
	private double tVideo,tRx,tf,tr,anchoBandaDown,TDown,dDown,tUp,tUpRx,tUpf,trUp,anchoBandaUp,TUp,dTUp;
	
	public panelResultado(objetosPON objeto,String distanciaDiferencial){		
		setLayout(null);
		setPreferredSize(new Dimension(fiberPON.anchoPantalla/2, 160));
		//set de decimales
		decimales = new DecimalFormat("0.00");
		
		//calculo de tiempo Down Video
		tVideo=Math.pow(objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getTimeUp(), 2);
		tRx=Math.pow(objeto.getdatosObjeto().getTimeUp(), 2);
		tf=Math.pow(objeto.getdatosObjeto().getSumaTdispersionVideo(), 2);
		tr=Math.sqrt(tVideo+tRx+tf);
		anchoBandaDown=objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getVelocidadDownReal();
		TDown=1/(anchoBandaDown*Math.pow(10, 6));
		dDown=(tr/TDown)*100;
		//calculo de tiempo Up
		tUp=Math.pow(objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getTimeUp(), 2);
		tUpRx=Math.pow(objeto.getdatosObjeto().getTimeUp(), 2);
		tUpf=Math.pow(objeto.getdatosObjeto().getSumaTdispersionUp(), 2);
		trUp=Math.sqrt(tUp+tUpRx+tUpf);
		anchoBandaUp=objeto.getdatosObjeto().getVelocidadUp();
		TUp=1/(anchoBandaUp*Math.pow(10, 6));
		dTUp=(trUp/TUp)*100;
		
		
		
		
		
		JLabel downResutado=new JLabel("Enlace Descendente");
		downResutado.setBounds(40, 10, (fiberPON.anchoPantalla/4)-40, 25);
		downResutado.setBorder(new javax.swing.border.EtchedBorder());
		downResutado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel upResutado=new JLabel("Enlace Ascendente");
		upResutado.setBounds((fiberPON.anchoPantalla/4), 10,(fiberPON.anchoPantalla/4)-40 , 25);
		upResutado.setBorder(new EtchedBorder());
		upResutado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel perdidaEnlaceDown=new JLabel("Perdida del Enlace a 1490 nm: "+decimales.format(objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1)
				.getObjeto1().getdatosObjeto().getPotTrasmision()-objeto.getdatosObjeto().getAtenuacionTotalDown())+" dB");
		perdidaEnlaceDown.setBounds(40, 35,(fiberPON.anchoPantalla/4)-40 , 25);
		perdidaEnlaceDown.setBorder(new EtchedBorder());
		
		JLabel perdidaEnlaceVideo=new JLabel("Perdida del Enlace a 1550 nm: "+decimales.format(objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1)
				.getObjeto1().getdatosObjeto().getPotTrasmision()-objeto.getdatosObjeto().getAtenuacionTotalVideo())+" dB");
		perdidaEnlaceVideo.setBounds(40, 60,(fiberPON.anchoPantalla/4)-40 , 25);
		perdidaEnlaceVideo.setBorder(new EtchedBorder());
		
		JLabel potenciaRecibidaDown=new JLabel("Menor Potencia Recibida: "+decimales.format(objeto.getdatosObjeto().laMenorAtenuacion())+" dBm");
		potenciaRecibidaDown.setBounds(40, 85,(fiberPON.anchoPantalla/4)-40 , 25);
		potenciaRecibidaDown.setBorder(new EtchedBorder());
		
		if(objeto.getdatosObjeto().getAtenuacionTotalDown()<objeto.getdatosFibraPro().get(0).getObjeto2().getdatosObjeto().getSensibilidad()){
			potenciaRecibidaDown.setFont(new Font("Serif", Font.BOLD, 12));
			potenciaRecibidaDown.setForeground(Color.red);
		}
		
		
		JLabel tiempoDown=new JLabel("Tiempo de Subida del Enlace: "+decimales.format(0.0)+" ps");
		tiempoDown.setBounds(40, 110,(fiberPON.anchoPantalla/4)-40 , 25);
		tiempoDown.setBorder(new EtchedBorder());
		
		JLabel perdidaEnlaceUp=new JLabel("Perdida del Enlace a 1310 nm: "+decimales.format(objeto.getdatosObjeto().getPotTrasmision()-objeto.getdatosObjeto().getAtenuacionTotalUp())+" dB");
		perdidaEnlaceUp.setBounds((fiberPON.anchoPantalla/4), 35,(fiberPON.anchoPantalla/4)-40 , 25);
		perdidaEnlaceUp.setBorder(new EtchedBorder());
		
	
		JLabel potenciaRecibidaUp=new JLabel("Potencia Recibida: "+decimales.format(objeto.getdatosObjeto().getAtenuacionTotalUp())+" dBm");
		potenciaRecibidaUp.setBounds((fiberPON.anchoPantalla/4), 60,(fiberPON.anchoPantalla/4)-40 , 25);
		potenciaRecibidaUp.setBorder(new EtchedBorder());
		
		
		if(objeto.getdatosObjeto().getAtenuacionTotalUp()<objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getSensibilidad()){
			potenciaRecibidaUp.setFont(new Font("Serif", Font.BOLD, 12));
			potenciaRecibidaUp.setForeground(Color.red);
		}
		
		JLabel tiempoUp=new JLabel("Tiempo de Subida del Enlace: "+decimales.format(0.0)+" ps");
		tiempoUp.setBounds((fiberPON.anchoPantalla/4), 85,(fiberPON.anchoPantalla/4)-40 , 25);
		tiempoUp.setBorder(new EtchedBorder());
		

		JLabel DistanciaDiferencial=new JLabel(distanciaDiferencial);
		DistanciaDiferencial.setBounds((fiberPON.anchoPantalla/4), 108,(fiberPON.anchoPantalla/4)-40 , 25);
		DistanciaDiferencial.setFont(new Font("Serif", Font.BOLD, 12));
		DistanciaDiferencial.setForeground(Color.red);
		
		
		//JLabel PotenciaDiferencial=new JLabel("  Existe una potencia Diferencial Mmayor a 15 dB");
		//PotenciaDiferencial.setBounds((fiberPON.anchoPantalla/4), 128,(fiberPON.anchoPantalla/4)-40 , 25);
		//PotenciaDiferencial.setFont(new Font("Serif", Font.BOLD, 12));
		//PotenciaDiferencial.setForeground(Color.red);
	
		
		add(downResutado);
		add(upResutado);
		add(perdidaEnlaceDown);
		add(perdidaEnlaceVideo);
		add(potenciaRecibidaDown);
		add(tiempoDown);
		add(perdidaEnlaceUp);
		add(potenciaRecibidaUp);
		add(tiempoUp);
		add(DistanciaDiferencial);
		//add(PotenciaDiferencial);
		
	}
}

class CavasGraficos extends Canvas {
	

	private DecimalFormat decimales;
	private Vector<GeneralPath> gp;
	private GeneralPath sp;
	private double sensibilidadONT,potenciaOLT,escalarEjeDistancia,escalarEjePotencia,x;
	public double y,primeroConector;
	private objetosPON objeto;
	private double pru3;
	public CavasGraficos(objetosPON objeto){
		
		setBackground(Color.white);
		this.objeto=objeto;
		decimales = new DecimalFormat("0.00");
		gp=new Vector<GeneralPath>();
		gp.clear();
		sp=new GeneralPath();
		
		sp.moveTo(90, 0);
		//linea por el primero conector
		
		sensibilidadONT=objeto.getdatosFibraPro().get(0).getObjeto2().getdatosObjeto().getSensibilidad();
		potenciaOLT=objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getPotTrasmision();
		escalarEjeDistancia=617/objeto.getdatosObjeto().getSumaDistancia();
		
		escalarEjePotencia=198/(potenciaOLT-objeto.getdatosObjeto().getSumaAtenuacionDown());
		//linea por el primero conector
		primeroConector=objeto.getdatosFibraPro().get(objeto.getdatosFibraPro().size()-1).getConector1()*escalarEjePotencia;
		sp.lineTo(90, primeroConector);
		
		x=0;
		y=0;
		double pru2=0;
		
		for(int i=objeto.getdatosFibraPro().size()-1;i>-1;i--){
			
			//calculo de pendiente
			double m=(objeto.getdatosFibraPro().get(i).getAtenuacionEnlaceDown()*escalarEjePotencia)/(objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia);
			
			double pru=0;
			double pru1=0;
			
			for(int z=0;z<objeto.getdatosFibraPro().get(i).getPerdidaConectoresArray().size();z+=2){
				pru=0;
			
				x=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArray().get(z+1)*escalarEjeDistancia+x;
				pru=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArray().get(z+1)*escalarEjeDistancia;
				pru1=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArray().get(z+1)*escalarEjeDistancia+pru1;				
				y=(m*pru)+y;
				
			
				sp.lineTo(x+90, y+primeroConector);
				
				y=objeto.getdatosFibraPro().get(i).getPerdidaConectoresArray().get(z)*escalarEjePotencia+y;					
			
				sp.lineTo(x+90, y+primeroConector);
				
				
			
				
			}
			double w=objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia-pru1;
			
			pru2=objeto.getdatosFibraPro().get(i).getDistancia()*escalarEjeDistancia+pru2;		
			x=pru2;					
			y=(m*w)+y;	
			
		
			sp.lineTo(x+90, y+primeroConector);
		
			y=objeto.getdatosFibraPro().get(i).getObjeto2().getdatosObjeto().getAtenuacion()*escalarEjePotencia+y+(objeto.getdatosFibraPro().get(i).getConector2()*escalarEjePotencia+
					(objeto.getdatosFibraPro().get(i).getmSeguridad()*escalarEjePotencia));	
			
		
			sp.lineTo(x+90, y+primeroConector);
			
			pru3=(y+primeroConector)/escalarEjePotencia;
			
		}
		
		gp.add(sp);
		
		
	
		
	}
	
		
	public double getPru3() {
		return pru3;
	}


	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2D=(Graphics2D)g;	
	
		g2D.drawString("Pot.Tx "+decimales.format(potenciaOLT), 22,10);
		g2D.drawString("Pot.Rx "+decimales.format(objeto.getdatosObjeto().getAtenuacionTotalDown()), 22, 198);		
		g2D.drawString("Distancia [Km]",360 , 230);
		
		g2D.drawString("0", 90, 210);
		g2D.drawString(""+decimales.format(objeto.getdatosObjeto().getSumaDistancia()), 695, 210);
		
		g2D.rotate(-Math.PI/2, 15, 115);
		g2D.drawString("Potencia [dBm]", 15, 115);	
		g2D.rotate(Math.PI/2, 15, 115);
		g2D.drawRect(90, 0, 617, 198);


					
			if(objeto.getdatosObjeto().getSumaDistancia()>20){
				g2D.drawString("20",(int)(85+20*escalarEjeDistancia) , 210);
				g2D.setColor(Color.red);			
				g2D.drawLine((int)(90+20*escalarEjeDistancia), 0,(int)( 90+20*escalarEjeDistancia), 198);
			
		}
		
		if(objeto.getdatosObjeto().getAtenuacionTotalDown()<(sensibilidadONT)){
			g2D.drawString("RxMin "+decimales.format(sensibilidadONT),22 , (int)((potenciaOLT-sensibilidadONT)*escalarEjePotencia));
			g2D.setColor(Color.red);
			g2D.drawLine(90, (int)((potenciaOLT-sensibilidadONT)*escalarEjePotencia),617+90, (int)((potenciaOLT-sensibilidadONT)*escalarEjePotencia));
			
		}
		//g2D.setColor(Color.black);
	    	
	    g2D.setStroke(new BasicStroke(3));
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		

			for (int i = 0; i < gp.size(); i++) {				
				g2D.draw((Shape)gp.elementAt(i));			
		    
		}
		
	
	}
	
}
