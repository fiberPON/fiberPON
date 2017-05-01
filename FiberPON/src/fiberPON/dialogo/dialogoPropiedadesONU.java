package fiberPON.dialogo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.calculosResuldados.resultados;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.componentesDialogo;
import fiberPON.util.validarDatos;



public class dialogoPropiedadesONU extends componentesDialogo {
		
	private objetosPON objeto;
	private JTextField[] textfile;
	private ArrayList<JTextField> textfilearray;
	private double [] valor=new double[7];
	private double maxDistancia,minDistancia;
	private objetosPON objMax,objMin;
	private String distanciaAlerta;
	public dialogoPropiedadesONU(esenarioPrincipal esenariosimulacion,objetosPON objeto){		
    super(esenariosimulacion,objeto.getdatosObjeto().getNombre1());
    //cogemos datos ONT
    this.objeto=objeto;
    //array de caracteristicas
    textfilearray=new ArrayList<JTextField>();
    
    setDialogo(this);
    //desactiar cambio de tamaño
	setResizable(false);
	//tamaño de la ventana dialogo ont
	setBounds(fiberPON.anchoPantalla/2-175,fiberPON.altoPantalla/2-270,350, 450);    
	//layuot nulo
	setLayout(null);
	//imagen mas descripcion		
	setImagenTitulo(10,objeto.getdatosObjeto().getIconoObjeto(),"Terminal de Red Optica");
	//nombre de la onu
	setNombreObjeto(65,"Nombre de la ONT",objeto.getdatosObjeto().getNombre1(),this.objeto.getdatosObjeto().isVerNombre1());
	
	textfilearray.add(setCaracteristicas(165,"Velocidad de transmision downlink",objeto.getdatosObjeto().getVelocidadDown(),"Mbps"));
	textfilearray.add(setCaracteristicas(190,"Velocidad de transmision uplink",objeto.getdatosObjeto().getVelocidadUp(),"Mbps"));
	//textfile=setCaracteristicas2(190,"Long. de onda de Rx",1490,1550,"nm");
	JLabel lonRx=new JLabel("Longitud de onda de Rx: 1490 nm y 1550 nm");
	lonRx.setBounds(15, 140, 300, 30);
	add(lonRx);
	//textfilearray.add(textfile[0]);
	//textfilearray.add(textfile[1]);	
	//textfilearray.add(setCaracteristicas(165,"Long. de onda de Tx",1310,"nm"));	
	JLabel lonTx=new JLabel("Longitud de onda de Tx: 1310 nm");
	lonTx.setBounds(15, 115, 200, 30);
	add(lonTx);
	textfilearray.add(setCaracteristicas(215,"Potencia de Transmision",objeto.getdatosObjeto().getPotTrasmision(),"dBm"));
	textfilearray.add(setCaracteristicas(240,"Sensibilidad",objeto.getdatosObjeto().getSensibilidad(),"dBm"));	
	textfilearray.add(setCaracteristicas(265,"Tiempo de subida ",objeto.getdatosObjeto().getTimeUp(),"ps"));
	textfilearray.add(setCaracteristicas(290,"RIN",objeto.getdatosObjeto().getRIN(),"dB/Hz"));
	textfilearray.add(setCaracteristicas(315,"Ancho espectral de la fuente",objeto.getdatosObjeto().getAnchoFte(),"nm"));
	//textfilearray.add(setCaracteristicas(340,"Relacion de extincion",objeto.getdatosObjeto().getRelacionEx(),"dB"));
	//textfilearray.add(setCaracteristicas(340,"Max. pot. de entrada",objeto.getdatosObjeto().getMaxpot(),"dBm"));	
	
	JButton Grafica=new JButton("Ver Resultados");
	Grafica.setBounds(113, 350, 120, 20);
	add(Grafica);
	Grafica.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			
	        maxDistancia=crearObjeto.objListONT.get(0).getdatosObjeto().getSumaDistancia();
	        minDistancia=crearObjeto.objListONT.get(0).getdatosObjeto().getSumaDistancia();
	        
	        //hallar la maxima y minima distancia como la maxima y minima potencia
	        for(int d=1;d<crearObjeto.objListONT.size();d++){
	        	
	        	if(maxDistancia<crearObjeto.objListONT.get(d).getdatosObjeto().getSumaDistancia()){
	        		maxDistancia=crearObjeto.objListONT.get(d).getdatosObjeto().getSumaDistancia();
	        		objMax=crearObjeto.objListONT.get(d);
	        	}
	        	else{
	        		if(minDistancia>crearObjeto.objListONT.get(d).getdatosObjeto().getSumaDistancia()){
		        		minDistancia=crearObjeto.objListONT.get(d).getdatosObjeto().getSumaDistancia();
		        		objMin=crearObjeto.objListONT.get(d);
		        	}
	        	} 
	        	
	        }
	        if(maxDistancia>(minDistancia+20)){
	        	distanciaAlerta="   Existe una distancia Diferencial Mayor a 20 Km";
	        }  
	        else{distanciaAlerta="";}
			
		//Grafica grafica=new Grafica(dialogoPropiedadesONU.this,objeto);
		resultados grafica=new resultados(dialogoPropiedadesONU.this,objeto,distanciaAlerta);
		
		}
	});
	
	setBotones("Aceptar","Cancelar");
	setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {          
		if(e.getActionCommand().compareTo("Aceptar")==0){
			validarDatos validar=new validarDatos(textfilearray);
			valor=validar.convDouble();
			if(validar.isValidado()==true){				
				
				objeto.getdatosObjeto().setVelocidadDown(valor[0]);
				objeto.getdatosObjeto().setVelocidadUp(valor[1]);
				//objeto.getdatosObjeto().setLoRx1(valor[2]);
				//objeto.getdatosObjeto().setLoRx2(valor[3]);
				//objeto.getdatosObjeto().setLoTx1(valor[4]);				
				objeto.getdatosObjeto().setPotTrasmision(valor[2]);
				objeto.getdatosObjeto().setSensibilidad(valor[3]);
				objeto.getdatosObjeto().setTimeUp(valor[4]);
				objeto.getdatosObjeto().setRIN(valor[5]);
				objeto.getdatosObjeto().setAnchoFte(valor[6]);		
				//objeto.getdatosObjeto().setRelacionEx(valor[10]);
				//objeto.getdatosObjeto().setMaxpot(valor[10]);					
				objeto.getdatosObjeto().setNombre1(darNombre());
				objeto.getdatosObjeto().setVerNombre1(darVerNombre());
			
				calculoRed.Calculo();
				setVisible(false);	
			}
			else {
				JOptionPane.showMessageDialog(this,"Algunos de los valores introducidos son incorrectos");
			}
		
			
			
		}
		else if(e.getActionCommand().compareTo("Cancelar")==0){
			setVisible(false);
		}
		
	}	

}