package fiberPON.Valores;

import java.io.Serializable;

import javax.swing.Icon;

public class datosObjeto implements Serializable{
	
	private String nombre1;
	private String nombre2;
	private String nombre3;
	private boolean verNombre1;
	private boolean verNombre2;
	private boolean verNombre3;
	private int tipotec;  //Gpon = 1, Epon = 2;  
	private int velocidad;
	private double velocidadUp,velocidadUpReal;
	private double velocidadDown,velocidadDownReal;
	private double loTx1;
	private double loTx2;
	private double loRx1;
	private double loRx2;
	private double PotTrasmision;
	private double sensibilidad;
	private double TimeUp;
	private double RIN;
	private double AnchoFte;
	private double RelacionEx;
	private double Maxpot;
	private int Npuertos;
	private double atenuacion;
	private final int KeyID,KeyObjeto;//KeyID el numero unico del objeto, keyObjeto es el numero que identifica al tipo de objeto 
	private int x,y;
    private Icon iconoObjeto;
    private double sumaAtenuacionDown,sumaAtenuacionUp,sumaAtenuacionVideo;
    private double sumaDistancia,sumaDispersionDown,sumaDispersionVideo,sumaDispersionUp,sumaTdispersionVideo,sumaTdispersionUp;
    

	public datosObjeto(String nombre1,String nombre2,String nombre3,boolean verNombre1,boolean verNombre2,boolean verNombre3,int tipotec,int velocidad,double velocidadUp,double velocidadDown,double loTx1,double loTx2,double loRx1,double loRx2,double PotTrasmision
			,double sensibilidad,double TimeUp,double RIN,double AnchoFte,double RelacionEx,double Maxpot,int Npuertos,double atenuacion,int x,int y,int keyID,int KeyObjeto,Icon iconoObjeto){
		
		this.nombre1=nombre1;
		this.nombre2=nombre2;
		this.nombre3=nombre3;
		this.verNombre1=verNombre1;
		this.verNombre2=verNombre2;
		this.verNombre3=verNombre3;
		this.tipotec=tipotec;
		this.velocidad=velocidad;
		this.velocidadDown=velocidadDown;
		this.velocidadUp=velocidadUp;
		this.loTx1=loTx1;
		this.loTx2=loTx2;
		this.loRx1=loRx1;
		this.loRx2=loRx2;
		this.PotTrasmision=PotTrasmision;
		this.sensibilidad=sensibilidad;
		this.TimeUp=TimeUp;
		this.RIN=RIN;
		this.AnchoFte=AnchoFte;
		this.RelacionEx=RelacionEx;
		this.Maxpot=Maxpot;
		this.Npuertos=Npuertos;
		this.atenuacion=atenuacion;
		this.x=x;
		this.y=y;
		this.KeyID=keyID;
		this.KeyObjeto=KeyObjeto;
		this.iconoObjeto=iconoObjeto;
	    
		
	}

	

	public boolean isVerNombre2() {
		return verNombre2;
	}



	public void setVerNombre2(boolean verNombre2) {
		this.verNombre2 = verNombre2;
	}



	public boolean isVerNombre3() {
		return verNombre3;
	}



	public void setVerNombre3(boolean verNombre3) {
		this.verNombre3 = verNombre3;
	}



	public double getVelocidadUp() {
		return velocidadUp;
	}


	public void setVelocidadUp(double velocidadUp) {
		this.velocidadUp = velocidadUp;
	}


	public double getVelocidadDown() {
		return velocidadDown;
	}


	public void setVelocidadDown(double velocidadDown) {
		this.velocidadDown = velocidadDown;
	}


	public int getTipotec() {
		return tipotec;
	}


	public void setTipotec(int tipotec) {
		this.tipotec = tipotec;
	}


	public String getNombre1() {
		return nombre1;
	}


	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	


	public String getNombre2() {
		return nombre2;
	}



	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}



	public String getNombre3() {
		return nombre3;
	}



	public void setNombre3(String nombre3) {
		this.nombre3 = nombre3;
	}



	public boolean isVerNombre1() {
		return verNombre1;
	}


	public void setVerNombre1(boolean verNombre1) {
		this.verNombre1 = verNombre1;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
		if(velocidad==0){
		
			velocidadDownReal=1244.16;
			velocidadUpReal=155.52;
		}
		else if(velocidad==1){
		
			velocidadDownReal=1244.16;
			velocidadUpReal=622.08;
		}
		else if(velocidad==2){
		
			velocidadDownReal=1244.16;
			velocidadUpReal=1244.16;
		}
		else if(velocidad==3){

			velocidadDownReal=2488.32;
			velocidadUpReal=155.52;
		}
		else if(velocidad==4){
		
			velocidadDownReal=2488.32;
			velocidadUpReal=622.08;
		}
		else if(velocidad==5){
				
			velocidadDownReal=2488.32;
			velocidadUpReal=1244.16;
		}
		else if(velocidad==6){
			
			velocidadDownReal=2488.32;
			velocidadUpReal=2488.16;
		}
	
	}
	


	public double getVelocidadUpReal() {
		return velocidadUpReal;
	}


	public double getVelocidadDownReal() {
		return velocidadDownReal;
	}


	public double getLoTx1() {
		return loTx1;
	}


	public void setLoTx1(double loTx1) {
		this.loTx1 = loTx1;
	}


	public double getLoTx2() {
		return loTx2;
	}


	public void setLoTx2(double loTx2) {
		this.loTx2 = loTx2;
	}


	public double getLoRx1() {
		return loRx1;
	}


	public void setLoRx1(double loRx1) {
		this.loRx1 = loRx1;
	}
	
	public double getLoRx2() {
		return loRx2;
	}


	public void setLoRx2(double loRx2) {
		this.loRx2 = loRx2;
	}


	public double getPotTrasmision() {
		return PotTrasmision;
	}


	public void setPotTrasmision(double potTrasmision) {
		PotTrasmision = potTrasmision;
	}


	public double getSensibilidad() {
		return sensibilidad;
	}


	public void setSensibilidad(double sensibilidad) {
		this.sensibilidad = sensibilidad;
	}


	public double getTimeUp() {
		return TimeUp;
	}


	public void setTimeUp(double timeUp) {
		TimeUp = timeUp;
	}


	public double getRIN() {
		return RIN;
	}


	public void setRIN(double RIN) {
		this.RIN = RIN;
	}


	public double getAnchoFte() {
		return AnchoFte;
	}


	public void setAnchoFte(double anchoFte) {
		AnchoFte = anchoFte;
	}


	public double getRelacionEx() {
		return RelacionEx;
	}


	public void setRelacionEx(double relacionEx) {
		RelacionEx = relacionEx;
	}


	public double getMaxpot() {
		return Maxpot;
	}


	public void setMaxpot(double maxpot) {
		Maxpot = maxpot;
	}


	public int getNpuertos() {
		return Npuertos;
	}


	public void setNpuertos(int npuertos) {
		Npuertos = npuertos;
	}
	
	public double getAtenuacion() {
		return atenuacion;
	}


	public void setAtenuacion(double atenuacion) {
		this.atenuacion = atenuacion;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Icon getIconoObjeto() {
		return iconoObjeto;
	}


	public void setIconoObjeto(Icon iconoObjeto) {
		this.iconoObjeto = iconoObjeto;
	}


	public int getKeyID() {
		return KeyID;
	}


	public int getKeyObjeto() {
		return KeyObjeto;
	}



	public double getSumaAtenuacionDown() {
		return sumaAtenuacionDown;
	}



	public void setSumaAtenuacionDown(double sumaAtenuacionDown) {
		
		this.sumaAtenuacionDown = sumaAtenuacionDown;
	}
	



	public double getSumaAtenuacionUp() {
		return sumaAtenuacionUp;
	}



	public void setSumaAtenuacionUp(double sumaAtenuacionUp) {
		this.sumaAtenuacionUp = sumaAtenuacionUp;
	}



	public double getSumaAtenuacionVideo() {
		return sumaAtenuacionVideo;
	}



	public void setSumaAtenuacionVideo(double sumaAtenuacionVideo) {
		
		this.sumaAtenuacionVideo = sumaAtenuacionVideo;
		
	}



	public double getSumaDistancia() {
		return sumaDistancia;
	}



	public void setSumaDistancia(double sumaDistancia) {
		this.sumaDistancia = sumaDistancia;
	}



	public double getSumaDispersionDown() {
		return sumaDispersionDown;
	}



	public void setSumaDispersionDown(double sumaDispersionDown) {
		this.sumaDispersionDown = sumaDispersionDown;
	}

	


	public double getSumaDispersionVideo() {
		return sumaDispersionVideo;
	}



	public void setSumaDispersionVideo(double sumaDispersionVideo) {
		this.sumaDispersionVideo = sumaDispersionVideo;
	}



	public double getSumaDispersionUp() {
		return sumaDispersionUp;
	}



	public void setSumaDispersionUp(double sumaDispersionUp) {
		this.sumaDispersionUp = sumaDispersionUp;
	}



	public double getAtenuacionTotalDown() {
		return sumaAtenuacionDown-sumaDispersionDown;
	}
	public void setAtenuacionTotalDownO(){
		sumaAtenuacionDown=0;
		sumaDispersionDown=0;
		
	}
	
	public double getAtenuacionTotalVideo(){
		return sumaAtenuacionVideo-sumaDispersionVideo;
	}
	
	public double getAtenuacionTotalUp() {
		return sumaAtenuacionUp-sumaDispersionUp;
	}
	
	public double laMenorAtenuacion(){
		
		if((sumaAtenuacionDown-sumaDispersionDown)>(sumaAtenuacionVideo-sumaDispersionVideo)){
			return sumaAtenuacionVideo-sumaDispersionVideo;
		}
		else{return sumaAtenuacionDown-sumaDispersionDown;}
	}



	public double getSumaTdispersionVideo() {
		return sumaTdispersionVideo;
	}



	public void setSumaTdispersionVideo(double sumaTdispersionVideo) {
		this.sumaTdispersionVideo = sumaTdispersionVideo;
	}



	public double getSumaTdispersionUp() {
		return sumaTdispersionUp;
	}



	public void setSumaTdispersionUp(double sumaTdispersionUp) {
		this.sumaTdispersionUp = sumaTdispersionUp;
	}
	

    
	

}
