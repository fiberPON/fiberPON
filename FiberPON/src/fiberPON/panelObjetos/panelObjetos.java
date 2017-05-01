package fiberPON.panelObjetos;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import fiberPON.esenario.esenarioPrincipal;


public class panelObjetos extends JPanel {

	private botonObjetos bot1;
	private botonObjetos bot2;
	private botonObjetos bot3;
	private botonObjetos bot4;
	private botonObjetos bot5;
	
	public panelObjetos(esenarioPrincipal oyente){  
		
		
		ImageIcon imagenMouse=new ImageIcon("imagenes\\cursor.gif");
		ImageIcon imagenOLT=new ImageIcon("imagenes\\OLT.gif");
		ImageIcon imagenONU=new ImageIcon("imagenes\\ONU.gif");		
		ImageIcon imagenSPLIT=new ImageIcon("imagenes\\Splitter.gif");
		ImageIcon imagenFIBRA=new ImageIcon("imagenes\\FIBRA.gif");
		
		bot1=new botonObjetos(oyente,"MOUSE",imagenMouse,10);		
		bot2=new botonObjetos(oyente,"OLT",imagenOLT,11);
		bot3=new botonObjetos(oyente,"ONT",imagenONU,12);
		bot4=new botonObjetos(oyente,"SPLITTER",imagenSPLIT,13);
		bot5=new botonObjetos(oyente,"ENLACE",imagenFIBRA,14);
		
		setBorder(new javax.swing.border.EtchedBorder());	

		
		  Box cajaMenuObjetos=Box.createVerticalBox();
		  cajaMenuObjetos.add(bot1);		  
		  cajaMenuObjetos.add(bot2);		  
		  cajaMenuObjetos.add(bot3);		
		  cajaMenuObjetos.add(bot4);		
		  cajaMenuObjetos.add(bot5);
		  add(cajaMenuObjetos);
		

	
	}
	
	public void habilitarBotones(){
		bot1.setEnabled(true);
		bot2.setEnabled(true);
		bot3.setEnabled(true);
		bot4.setEnabled(true);
		bot5.setEnabled(true);
		
	}
	public void deshabilitar(){
		bot1.setEnabled(false);
		bot2.setEnabled(false);
		bot3.setEnabled(false);
		bot4.setEnabled(false);
		bot5.setEnabled(false);
		
	}
}
