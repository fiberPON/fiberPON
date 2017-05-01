package fiberPON.comandosdeMenu;


import java.io.Serializable;

import fiberPON.Objetos.objetosPON;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.esenario.esenarioSimulacion;


public class pegarObjeto implements Serializable {
	

	
	public pegarObjeto(esenarioPrincipal framepadre,objetosPON objeto){
		
	
		framepadre.esenariosimulacion.panelsimulacion.sistemacrearobjetos.NuevoObjeto(objeto);
		
	}
	


}
