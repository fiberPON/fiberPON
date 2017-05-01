package fiberPON.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.objetosPON;

public class dibujoLineas implements Serializable {
	
	
	private objetosPON a,b;
	
	public dibujoLineas(objetosPON a,objetosPON b){
		
		
		this.a=a;
		this.b=b;
	
		
	}
	
	public void dibujarLinea(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.blue);
		g2.drawLine(a.getdatosObjeto().getX()+60,a.getdatosObjeto().getY()+20,b.getdatosObjeto().getX()+60,b.getdatosObjeto().getY()+20);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

		

}
