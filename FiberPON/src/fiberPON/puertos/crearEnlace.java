package fiberPON.puertos;

import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.calculosResuldados.actualizaciondeTrayectoria;
import fiberPON.dialogo.dialogoPropiedadesEnlace;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.util.dibujoLineas;

public class crearEnlace {

	
	public void crearEnlaceObjeto(objetosPON a,objetosPON b,int e1,int e2,esenarioPrincipal esenarioprincipal){
		
		
        datosFibra fibra= new datosFibra(a.getdatosObjeto().getNombre1()+"-"+b.getdatosObjeto().getNombre1(), a, b, e1, e2, 0, 0, 0, 0, 0,0,0);
       
                   
        	a.anadirArrayFibra(fibra);
        	b.anadirdatosFibraPort0(fibra);
        	
        	
        	// solo añade objetos ont en el arrayONT
        	
        	if(b.getdatosObjeto().getKeyObjeto()==12){       
        			
        				crearObjeto.objListONT.add(b);        				
        			      			
        		       		
        	}  
        	
        	for(int i=0;i<crearObjeto.objListONT.size();i++){
        	
				actualizaciondeTrayectoria clase=new actualizaciondeTrayectoria(crearObjeto.objListONT.get(i));

				
			}
        	
        	dialogoPropiedadesEnlace dilog=new dialogoPropiedadesEnlace(esenarioprincipal,fibra);
        	
        	for(int c=0;c<crearObjeto.arraySimulacion.size();c++){
    			
        		crearObjeto.arraySimulacion.get(c).setNombresObjetos();
    		}       
             
        	crearObjeto.enlaceFibra.add(fibra);
			
	
		dibujoLineas linea=new dibujoLineas(a,b);	
		crearObjeto.Lineas.add(linea);	
		//calculoRed.Calculo();	
		esenarioprincipal.esenariosimulacion.repaint();
		
		
	
	}

}
