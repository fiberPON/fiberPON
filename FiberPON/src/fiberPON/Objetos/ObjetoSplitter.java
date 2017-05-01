package fiberPON.Objetos;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import fiberPON.Valores.datosAtenuacion;
import fiberPON.Valores.datosFibra;
import fiberPON.Valores.datosObjeto;
import fiberPON.esenario.esenarioPrincipal;



public class ObjetoSplitter implements Serializable, objetosPON {
	
	
	
		
	private datosObjeto datos;
	private ArrayList<datosFibra> arrayFibra;
    private ArrayList<datosFibra> arrayFibraPro;
	private ArrayList<datosAtenuacion> arrayAtenuacion;
	private datosFibra fibraPort0;
	private int Npuertos;
	public ObjetoSplitter(boolean verNombre1,boolean verNombre2,boolean verNombre3,int tipotec, Icon iconoObjeto,String nombre1,String nombre2,String nombre3,int pX,int pY,int keyID,int keyObjeto,
			int Npuertos,double atenuacion){

		this.Npuertos=Npuertos+1;		
		datos=new datosObjeto(nombre1,nombre2, nombre3,verNombre1, verNombre2, verNombre3, tipotec, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, this.Npuertos, atenuacion,pX,pY,keyID,keyObjeto,iconoObjeto);
		
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