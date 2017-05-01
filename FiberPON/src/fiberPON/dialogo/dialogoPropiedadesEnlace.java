package fiberPON.dialogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiberPON.Objetos.crearObjeto;
import fiberPON.Valores.datosFibra;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.calculosResuldados.actualizaciondeTrayectoria;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.componentesDialogo;
import fiberPON.util.crearArrayEmpalme;
import fiberPON.util.validarDatos;

public class dialogoPropiedadesEnlace extends componentesDialogo {
	
 
    private ArrayList<JTextField> textfilearray;	
	private double [] valor=new double[11];
	private datosFibra fibra;
	public ArrayList<Double> arrayPerdida,arrayPerdida2;
	private int perdida1;
	public dialogoPropiedadesEnlace(esenarioPrincipal esenarioprincipal,datosFibra fibra){
	super(esenarioprincipal,"del enlace");
	this.fibra=fibra;
    arrayPerdida=new ArrayList<Double>();
    arrayPerdida2=new ArrayList<Double>();
    textfilearray=new ArrayList<JTextField>();
	ImageIcon imagen=new ImageIcon("imagenes\\FIBRA.gif");
	setDialogo(this);
	setResizable(false);
	setBounds(fiberPON.anchoPantalla/2-150,fiberPON.altoPantalla/2-130, 330,470);
	setLayout(null);
	
	setImagenTitulo(10, imagen, "Enlace Optico entre "+fibra.getNombre());
	textfilearray.add(setCaracteristicasCustom(60,10,185,230, "Distancia", fibra.getDistancia(), "Km"));
	textfilearray.add(setCaracteristicasCustom(90, 10, 185, 230, "Atenuacion a 1310 nm", fibra.getAtenuacionUp(), "dB/km"));
	textfilearray.add(setCaracteristicasCustom(120,10,185,230, "Atenuacion a 1490 nm", fibra.getAtenuacionDown(), "dB/km"));
	textfilearray.add(setCaracteristicasCustom(150,10,185,230, "Atenuacion a 1550 nm", fibra.getAtenuacionVideo(), "dB/km"));
	textfilearray.add(setCaracteristicasCustom(180,10,185,230, "Dispersion Cromatica a 1310 nm", fibra.getDisCromaticaUp(), "ps/(nm*Km)"));
	textfilearray.add(setCaracteristicasCustom(210,10,185,230, "Dispersion Cromatica a 1490 nm", fibra.getDisCromaticaDown(), "ps/(nm*Km)"));
	textfilearray.add(setCaracteristicasCustom(240,10,185,230, "Dispersion Cromatica a 1550 nm", fibra.getDisCromaticaVideo(), "ps/(nm*Km)"));
	textfilearray.add(setCaracteristicasCustom(270,10,185,230, "Atenuacion Conector "+fibra.getObjeto1().getdatosObjeto().getNombre1(), fibra.getConector1(), "dB"));
	textfilearray.add(setCaracteristicasCustom(300,10,185,230, "Atenuacion Conector "+fibra.getObjeto2().getdatosObjeto().getNombre1(), fibra.getConector2(), "dB"));
	textfilearray.add(setCaracteristicasEnteroCustom(330,10,185,230, "Numero de Empalmes", fibra.getNEmpalmes(), ""));
	textfilearray.add(setCaracteristicasCustom(360, 10, 185, 230, "Margen de Seguridad", fibra.getmSeguridad(), "dB"));
	JLabel confEmpalme=new JLabel("conf. Empalme");
	confEmpalme.setFont(new Font("Serif", Font.BOLD, 12));
	confEmpalme.setForeground(Color.blue);
	confEmpalme.setBounds(230, 328, 300, 25);
	add(confEmpalme);

	
	confEmpalme.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			JTextField perdida=textfilearray.get(textfilearray.size()-2);
			JTextField distancia=textfilearray.get(0);
			try{
				perdida1=(int)Double.parseDouble(perdida.getText());
				double distancia1=Double.parseDouble(distancia.getText());
			
				if(perdida1>0){	
					crearArrayEmpalme arrayE=new crearArrayEmpalme(fibra, perdida1);
					arrayPerdida=arrayE.darArray();
				    dialogoPropiedadesPerdida PerdidaEmpalme=new dialogoPropiedadesPerdida(dialogoPropiedadesEnlace.this, perdida1,arrayPerdida,distancia1);
				  
				}
			    
			   
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(dialogoPropiedadesEnlace.this,"Algunos de los valores introducidos son incorrectos");
				ex.printStackTrace();
			}
			
			
		}
	});
	
	
	
	JLabel eliminar=new JLabel("eliminar enlace");
	eliminar.setFont(new Font("Serif", Font.BOLD, 12));
	eliminar.setForeground(Color.red);
	eliminar.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent e) {			
			super.mouseClicked(e);
			int valor=JOptionPane.showConfirmDialog(esenarioprincipal,"Esta seguro de eliminar el\n enlace entre "+fibra.getNombre()+"?");
			//solo evaluamos si se preciona aceptar
			if(valor==JOptionPane.YES_OPTION){
				//borramos el array del array de enlace de primero objeto
				fibra.getObjeto1().getdatosFibra().remove(fibra);
				//borramos el array del array de enlace de segundo objeto
				fibra.getObjeto2().anadirdatosFibraPort0(null);				
				//borramos el array del array de enlace
				crearObjeto.enlaceFibra.remove(fibra);
				//repitanmos el panel
				esenarioprincipal.esenariosimulacion.panelsimulacion.repaint();
				//eliminamos del array de ONT si es el objeto 2 una ONT
				if(fibra.getObjeto2().getdatosObjeto().getKeyObjeto()==12){
					
					crearObjeto.objListONT.remove(fibra.getObjeto2());
					fibra.getObjeto2().getdatosObjeto().setAtenuacionTotalDownO();
					
				}
				
			    //calculamos otra ves el enlace 
				for(int i=0;i<crearObjeto.objListONT.size();i++){
					actualizaciondeTrayectoria clase=new actualizaciondeTrayectoria(crearObjeto.objListONT.get(i));
				}
                //las etiquetas de la ONT  en el panel Simulacion
				
			    for(int c=0;c<crearObjeto.arraySimulacion.size();c++){    			
		    		crearObjeto.arraySimulacion.get(c).setNombresObjetos();
		    		
				}
				setVisible(false);
				
			}
		}
	});
	eliminar.setBounds(120, 390, 90, 25);
	add(eliminar);
	setBotonesCustom("Aceptar", "Cancelar", 50, 90, this.getHeight()-60);
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand().compareTo("Aceptar")==0){
			
			validarDatos validar=new validarDatos(textfilearray);
			valor=validar.convDouble();
			if(validar.isValidado()==true){

				//////////////////////////////////////falta validacion si se cambia la distancia 
				fibra.setDistancia(valor[0]);				
				fibra.setAtenuacionUp(valor[1]);			
				fibra.setAtenuacionDown(valor[2]);				
				fibra.setAtenuacionVideo(valor[3]);				
				fibra.setDiCromaticaUp(valor[4]);
				fibra.setDisCromaticaDown(valor[5]);
				fibra.setDisCromaticaVideo(valor[6]);
				fibra.setConector1(valor[7]);
				fibra.setConector2(valor[8]);
				if(arrayPerdida.size()==0){
					fibra.setNEmpalmes(0);
				}
				else{fibra.setNEmpalmes((int)valor[9]);	}
				fibra.setmSeguridad(valor[10]);		
				fibra.setPerdidaConectoresArray(arrayPerdida);
				
				
				//enlace acendente
				fibra.getPerdidaConectoresArrayUp().clear();
				
				for(int c=0;c<arrayPerdida2.size();c+=2){
					fibra.getPerdidaConectoresArrayUp().add(arrayPerdida2.get(c));
					fibra.getPerdidaConectoresArrayUp().add(valor[0]-arrayPerdida2.get(c+1));
				}
			
				calculoRed.Calculo();
	
				setVisible(false);	
			}
			else{
				JOptionPane.showMessageDialog(this,"Algunos de los valores introducidos son incorrectos");
				}						
		}
		else if(arg0.getActionCommand().compareTo("Cancelar")==0){
			
			setVisible(false);
		}
		
	}


}