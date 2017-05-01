package fiberPON.util;

import java.io.File;

import javax.swing.JOptionPane;

import fiberPON.esenario.esenarioPrincipal;

public class patchFileChooser {
	
	private int s;
	private File file;
	
	public patchFileChooser(esenarioPrincipal esenarioprincipal,String direccion){
		
		
		
		file=new File(direccion);
        if(file.exists()==true){
        	
			int valor=JOptionPane.showConfirmDialog(esenarioprincipal,"el archivo ya existe \n desea sobrescribir el archivo?");
			if(valor==JOptionPane.NO_OPTION){
				s=1;
			}
			else if(valor==JOptionPane.YES_OPTION){
				s=0;
			}
			else if(valor==JOptionPane.CANCEL_OPTION){
				s=2;
			}
		
	  }
    }
	
	public int getValorPatch(){
	return s;
	}

}
