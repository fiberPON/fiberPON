package fiberPON.comandosdeMenu;

import java.io.Serializable;

import javax.swing.JOptionPane;

import fiberPON.Objetos.crearObjeto;
import fiberPON.esenario.esenarioPrincipal;

public class salirProyecto implements Serializable{
	
	private int valor;
	
	public salirProyecto(esenarioPrincipal esenarioprincipal,String ruta){
		
		try{
			if(esenarioPrincipal.contadorVentanas==0){System.exit(0);}
	
		else if(crearObjeto.listaObjetos.size()==0){
			System.exit(0);
		}
		else if(esenarioprincipal.EasyGponmenu.guardar.isEnabled()==false){			
			System.exit(0);
		}
		else{valor=JOptionPane.showConfirmDialog(esenarioprincipal, "¿desea guarda el proyecto?");
		
				if(valor==JOptionPane.YES_OPTION){
					esenarioprincipal.guardarProyecto();
					System.exit(0);
				}
				else if (valor==JOptionPane.NO_OPTION) {
					System.exit(0);
				}
		
		}
	
	}
	catch(NullPointerException n){
		System.exit(0);
	}
  }
}

