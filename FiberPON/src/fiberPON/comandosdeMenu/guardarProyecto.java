package fiberPON.comandosdeMenu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import fiberPON.Objetos.crearObjeto;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.esenario.panelSimulacion;

public class guardarProyecto implements Serializable  {
	
	public guardarProyecto(esenarioPrincipal esenarioprincipal,String direccion){
		

			try{
				//deshabilita guardar
				esenarioprincipal.EasyGponmenu.habGuardar(false);
				panelSimulacion.lab.setBorder(null);
				esenarioprincipal.esenariosimulacion.panelsimulacion.add(panelSimulacion.lab);
				//guarda el Array
				ObjectOutputStream escribiendo_fichiro=new ObjectOutputStream(new FileOutputStream(direccion));
				escribiendo_fichiro.writeObject(crearObjeto.listaObjetos);
				escribiendo_fichiro.writeObject(crearObjeto.keys);
				escribiendo_fichiro.writeObject(crearObjeto.enlaceFibra);
				escribiendo_fichiro.writeObject(crearObjeto.objListONT);
				escribiendo_fichiro.close();
				
				
			}
			//Si no se guarda
			catch(IOException  ex){ 
				System.out.println("no se guardo");
				ex.printStackTrace();
			}
			
			
		}
	}