package fiberPON.puertos;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;
import fiberPON.esenario.panelSimulacion;
import fiberPON.main.fiberPON;


public class menuPuertos extends JDialog  {	
	
	//tipo es si se muestra los enlaces o si se muestra los slots libres 1 es slots libres 2 es muestra enlace
	private panelSimulacion panelsimulacion;
	private panelOpciones panelOb;
	public menuPuertos(panelSimulacion panelsimulacion){
		
		setUndecorated(true);	
		setVisible(false);
		this.panelsimulacion=panelsimulacion;
	    panelOb=new panelOpciones(panelsimulacion);        
        JScrollPane scrollOp = new JScrollPane(panelOb, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollOp);
	}

	
	public void Construir(objetosPON objeto,int xp,int yp){

		//limpiamos el array y el Box
		panelOb.limpiar();
		
		int alto=25*objeto.getdatosObjeto().getNpuertos()+25;
		
		if(alto>=450){
		
			alto=450;}
	
		
		if(xp+130>fiberPON.anchoPantalla){
		
		    xp=fiberPON.anchoPantalla-130;	
		}
		if(yp+alto>fiberPON.altoPantalla){
			
			yp=fiberPON.altoPantalla-alto-40;
		}
				
		setBounds(xp,yp, 130, alto);
		panelOb.conexiones1(objeto);
        setVisible(true);
	}


}

class panelOpciones extends JPanel{
	
	private panelSimulacion panelsimulacion;
	private Box boxH;   
	private ArrayList<objetoPuertos> arrayConexiones;
	private objetoPuertos conexion;
	
	
	
	
	public panelOpciones(panelSimulacion panelsimulacion){	
		
		this.panelsimulacion=panelsimulacion;
		arrayConexiones=new ArrayList<objetoPuertos>();	
		boxH=Box.createVerticalBox();		
		add(boxH);
		
		
	}
	
	public void limpiar(){
		
		arrayConexiones.clear();
		boxH.removeAll();
		
		
		
	}
	
	public void conexiones1(objetosPON objeto){
		
		if(panelSimulacion.keyObjeto==14){
			//como es el enlace tenemos que poner el mouse normal para poder clickear en un enlace(boton)
			panelsimulacion.setCursor(null);
			//crea las conexiones deacuerdo a N puertos 
			for(int i=0;i<objeto.getdatosObjeto().getNpuertos();i++){
				
		        conexion=new objetoPuertos(i,true,panelsimulacion);   
			    boxH.add(conexion);
			    arrayConexiones.add(conexion);			    
			}
			
			if(objeto.getdatosObjeto().getKeyObjeto()==11){
				
				     for(int i=0;i<objeto.getdatosFibra().size();i++){					
				     //colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
				    	 
				     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(false);						
				     }
			}
			else if(objeto.getdatosObjeto().getKeyObjeto()==12){
				
				    try{
				    	int porto0=objeto.getFibraPort0().getNumero2();
				    	arrayConexiones.get(0).setEnabled(false);
				    	}
				    catch(NullPointerException  ex){
				    	System.out.println("no existe la fibra");
				    }
				    
				    /*
				    for(int i=0;i<objeto.getdatosFibra().size();i++){					
					//colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setEnabled(false);					
			        }*/
				      
			}
			else if(objeto.getdatosObjeto().getKeyObjeto()==13){
				
				
				try{
					int porto0=objeto.getFibraPort0().getNumero2();
			    	arrayConexiones.get(0).setEnabled(false);
			    	System.out.println("si se pudo");
			    	}
			    catch(NullPointerException  ex){
			    	System.out.println("no existe la fibra");
			    }
				
				 for(int i=0;i<objeto.getdatosFibra().size();i++){					
				     //colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
				    	 
				     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(false);						
				     } 
                    /*
                    for(int i=0;i<objeto.getdatosFibra().size();i++){
        				//identificamos el objeto en la bd de enlaces fibra
        				if(objeto.getdatosFibra().get(i).getObjeto1().equals(objeto)){
        					//colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
        					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(false);
        				}
        				else{arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setEnabled(false);}
        			}*/
				
			}
			
	
			
			
			
		}
		else if (panelSimulacion.keyObjeto==10){
	
	       for(int i=0;i<objeto.getdatosObjeto().getNpuertos();i++){
	    	   
	    	   conexion=new objetoPuertos(i,false,panelsimulacion);
	    	   boxH.add(conexion);
	    	   arrayConexiones.add(conexion);
		
		  }
	   
	     if(objeto.getdatosObjeto().getKeyObjeto()==11){
				
			     for(int i=0;i<objeto.getdatosFibra().size();i++){					
			     //colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
			     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(true);	
			     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setToolTipText(objeto.getdatosFibra().get(i).getNombre());
			     }
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==12){
			
			  try{
				    int porto0=objeto.getFibraPort0().getNumero2();
			    	arrayConexiones.get(0).setEnabled(true);
			    	arrayConexiones.get(0).setToolTipText(objeto.getFibraPort0().getNombre());
			    	}
			    catch(NullPointerException  ex){
			    	System.out.println("no existe la fibra");
			    }
			
			/*
			
			    for(int i=0;i<objeto.getdatosFibra().size();i++){					
				//colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
				arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setEnabled(true);	
				arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setToolTipText(objeto.getdatosFibra().get(i).getNombre());
		        }
			*/      
			      
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==13){
			
			try{
				int porto0=objeto.getFibraPort0().getNumero2();
		    	arrayConexiones.get(0).setEnabled(true);
		    	arrayConexiones.get(0).setToolTipText(objeto.getFibraPort0().getNombre());
		    	}
		    catch(NullPointerException  ex){
		    	System.out.println("no existe la fibra");
		    }
			
			 for(int i=0;i<objeto.getdatosFibra().size();i++){					
			     //colocamos en false aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
			    	 
			     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(true);
			     arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setToolTipText(objeto.getdatosFibra().get(i).getNombre());
			     } 
			
			
			/*
			
			for(int i=0;i<objeto.getdatosFibra().size();i++){
				//identificamos el objeto en la bd de enlaces fibra
				if(objeto.getdatosFibra().get(i).getObjeto1().equals(objeto)){
					//colocamos en true aquellas conexiones que conisiden con el numero de puertos del obj 1  asociados a la fibra
					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setEnabled(true);
					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero1()).setToolTipText(objeto.getdatosFibra().get(i).getNombre());
					}
				else{
					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setEnabled(true);
					arrayConexiones.get(objeto.getdatosFibra().get(i).getNumero2()).setToolTipText(objeto.getdatosFibra().get(i).getNombre());
					}
			}
			
		*/

	   }
		
		
		
		}
	}
}



