package fiberPON.util;

import java.util.ArrayList;

import fiberPON.Valores.datosFibra;

public class crearArrayEmpalme {

	private ArrayList<Double> perdidasArray;
	
	public crearArrayEmpalme(datosFibra fibra, int NEmpalme){
		perdidasArray=new ArrayList<Double>();
		int prueba=NEmpalme-fibra.getNEmpalmes();
		if(prueba>=0){
			  for(int b=0;b<fibra.getPerdidaConectoresArray().size();b++){
			    	perdidasArray.add(fibra.getPerdidaConectoresArray().get(b));
			    }
			  for(int z=0;z<prueba;z++){
			    	perdidasArray.add(0.0);
			    	perdidasArray.add(0.0);
			    }
			  
		}
		else{
			 for(int b=0;b<NEmpalme;b++){
			    	perdidasArray.add(fibra.getPerdidaConectoresArray().get(b*2));
			    	perdidasArray.add(fibra.getPerdidaConectoresArray().get(b*2+1));
			    }
		}
	}
	public ArrayList<Double> darArray(){
		
		return perdidasArray;
	}
}
