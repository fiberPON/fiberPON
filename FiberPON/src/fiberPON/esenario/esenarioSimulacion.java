package fiberPON.esenario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import fiberPON.main.fiberPON;


public class esenarioSimulacion extends JInternalFrame implements InternalFrameListener{
	
	public panelSimulacion panelsimulacion;	
	private esenarioPrincipal esenarioprincipal;

    //constructor del esenarioSimulacion  
	public esenarioSimulacion(esenarioPrincipal esenarioprincipal){
	    //llamamos al constructor del jinternalframe 
		super("nuevo",true,true,true,true);			    
		this.esenarioprincipal=esenarioprincipal;
		//icono		
		setFrameIcon(new ImageIcon("imagenes/fiberPON.gif"));
		//dimenciones del esenarioSimulacion
		setSize(esenarioPrincipal.ancho-80,esenarioPrincipal.alto-60);
		//no hacer nada si precionamos X
		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		//activamos panel objetos
		this.esenarioprincipal.panelObjetos.habilitarBotones();
		//habilitamos opcion guardar como
		this.esenarioprincipal.EasyGponmenu.habGuardarcomo(true);
		//instancia panel simulacion
		panelsimulacion=new panelSimulacion(this.esenarioprincipal);
		//
		//panelsimulacion.setPreferredSize(new Dimension(4000, 4000));
        
		//añadimos panel simulacion a un sroll pane
		JScrollPane scrollerpanelSimulacion = new JScrollPane(panelsimulacion, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);		
		//
		//scrollerpanelSimulacion.getPreferredSize();
		//mostramos ventana simulacion
		setVisible(true);
		//añadimos el scroll pane a la ventana simulacion
		add(scrollerpanelSimulacion,BorderLayout.CENTER);
		//registramos el oyecto
		addInternalFrameListener(this);
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	//cuando cerramos la ventana simulacion
	public void internalFrameClosed(InternalFrameEvent e) {
		//reducimos en numero de ventanas
		esenarioPrincipal.contadorVentanas--;
		//deshabiltamos panel objetos
		esenarioprincipal.panelObjetos.deshabilitar();
		//deshabilitamos guardar como
		esenarioprincipal.EasyGponmenu.habGuardarcomo(false);
		esenarioprincipal.EasyGponmenu.habCopiarBorrar(false);
		esenarioprincipal.EasyGponmenu.activarPegar(false);
	}

	//antes de cerrar ventana simulacion
	public void internalFrameClosing(InternalFrameEvent e) {
        
		this.esenarioprincipal.antesdeCerrarSimulacion(this);
	
	   
	
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}
