package fiberPON.comandosdeMenu;


import java.io.Serializable;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.objetosPON;




public class copiarObjeto implements Serializable {
	
	private objetosPON objetoCopiado;
	
	
	

	
	public copiarObjeto(ObjetoSimulacion objetosimulacion){
		
		objetoCopiado=objetosimulacion.getObjetosPON();
		
	}

	public objetosPON getObjetoCopiado() {
		return objetoCopiado;
	}
	

	
	

}
