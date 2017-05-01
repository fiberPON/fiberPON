package fiberPON.Valores;

import java.io.Serializable;

public class datosAtenuacion implements Serializable {
	
	private int distancia;
	private double perdida;
		
	public datosAtenuacion(int distancia,double perdida){
		
		this.distancia=distancia;
		this.perdida=perdida;
		
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public double getPerdida() {
		return perdida;
	}

	public void setPerdida(double perdida) {
		this.perdida = perdida;
	}
	
	

}
