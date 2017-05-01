package fiberPON.Objetos;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import fiberPON.Valores.datosAtenuacion;
import fiberPON.Valores.datosFibra;
import fiberPON.Valores.datosObjeto;
import fiberPON.esenario.esenarioPrincipal;


public class ObjetoONT implements Serializable,objetosPON {	
	
	
	private datosObjeto datos;
	private ArrayList<datosFibra> arrayFibra;
	private ArrayList<datosFibra> arrayFibraPro;
	private ArrayList<datosAtenuacion> arrayAtenuacion;
	private int Npuertos;
	private datosFibra fibraPort0;
	
	public ObjetoONT(int x,int y,int keyID,int keyObjeto, Icon iconoObjeto,int tipoTec,String nombre1,String nombre2,String nombre3,boolean verNombre1
			,boolean verNombre2,boolean verNombre3,double loTx1,double loRx1,double loRx2,double PotTrasmision,double velocidadUp,double velocidadDown
			,double sensibilidad,double TimeUp,double RIN,double AnchoFte,double RelacionEx,double Maxpot,int Npuertos){
        
		this.Npuertos=Npuertos;		
		datos=new datosObjeto(nombre1,nombre2,nombre3, verNombre1, verNombre2, verNombre3,tipoTec,0, velocidadUp, velocidadDown, loTx1, 0, loRx1, loRx2, PotTrasmision, sensibilidad, TimeUp, RIN, AnchoFte, RelacionEx, Maxpot, this.Npuertos,0,x,y,keyID,keyObjeto,iconoObjeto);
	
		arrayFibra=new ArrayList<datosFibra>();
		arrayFibraPro=new ArrayList<datosFibra>();
		arrayAtenuacion=new ArrayList<datosAtenuacion>();
	}


	@Override
	public datosObjeto getdatosObjeto() {
		// TODO Auto-generated method stub
		return datos;
	}





	@Override
	public ArrayList<datosFibra> getdatosFibra() {
		// TODO Auto-generated method stub
		return arrayFibra;
	}


	@Override
	public ArrayList<datosAtenuacion> getdatosAtenuacion() {
		// TODO Auto-generated method stub
		return arrayAtenuacion;
	}


	@Override
	public void anadirArrayFibra(datosFibra fibra) {
		arrayFibra.add(fibra);
		
	}


	@Override
	public void anadirArrayAtenuacion(datosAtenuacion atenuacion) {
		arrayAtenuacion.add(atenuacion);
		
	}


	@Override
	public ArrayList<datosFibra> getdatosFibraPro() {
		// TODO Auto-generated method stub
		return arrayFibraPro;
	}


	@Override
	public void anadirArrayFibraPro(datosFibra fibra) {
		// TODO Auto-generated method stub
		arrayFibraPro.add(fibra);
	}


	@Override
	public datosFibra getFibraPort0() {
		// TODO Auto-generated method stub
		return fibraPort0;
	}


	@Override
	public void anadirdatosFibraPort0(datosFibra fibra) {
		fibraPort0=fibra;
		
	}



}

