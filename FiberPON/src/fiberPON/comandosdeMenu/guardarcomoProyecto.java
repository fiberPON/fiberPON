package fiberPON.comandosdeMenu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import fiberPON.Objetos.crearObjeto;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.esenario.panelSimulacion;
import fiberPON.util.fileChooser;
import fiberPON.util.patchFileChooser;

public class guardarcomoProyecto implements Serializable  {
	
	private String direccion;
	private esenarioPrincipal esenarioprincipal;
	private  File cam;
	
	public guardarcomoProyecto(esenarioPrincipal esenarioprincipal){
		
	
		esenarioprincipal.EasyGponmenu.habGuardar(false);
		fileChooser patchfilechooser=new fileChooser(esenarioprincipal,"Guardar Como");
		String ruta=patchfilechooser.darRuta();	
		if(ruta.compareTo("null")==0){System.out.println("holas");}
		else{grabarfichero(ruta);}
		
					
	}
	
		
	
	public void grabarfichero(String direccion){
		
		try{					
			
			ObjectOutputStream escribiendo_fichiro=new ObjectOutputStream(new FileOutputStream(direccion));
			escribiendo_fichiro.writeObject(crearObjeto.listaObjetos);
			escribiendo_fichiro.writeObject(crearObjeto.keys);
			escribiendo_fichiro.writeObject(crearObjeto.enlaceFibra);
			escribiendo_fichiro.writeObject(crearObjeto.objListONT);
			escribiendo_fichiro.close();
			
		}
		catch(IOException  ex){ 
			
			System.out.println("no se guardo");
			//ex.printStackTrace();
		}
		
	}

}