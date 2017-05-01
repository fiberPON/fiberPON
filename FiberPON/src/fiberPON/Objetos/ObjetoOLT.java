package fiberPON.Objetos;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import fiberPON.Valores.datosAtenuacion;
import fiberPON.Valores.datosFibra;
import fiberPON.Valores.datosObjeto;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.puertos.objetoPuertos;

public class ObjetoOLT implements Serializable,objetosPON{	
	
	

	
	private datosObjeto datos;
	private ArrayList<datosFibra> arrayFibra;
	private ArrayList<datosFibra> arrayFibraPro;
	private ArrayList<datosAtenuacion> arrayAtenuacion;	

	
	public ObjetoOLT(int x,int y,int keyID,int keyObjeto, Icon iconoObjeto,int tipotec,String nombre1,String nombre2,String nombre3,boolean verNombre1,
			boolean verNombre2,boolean verNombre3,int velocidad,double loTx1,double loTx2,double loRx1,double PotTrasmision
			,double sensibilidad,double TimeUp,double RIN,double AnchoFte,double RelacionEx,double Maxpot,int Npuertos){
        
	
		
		datos=new datosObjeto(nombre1,nombre2, nombre3,verNombre1, verNombre2, verNombre3, tipotec, velocidad, 0, 0, loTx1, loTx2, loRx1, 0.0, PotTrasmision, sensibilidad, TimeUp, RIN, AnchoFte, RelacionEx, Maxpot, Npuertos,0,x,y,keyID,keyObjeto,iconoObjeto);
		
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
		return null;
	}


	@Override
	public void anadirdatosFibraPort0(datosFibra fibra) {
		// TODO Auto-generated method stub
		
	}


	
	
	





	



}
