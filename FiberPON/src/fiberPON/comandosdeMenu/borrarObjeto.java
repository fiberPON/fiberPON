package fiberPON.comandosdeMenu;

import java.io.Serializable;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.crearObjeto;
import fiberPON.calculosResuldados.actualizaciondeTrayectoria;

public class borrarObjeto implements Serializable{
	
	public borrarObjeto(ObjetoSimulacion objetosimulacion){
		
		int size=objetosimulacion.getObjetosPON().getdatosFibra().size();
		
		
		if(objetosimulacion.getObjetosPON().getdatosObjeto().getKeyObjeto()==11){
			
			for(int i=size-1;i>=0;i-=1){
				
				crearObjeto.enlaceFibra.remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i));
				if(objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().getdatosObjeto().getKeyObjeto()==12){
					crearObjeto.objListONT.remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2());
					objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().getdatosObjeto().setAtenuacionTotalDownO();
				}
				objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().anadirdatosFibraPort0(null);					
				objetosimulacion.getObjetosPON().getdatosFibra().remove(i);				
			}
			
			
		}
		else if(objetosimulacion.getObjetosPON().getdatosObjeto().getKeyObjeto()==12){
			crearObjeto.arraySimulacion.remove(objetosimulacion);			
		    crearObjeto.enlaceFibra.remove(objetosimulacion.getObjetosPON().getFibraPort0());
		    crearObjeto.objListONT.remove(objetosimulacion.getObjetosPON());
		    try{
		    objetosimulacion.getObjetosPON().getFibraPort0().getObjeto1().getdatosFibra().remove(objetosimulacion.getObjetosPON().getFibraPort0());
		    objetosimulacion.getObjetosPON().anadirdatosFibraPort0(null);}
			catch(NullPointerException  ex){}
		}
		else if(objetosimulacion.getObjetosPON().getdatosObjeto().getKeyObjeto()==13){
			
			crearObjeto.enlaceFibra.remove(objetosimulacion.getObjetosPON().getFibraPort0());
		
			try{
				objetosimulacion.getObjetosPON().getFibraPort0().getObjeto1().getdatosFibra().remove(objetosimulacion.getObjetosPON().getFibraPort0());
			    objetosimulacion.getObjetosPON().anadirdatosFibraPort0(null);}
			catch(NullPointerException  ex){}
		
			
			
			
            for(int i=size-1;i>=0;i-=1){
            	
            	if(objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().getdatosObjeto().getKeyObjeto()==12){
    				crearObjeto.objListONT.remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2());
    				objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().getdatosObjeto().setAtenuacionTotalDownO();
    			}
            	   
				    crearObjeto.enlaceFibra.remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i));									
					objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().anadirdatosFibraPort0(null);
					objetosimulacion.getObjetosPON().getdatosFibra().remove(i);				
			}
			
			
		}
		
	    /*
		
		for(int i=size-1;i>=0;i-=1){
		
			SistemaObjetos.enlaceFibra.remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i));
			
			if(objetosimulacion.getObjetosPON().equals(objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto1())){
				
				objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto2().getdatosFibra().remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i));
				objetosimulacion.getObjetosPON().getdatosFibra().remove(i);
				
			}
			else{
				
				objetosimulacion.getObjetosPON().getdatosFibra().get(i).getObjeto1().getdatosFibra().remove(objetosimulacion.getObjetosPON().getdatosFibra().get(i));
				objetosimulacion.getObjetosPON().getdatosFibra().remove(i);
				
			}
		}*/
		
	
		
	
		crearObjeto.listaObjetos.remove(objetosimulacion.getObjetosPON());
	    objetosimulacion.removeAll();
	    
	    //calculamos otra ves el enlace 
		for(int i=0;i<crearObjeto.objListONT.size();i++){
			actualizaciondeTrayectoria clase=new actualizaciondeTrayectoria(crearObjeto.objListONT.get(i));
		}
		//las etiquetas de la ONT en el panel simulacion
	    for(int c=0;c<crearObjeto.arraySimulacion.size();c++){    			
    		crearObjeto.arraySimulacion.get(c).setNombresObjetos();
		}
	}

}
