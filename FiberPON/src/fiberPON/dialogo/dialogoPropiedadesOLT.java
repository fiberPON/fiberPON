package fiberPON.dialogo;


import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import fiberPON.Objetos.objetosPON;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.componentesDialogo;
import fiberPON.util.validarDatos;



public class dialogoPropiedadesOLT extends componentesDialogo  {		
 
	private JComboBox<String> comboDeVelocidades;	
	private objetosPON objeto;	
	private JTextField[] textfile;
	private ArrayList<JTextField> textfilearray;
	private double [] valor=new double[6];
	
	public dialogoPropiedadesOLT(esenarioPrincipal esenariosimulacion,objetosPON objeto){		
    super(esenariosimulacion,objeto.getdatosObjeto().getNombre1());
    this.objeto=objeto;
    
    
    textfilearray=new ArrayList<JTextField>();
    setDialogo(this);
    //desactivar el cambio de tamaño
	setResizable(false);	
	//tamaño del cuadro de dialogo OLT
	setBounds(fiberPON.anchoPantalla/2-175,fiberPON.altoPantalla/2-270,350, 450);
	//layout nulo
	setLayout(null);
	//imagen mas nombre de la imagen	
	setImagenTitulo(10,objeto.getdatosObjeto().getIconoObjeto(),"Terminal de Linea Optica");
	//nombre del objeto
	setNombreObjeto(65,"Nombre de la OLT",this.objeto.getdatosObjeto().getNombre1(),this.objeto.getdatosObjeto().isVerNombre1());
	//label de velocidad
	JLabel veloTransmision=new JLabel("Velocidad de Transmision");
	Box caja1=Box.createHorizontalBox();
	caja1.add(veloTransmision);	
	caja1.add(Box.createHorizontalStrut(200));
    //comboBox para las velocidades permitidas
	String [] velocidadesGpon=new String[7];	
	velocidadesGpon[0]="1244,16 Mbit/s decendete, 155,52 Mbit/s acendente";
	velocidadesGpon[1]="1244,16 Mbit/s decendete, 622,08 Mbit/s acendente";
	velocidadesGpon[2]="1244,16 Mbit/s decendete, 1244,16 Mbit/s acendente";	
	velocidadesGpon[3]="2488,32 Mbit/s decendete, 155,52 Mbit/s acendente";
	velocidadesGpon[4]="2488,32 Mbit/s decendete, 622,08 Mbit/s acendente";
	velocidadesGpon[5]="2488,32 Mbit/s decendete, 1244,16 Mbit/s acendente";	
	velocidadesGpon[6]="2488,32 Mbit/s decendete, 2488,32 Mbit/s acendente";
	
	String [] velocidadesEpon=new String[1];	

	velocidadesEpon[0]="1244,16 Mbit/s decendete, 1244,16 Mbit/s acendente";	

	//tipo de velocidad 
	if(objeto.getdatosObjeto().getTipotec()==1){
	comboDeVelocidades=new JComboBox<String>(velocidadesGpon);	
	}
	else{
	comboDeVelocidades=new JComboBox<String>(velocidadesEpon);
	}	
	//set la velocidad guardada
	comboDeVelocidades.setSelectedIndex(objeto.getdatosObjeto().getVelocidad());
	comboDeVelocidades.setMaximumSize(comboDeVelocidades.getPreferredSize());	
	Box caja2=Box.createHorizontalBox();
	caja2.add(comboDeVelocidades);
	caja2.add(Box.createHorizontalStrut(30));
    Box cajavertical1=Box.createVerticalBox();
    cajavertical1.add(caja1);
    cajavertical1.add(caja2);
    cajavertical1.setBounds(0, 115, getWidth(),40);  
    add(cajavertical1);    
    //datos de la OLT
	//textfile=setCaracteristicas2(165,"Long. de onda de Tx",1490,1550,"nm");
	//textfilearray.add(textfile[0]);
	//textfilearray.add(textfile[1]);
	
	JLabel lonTx=new JLabel("Longitud de onda para Tx: 1490 nm y 1550 nm");
	lonTx.setBounds(15, 165, 300, 30);
	add(lonTx);
	
	//textfilearray.add(setCaracteristicas(190,"Long. de onda de Rx",1310,"nm"));
	
	JLabel lonRx=new JLabel("Longitud de onda para Rx: 1310 nm");
	lonRx.setBounds(15, 190, 200, 30);
	add(lonRx);
	
	textfilearray.add(setCaracteristicas(215,"Potencia de Transmision",objeto.getdatosObjeto().getPotTrasmision(),"dBm"));
	textfilearray.add(setCaracteristicas(240,"Sensibilidad",objeto.getdatosObjeto().getSensibilidad(),"dBm"));	
	textfilearray.add(setCaracteristicas(265,"Tiempo de subida ",objeto.getdatosObjeto().getTimeUp(),"ps"));
	textfilearray.add(setCaracteristicas(290,"RIN",objeto.getdatosObjeto().getRIN(),"dB/Hz"));
	textfilearray.add(setCaracteristicas(315,"Ancho espectral de la fuente",objeto.getdatosObjeto().getAnchoFte(),"nm"));
	//textfilearray.add(setCaracteristicas(340,"Relacion de extincion",objeto.getdatosObjeto().getRelacionEx(),"dB"));
	//textfilearray.add(setCaracteristicas(340,"Max. pot. de entrada",objeto.getdatosObjeto().getMaxpot(),"dBm"));
	textfilearray.add(setCaracteristicasEntero(340,"Numero de Puertos",objeto.getdatosObjeto().getNpuertos(),"N"));
	
	//botones ACEPTAR, CANCELAR
	setBotones("Aceptar","Cancelar");
	setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {    
		
		if(e.getActionCommand().compareTo("Aceptar")==0){
			
			validarDatos validar=new validarDatos(textfilearray);
			valor=validar.convDouble();
			if(validar.isValidado()==true){				
				//objeto.getdatosObjeto().setLoTx1(valor[0]);
				//objeto.getdatosObjeto().setLoTx2(valor[1]);
				//objeto.getdatosObjeto().setLoRx1(valor[2]);
				objeto.getdatosObjeto().setPotTrasmision(valor[0]);
				objeto.getdatosObjeto().setSensibilidad(valor[1]);
				objeto.getdatosObjeto().setTimeUp(valor[2]);
				objeto.getdatosObjeto().setRIN(valor[3]);
				objeto.getdatosObjeto().setAnchoFte(valor[4]);		
				//objeto.getdatosObjeto().setRelacionEx(valor[8]);
				//objeto.getdatosObjeto().setMaxpot(valor[8]);
				objeto.getdatosObjeto().setNpuertos((int)valor[5]);			
				objeto.getdatosObjeto().setNombre1(darNombre());
				objeto.getdatosObjeto().setVerNombre1(darVerNombre());
				objeto.getdatosObjeto().setVelocidad(comboDeVelocidades.getSelectedIndex());
			
				calculoRed.Calculo();
				setVisible(false);	
			}
			else{
				JOptionPane.showMessageDialog(this,"Algunos de los valores introducidos son incorrectos","alerta", JOptionPane.ERROR_MESSAGE);
				}						
		}
		else if(e.getActionCommand().compareTo("Cancelar")==0){
			setVisible(false);
		}
		
	}	

}
