package fiberPON.calculosResuldados;

import java.text.DecimalFormat;

import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;


public class actualizaciondeTrayectoria {
	
	private objetosPON b;
	private datosFibra fibraPrueba;
	private int x;


	public actualizaciondeTrayectoria(objetosPON b){
		
		
		
		this.b=b;	

		b.getdatosFibraPro().clear();
		flujo(this.b.getFibraPort0());
	}
	
	public void flujo(datosFibra fibra){
		
		fibraPrueba=fibra;
		
		this.b.anadirArrayFibraPro(fibra);
		
	
		x=0;
		while(x==0){		
			System.out.println("entro al while");
			
			try{
				
				System.out.println("por lo menos si da while 1 para el ob: "+fibraPrueba.getObjeto1().getFibraPort0().getObjeto1().getdatosObjeto().getKeyID());			    
			    b.anadirArrayFibraPro(fibraPrueba.getObjeto1().getFibraPort0());
			    
			    fibraPrueba=fibraPrueba.getObjeto1().getFibraPort0();
			    
			}
			catch(NullPointerException e){
				
			    x++;
			    System.out.println("no da while Atras con x= "+x);
			    
			}
			
			
	
		}


		
	}	
	

}		


