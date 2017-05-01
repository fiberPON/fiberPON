package fiberPON.util;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import fiberPON.esenario.esenarioPrincipal;

public class fileChooser {
	
	private String direccion;
	private File cam;
	
	public fileChooser(esenarioPrincipal esenarioprincipal,String titulo){
		
		JFileChooser Buscar=new JFileChooser();
		Buscar.setDialogTitle(titulo);
		FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.fPON", "fpon");		
		Buscar.setFileFilter(filtro);
		int buscar =Buscar.showSaveDialog(null);// no da esta null
		if(buscar==JFileChooser.APPROVE_OPTION){
			
			     direccion=Buscar.getSelectedFile().getPath();
                 if(direccion.endsWith(".fpon")!=true){				
				    direccion=direccion+".fpon";				
			     }
                 
         		patchFileChooser patch=new patchFileChooser(esenarioprincipal, direccion);
         		int s=patch.getValorPatch();
         		if(s==1){
         			new fileChooser(esenarioprincipal,titulo);
         		}
         		else if(s==2){direccion="null";}
                 
                 
		}
		else{direccion="null";}
		
	}
	
	public String darRuta(){
		
		return direccion;
	}

}
