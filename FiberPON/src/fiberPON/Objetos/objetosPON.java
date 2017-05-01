package fiberPON.Objetos;

import java.util.ArrayList;

import fiberPON.Valores.datosAtenuacion;
import fiberPON.Valores.datosFibra;
import fiberPON.Valores.datosObjeto;


public interface objetosPON{
	
 
    
    //datos objeto
    public datosObjeto getdatosObjeto();
    
    //get and set datos fibra
    public ArrayList<datosFibra> getdatosFibra();
    public void anadirArrayFibra(datosFibra fibra);
    
    //get and set datos fibraPro
    public ArrayList<datosFibra> getdatosFibraPro();
    public void anadirArrayFibraPro(datosFibra fibra);
    
    //get datos atenuacion
    public ArrayList<datosAtenuacion> getdatosAtenuacion(); 
    
    
    public void anadirArrayAtenuacion(datosAtenuacion atenuacion);
    
    //prueba entrada
    public datosFibra getFibraPort0();
    public void anadirdatosFibraPort0(datosFibra fibra);
    
    
    	
}
