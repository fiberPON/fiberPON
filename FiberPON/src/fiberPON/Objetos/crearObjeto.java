package fiberPON.Objetos;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;

import fiberPON.Valores.datosFibra;

import fiberPON.esenario.esenarioPrincipal;
import fiberPON.esenario.panelSimulacion;
import fiberPON.puertos.crearEnlace;
import fiberPON.puertos.objetoPuertos;
import fiberPON.util.dibujoLineas;



public class crearObjeto implements Serializable {
	

				
	private esenarioPrincipal esenarioprincipal;
	private int x,y;
	
	public static ArrayList<dibujoLineas> Lineas;	
	public static int keyIDLinea,cont_olt=0,cont_onu=0,cont_spliter=0;
	private ObjetoOLT objetoOLT;
	private ObjetoONT objetoONT;
	private ObjetoSplitter objetoSplitter;
	private objetosPON a;	
    public static int[] keys;
    private ActionEvent e1,e2;
    public static ArrayList<objetosPON> listaObjetos;
    public static ArrayList<datosFibra> enlaceFibra;
    public static ArrayList<objetosPON> objListONT;
    private crearEnlace crearenlace;
    
    public static ArrayList<ObjetoSimulacion> arraySimulacion;
	
	public crearObjeto(esenarioPrincipal esenarioprincipal){	
		
		this.esenarioprincipal=esenarioprincipal;
		//array de objetos
		listaObjetos=new ArrayList<objetosPON>();
		//array de lineas
		Lineas=new ArrayList<dibujoLineas>();
		//contruir array de keys
		keys=new int [3];
		objListONT=new ArrayList<objetosPON>();
		//array enlace fibra
		enlaceFibra=new ArrayList<datosFibra>();
		crearenlace=new crearEnlace();
		//array objetos simulacion
		arraySimulacion=new ArrayList<ObjetoSimulacion>();
	}
	
	public void NuevoObjoto(int x,int y){	
		
		this.x=x-65;
		this.y=y-25;
      
		if(panelSimulacion.keyObjeto==11){
		
			objetoOLT=new ObjetoOLT( this.x, this.y, cont_olt,panelSimulacion.keyObjeto, panelSimulacion.botonobjeto.getIcon(), esenarioPrincipal.tec, "OLT "+cont_olt,"","", true,false,false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
			listaObjetos.add(objetoOLT);				
			cont_olt++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoOLT);			
			keys[0]=cont_olt;
		}
		else if(panelSimulacion.keyObjeto==12){
			
			objetoONT=new ObjetoONT( this.x, this.y, cont_onu, panelSimulacion.keyObjeto, panelSimulacion.botonobjeto.getIcon(),esenarioPrincipal.tec, "ONT "+cont_onu,"","Pot. recibida: ", true,false,true, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
	
			listaObjetos.add(objetoONT);
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoONT);
			arraySimulacion.add(objetosimulacion);
			cont_onu++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);
			keys[1]=cont_onu;
			
		}
		else if(panelSimulacion.keyObjeto==13){
			
			objetoSplitter=new ObjetoSplitter(true,true,false,esenarioPrincipal.tec, panelSimulacion.botonobjeto.getIcon(), "Splitter "+cont_spliter,"1:8","", this.x, this.y, cont_spliter, panelSimulacion.keyObjeto, 8, 0);		
			listaObjetos.add(objetoSplitter);
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoSplitter);
			
			cont_spliter++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);	
			keys[2]=cont_spliter;
			
		}
			
	}
	public void NuevoObjeto(objetosPON objeto){
				
		
		if(objeto.getdatosObjeto().getKeyObjeto()==11){
			
			objetoOLT=new ObjetoOLT(objeto.getdatosObjeto().getX()+30, objeto.getdatosObjeto().getY()+30, cont_olt, 11, objeto.getdatosObjeto().getIconoObjeto(), objeto.getdatosObjeto().getTipotec(), 
					"copia "+objeto.getdatosObjeto().getNombre1(),objeto.getdatosObjeto().getNombre2(),objeto.getdatosObjeto().getNombre3(),objeto.getdatosObjeto().isVerNombre1(),objeto.getdatosObjeto().isVerNombre2(),objeto.getdatosObjeto().isVerNombre3(), objeto.getdatosObjeto().getVelocidad(), objeto.getdatosObjeto().getLoTx1()
					, objeto.getdatosObjeto().getLoTx2(),objeto.getdatosObjeto().getLoRx1() , objeto.getdatosObjeto().getPotTrasmision(),objeto.getdatosObjeto().getSensibilidad()
					,objeto.getdatosObjeto().getTimeUp(),objeto.getdatosObjeto().getRIN(),objeto.getdatosObjeto().getAnchoFte(),objeto.getdatosObjeto().getRelacionEx()
					,objeto.getdatosObjeto().getMaxpot(),objeto.getdatosObjeto().getNpuertos());
			
			
			listaObjetos.add(objetoOLT);	
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoOLT);
			cont_olt++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);
			keys[0]=cont_olt;
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==12){
				
	objetoONT=new ObjetoONT( objeto.getdatosObjeto().getX()+30, objeto.getdatosObjeto().getY()+30, cont_onu, 12,objeto.getdatosObjeto().getIconoObjeto(), objeto.getdatosObjeto().getTipotec(),"copia "+objeto.getdatosObjeto().getNombre1(),objeto.getdatosObjeto().getNombre2(),objeto.getdatosObjeto().getNombre3() 
			,objeto.getdatosObjeto().isVerNombre1(),objeto.getdatosObjeto().isVerNombre2(),objeto.getdatosObjeto().isVerNombre3(),objeto.getdatosObjeto().getLoTx1(),objeto.getdatosObjeto().getLoRx1(),objeto.getdatosObjeto().getLoRx2(),objeto.getdatosObjeto().getPotTrasmision()
			,objeto.getdatosObjeto().getVelocidadUp(),objeto.getdatosObjeto().getVelocidadDown(),objeto.getdatosObjeto().getSensibilidad(),objeto.getdatosObjeto().getTimeUp(),objeto.getdatosObjeto().getRIN(),
			objeto.getdatosObjeto().getAnchoFte(),objeto.getdatosObjeto().getRelacionEx(),objeto.getdatosObjeto().getMaxpot(),objeto.getdatosObjeto().getNpuertos());
			listaObjetos.add(objetoONT);
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoONT);
			arraySimulacion.add(objetosimulacion);
			cont_onu++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);
			keys[1]=cont_onu;
		}
		else if(objeto.getdatosObjeto().getKeyObjeto()==13){
			
			objetoSplitter=new ObjetoSplitter(objeto.getdatosObjeto().isVerNombre1(), objeto.getdatosObjeto().isVerNombre2(), objeto.getdatosObjeto().isVerNombre3(),objeto.getdatosObjeto().getTipotec(),objeto.getdatosObjeto().getIconoObjeto(),"copia "+objeto.getdatosObjeto().getNombre1(),objeto.getdatosObjeto().getNombre2(),objeto.getdatosObjeto().getNombre3(), objeto.getdatosObjeto().getX()+30
			,objeto.getdatosObjeto().getY()+30,cont_spliter , 13, objeto.getdatosObjeto().getNpuertos(), objeto.getdatosObjeto().getAtenuacion());
			listaObjetos.add(objetoSplitter);	
			ObjetoSimulacion objetosimulacion=new ObjetoSimulacion(esenarioprincipal,objetoSplitter);
			cont_spliter++;
			esenarioprincipal.EasyGponmenu.habGuardar(true);	
			keys[2]=cont_spliter;
		}
		
	}
	
	//el primer objeto al que se le hace click
	public void objeto1Enlace(objetosPON a,ActionEvent e){
	    e1=e;
	    this.a=a;
		
	}
	//el segundo objeto al que se le hace click
	public void objeto2Enlace(objetosPON b,ActionEvent e){
	    e2=e;
	
		//el numero de puerto(boton) al que se le hizo click
		objetoPuertos a1=(objetoPuertos)e1.getSource();
		objetoPuertos a2=(objetoPuertos)e2.getSource();
	
		//si los objetos sondiferentes
		if(a.getdatosObjeto().getKeyObjeto()!=b.getdatosObjeto().getKeyObjeto()){	
	
			//si el primer objeto es spliter
			if(a.getdatosObjeto().getKeyObjeto()==13){
				//si el otro es la OLT
				if(b.getdatosObjeto().getKeyObjeto()==11){
					if(a1.getNumero()==0){crearenlace.crearEnlaceObjeto(b, a, a2.getNumero(), a1.getNumero(),esenarioprincipal);}
				}
				//si el otro es la ONT
				else if(b.getdatosObjeto().getKeyObjeto()==12){
					if(a1.getNumero()!=0){
						
						crearenlace.crearEnlaceObjeto(a, b, a1.getNumero(), a2.getNumero(),esenarioprincipal);
						
						
						}
				}
			}
			//si el segundo objeto es spliter
			else if(b.getdatosObjeto().getKeyObjeto()==13){
				//si el otro es la OLT
				if(a.getdatosObjeto().getKeyObjeto()==11){
					if(a2.getNumero()==0){crearenlace.crearEnlaceObjeto(a, b, a1.getNumero(), a2.getNumero(),esenarioprincipal);}
				}
				//si el otro es la ONT
				else if(a.getdatosObjeto().getKeyObjeto()==12){
					if(a2.getNumero()!=0){crearenlace.crearEnlaceObjeto(b, a, a2.getNumero(), a1.getNumero(),esenarioprincipal);
					
					
					}
				}
			}
			//si son entre OLT  y ONU
			else if(a.getdatosObjeto().getKeyObjeto()==11){
				crearenlace.crearEnlaceObjeto(a, b, a1.getNumero(), a2.getNumero(),esenarioprincipal);
				
				
				}
			else{crearenlace.crearEnlaceObjeto(b, a, a2.getNumero(), a1.getNumero(),esenarioprincipal);
			
			
			}
			
		}
		//si son iguales solo para spliter
		else if(a.getdatosObjeto().getKeyObjeto()==13){
			//para que no sea la el mismo Spliter 
			if(a.getdatosObjeto().getKeyID()!=b.getdatosObjeto().getKeyID())
			{
				if(a1.getNumero()!=a2.getNumero()){					
					if(a1.getNumero()==0){
						
						crearenlace.crearEnlaceObjeto(b, a, a2.getNumero(), a1.getNumero(),esenarioprincipal);
					
					}
					else if(a2.getNumero()==0){
						crearenlace.crearEnlaceObjeto(a, b, a1.getNumero(), a2.getNumero(),esenarioprincipal);
						
						}
				   	
				}
				
				
			}
			
		}
	}


	
	
	
	
}