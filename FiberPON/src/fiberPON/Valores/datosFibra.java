package fiberPON.Valores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import java.util.ArrayList;

import fiberPON.Objetos.objetosPON;

public class datosFibra implements Serializable {
	
	private double distancia,atenuacionDown,atenuacionUp,atenuacionVideo,disCromaticaDown,disCromaticaUp,disCromaticaVideo,conector1,conector2,atenuacionEnlaceUP
	,atenuacionEnlaceDown,atenuacionEnlaceVideo,mSeguridad;
	
    private String nombre;
    private objetosPON objeto1,objeto2;
    private int numero1,numero2,NEmpalmes;
    private double sumaAtenuacionDown,sumaAtenuacionUp,sumaAtenuacionVideo;
    private ArrayList<Double> perdidaConectoresArray;
    private ArrayList<Double> perdidaConectoresArrayUp;
    
  
    
	public datosFibra(String nombre,objetosPON objeto1,objetosPON objeto2,int numero1,int numero2,double distancia,double atenuacionDown,double atenuacionUp,double atenuacionVideo,double disCromaticaDown,double disCromaticaUp,double disCromaticaVideo){
		
		this.nombre=nombre;
		this.objeto1=objeto1;
		this.objeto2=objeto2;
		this.numero1=numero1;
		this.numero2=numero2;
		this.distancia=distancia;
		this.atenuacionDown=atenuacionDown;
		this.atenuacionUp=atenuacionUp;
		this.atenuacionVideo=atenuacionVideo;
		this.disCromaticaDown=disCromaticaDown;
		this.disCromaticaUp=disCromaticaUp;
		this.disCromaticaVideo=disCromaticaVideo;
		perdidaConectoresArray=new ArrayList<Double>();
		perdidaConectoresArrayUp=new ArrayList<Double>();
		
	}
	

	public String getNombre() {
		return nombre;
	}


	
	public objetosPON getObjeto1() {
		calculos();
		return objeto1;
	}


	public void setObjeto1(objetosPON objeto1) {
		calculos();
		this.objeto1 = objeto1;
	}


	public objetosPON getObjeto2() {
		return objeto2;
	}


	public void setObjeto2(objetosPON objeto2) {
		this.objeto2 = objeto2;
	}
	
	


	public int getNumero1() {
		return numero1;
	}


	public int getNumero2() {
		return numero2;
	}
	


	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}


	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getDistancia() {
		
		return distancia;
	}

	public void setDistancia(double distancia) {
	    
		this.distancia = Math.abs(distancia);
		atenuacionEnlace();
	}

	public double getAtenuacionDown() {
		return atenuacionDown;
	}

	public void setAtenuacionDown(double atenuacionDown) {
		this.atenuacionDown = Math.abs(atenuacionDown);
		atenuacionEnlace();
	}

	public double getAtenuacionUp() {
		return atenuacionUp;
	}

	public void setAtenuacionUp(double atenuacionUp) {
		this.atenuacionUp = Math.abs(atenuacionUp);
		atenuacionEnlace();
	}

	public double getAtenuacionVideo() {
		return atenuacionVideo;
	}

	public void setAtenuacionVideo(double atenuacionVideo) {
		this.atenuacionVideo = Math.abs(atenuacionVideo);
		atenuacionEnlace();
	}

	public double getDisCromaticaDown() {
		return disCromaticaDown;
	}

	public void setDisCromaticaDown(double disCromaticaDown) {
		this.disCromaticaDown = disCromaticaDown;
	}
	
	
	public double getDisCromaticaUp() {
		return disCromaticaUp;
	}


	public void setDiCromaticaUp(double disCromaticaUp) {
		this.disCromaticaUp = disCromaticaUp;
	}


	public double getDisCromaticaVideo() {
		return disCromaticaVideo;
	}


	public void setDisCromaticaVideo(double disCromaticaVideo) {
		this.disCromaticaVideo = disCromaticaVideo;
	}


	public double getConector1() {
		return conector1;
	}


	public void setConector1(double conector1) {
		this.conector1 = Math.abs(conector1);
	}


	public double getConector2() {
		return conector2;
	}


	public void setConector2(double conector2) {
		this.conector2 = Math.abs(conector2);
	}
	
	


	public int getNEmpalmes() {
		return NEmpalmes;
	}


	public void setNEmpalmes(int nEmpalmes) {
		NEmpalmes = Math.abs(nEmpalmes);
	}
	public void atenuacionEnlace(){
		atenuacionEnlaceUP=atenuacionUp*distancia;
		atenuacionEnlaceDown=atenuacionDown*distancia;
		atenuacionEnlaceVideo=atenuacionVideo*distancia;
	}
	

	

	public double getpDisDown() {
		return 4*distancia*disCromaticaDown;
	}
	
	public double getpDisUp(){
		return 4*distancia*disCromaticaUp;
	}
	public double getpDisVideo(){
		return 4*distancia*disCromaticaVideo;
	}


	


	public double getmSeguridad() {
		return mSeguridad;
	}


	public void setmSeguridad(double mSeguridad) {
		this.mSeguridad = mSeguridad;
	}


	public double getAtenuacionEnlaceUP() {
		return atenuacionEnlaceUP;
	}


	public double getAtenuacionEnlaceDown() {
		return atenuacionEnlaceDown;
	}


	public double getAtenuacionEnlaceVideo() {
		return atenuacionEnlaceVideo;
	}


	public ArrayList<Double> getPerdidaConectoresArray() {
		return perdidaConectoresArray;
	}
	


	public ArrayList<Double> getPerdidaConectoresArrayUp() {
		return perdidaConectoresArrayUp;
	}


	public void setPerdidaConectoresArrayUp(ArrayList<Double> perdidaConectoresArrayUp) {
		this.perdidaConectoresArrayUp = perdidaConectoresArrayUp;
	}


	public void setPerdidaConectoresArray(ArrayList<Double> perdidaConectoresArray) {
		this.perdidaConectoresArray = perdidaConectoresArray;
	}


	public void dibujarLinea(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.blue);
		g2.drawLine(objeto1.getdatosObjeto().getX()+60,objeto1.getdatosObjeto().getY()+20,objeto2.getdatosObjeto().getX()+60,objeto2.getdatosObjeto().getY()+20);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}


	@Override
	public String toString() {
		return "datosFibra [objeto1=" + objeto1 + ", objeto2=" + objeto2 + ", numero1=" + numero1 + ", numero2="
				+ numero2 + "]";
	}
	
	public void calculos(){
		
		
		double emp=0;
		for(int i=0;i<perdidaConectoresArray.size();i+=2){			
			emp=emp+perdidaConectoresArray.get(i);			
		}
		sumaAtenuacionDown=objeto1.getdatosObjeto().getPotTrasmision()-objeto1.getdatosObjeto().getAtenuacion()-conector1-atenuacionEnlaceDown-conector2-mSeguridad-emp;
		sumaAtenuacionUp=objeto2.getdatosObjeto().getPotTrasmision()-objeto2.getdatosObjeto().getAtenuacion()-conector2-atenuacionEnlaceUP-conector1-mSeguridad-emp;
		sumaAtenuacionVideo=objeto1.getdatosObjeto().getPotTrasmision()-objeto1.getdatosObjeto().getAtenuacion()-conector1-atenuacionEnlaceVideo-conector2-mSeguridad-emp;
	}


	public double getSumaAtenuacionDown() {
		return sumaAtenuacionDown;
	}


	public double getSumaAtenuacionUp() {
		return sumaAtenuacionUp;
	}


	public double getSumaAtenuacionVideo() {
		return sumaAtenuacionVideo;
	}
	
	
	
	

	
}
