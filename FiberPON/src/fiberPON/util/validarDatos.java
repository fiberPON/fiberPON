package fiberPON.util;

import java.util.ArrayList;
import javax.swing.JTextField;


public class validarDatos {
	
	private boolean isvalidado;
	private double [] valor;	
	private ArrayList<JTextField> valores;
	
	
	public validarDatos(ArrayList<JTextField> valores){
		
		this.valores=valores;
		valor=new double[this.valores.size()];
		System.out.println("se valida datos");
	}
	
	public double[] convDouble(){		
		
		try{
			for(int i=0;i<valores.size();i++){
				
				if(valores.get(i).getText().compareTo("")!=0){
			
					valor[i] = Double.parseDouble(valores.get(i).getText());//si acepta d y f					
					}
				else{
					
					valor[i] =0;
					}
			}
	       
			isvalidado=true;
			
		return valor;	
		}
		catch(Exception e){
			
			isvalidado=false;
			System.out.println("no se puede");
			return valor;
			
			}
			
	}
	public boolean isValidado(){		
		return isvalidado;
	}


}
