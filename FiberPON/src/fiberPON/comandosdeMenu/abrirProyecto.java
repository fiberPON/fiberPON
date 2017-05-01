package fiberPON.comandosdeMenu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.util.dibujoLineas;

public class abrirProyecto implements Serializable {
	
	public ArrayList<objetosPON> listaObjetosRecuperados;
	
	private String archivoPatch;
	
	
	public abrirProyecto(esenarioPrincipal esenarioprincipal){
		
	
		
		
			
			JFileChooser Buscar=new JFileChooser();
			FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.fPON", "fpon");
			Buscar.setFileFilter(filtro);
			int buscar=Buscar.showOpenDialog(null);
			if(buscar==JFileChooser.APPROVE_OPTION){				
				archivoPatch=Buscar.getSelectedFile().getPath();	
			}
		
					
			try{
					
				ObjectInputStream leerSistema=new ObjectInputStream(new FileInputStream(archivoPatch));	
			
			    listaObjetosRecuperados=(ArrayList<objetosPON>)leerSistema.readObject();
			    int[] x=(int[])leerSistema.readObject();
			    ArrayList<datosFibra> lineasrecuperadas=(ArrayList<datosFibra>)leerSistema.readObject();
			    ArrayList<objetosPON> objListONTrecuperados=(ArrayList<objetosPON>)leerSistema.readObject();
			    leerSistema.close();			
			    esenarioprincipal.nuevoProyecto();
			    crearObjeto.listaObjetos=listaObjetosRecuperados;
			    crearObjeto.cont_olt=x[0];
			    crearObjeto.cont_onu=x[1];
			    crearObjeto.cont_spliter=x[2];
			    crearObjeto.enlaceFibra=lineasrecuperadas;
			    crearObjeto.objListONT=objListONTrecuperados;
			    
		       for(int i=0;i<listaObjetosRecuperados.size();i++){		        	
		        	ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal, crearObjeto.listaObjetos.get(i));
		        	if(listaObjetosRecuperados.get(i).getdatosObjeto().getKeyID()==12){
		        		crearObjeto.arraySimulacion.add(objetosimulacion);
		        	}
		        }
		       //vuelve a calcular el enlace
		       calculoRed calculo=new calculoRed();
			       
		     
		
	
		
		
			
		}
	        catch(IOException | ClassNotFoundException  | NullPointerException exs){System.out.println("no hay nada guardado");}
			
			
		

	}
	
	public String darRuta(){
		return archivoPatch;
	}

}

