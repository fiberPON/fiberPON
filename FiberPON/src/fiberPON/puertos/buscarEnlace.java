package fiberPON.puertos;

import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;

public class buscarEnlace {	
	
	private objetosPON objeto;
	private int Npuerto;
	
	public buscarEnlace(objetosPON objeto,int Npuerto){
		
		this.objeto=objeto;
		this.Npuerto=Npuerto;		
	}
	
   
	public datosFibra getFibra(){
		
		if(objeto.getdatosObjeto().getKeyObjeto()==11){
			
			for(int i=0;i<objeto.getdatosFibra().size();i++){
				if(objeto.getdatosFibra().get(i).getNumero1()==Npuerto){
					
					return objeto.getdatosFibra().get(i);
				}
			}
			
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==12){
			
			return objeto.getFibraPort0();
			/*
			
			for(int i=0;i<objeto.getdatosFibra().size();i++){
				if(objeto.getdatosFibra().get(i).getNumero2()==Npuerto){
					
					return objeto.getdatosFibra().get(i);
				}
			}*/
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==13){
			
			if(Npuerto==0){
				return objeto.getFibraPort0();
			}
			else{
			
			   for(int i=0;i<objeto.getdatosFibra().size();i++){
				    if(objeto.getdatosFibra().get(i).getNumero1()==Npuerto){					
					return objeto.getdatosFibra().get(i);
				}
			 }
			}
			
			/*for(int i=0;i<objeto.getdatosFibra().size();i++){
				
				if((objeto.getdatosFibra().get(i).getObjeto1().equals(objeto) && objeto.getdatosFibra().get(i).getNumero1()==Npuerto)
						|| (objeto.getdatosFibra().get(i).getObjeto2().equals(objeto) && objeto.getdatosFibra().get(i).getNumero2()==Npuerto) ){				
					return objeto.getdatosFibra().get(i);
				}
			}*/
		}
		
		return null;
	}

}
