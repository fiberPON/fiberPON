package fiberPON.dialogo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiberPON.Valores.datosFibra;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.crearArrayEmpalme;
import fiberPON.util.validarDatos;



public class dialogoPropiedadesPerdida extends JDialog {
	
	
	private ArrayList<JTextField> textfilearray;
	//varialbe que nos ayudara a redicir o aumentar la distancia
	private double mDistancia,sDistancia;
	private int verificar;
	public dialogoPropiedadesPerdida(dialogoPropiedadesEnlace padre,int NEmpalme,ArrayList<Double> perdidasArray,double DistanciaEnlace){
		
	super(padre,true);	
	
	setResizable(false);
	setLayout(null);
	setBounds(fiberPON.anchoPantalla/2-125,fiberPON.altoPantalla/2-95, 300,NEmpalme*30+100);	
	
	textfilearray=new ArrayList<JTextField>();	
		
	JLabel Atenuacion=new JLabel("Atenuacion [dB]");
	Atenuacion.setBounds(110, 0, 120	, 20);
	add(Atenuacion);
	JLabel Distancia=new JLabel("Distancia [Km]");
	Distancia.setBounds(210, 0, 120, 20);
    add(Distancia);

    
    sDistancia=0;
	for(int i=0;i<NEmpalme;i++){
		
         setAtenuacion(i,perdidasArray);
	
	}

	

	
	
	JButton Aceptar=new JButton("Aceptar");
	Aceptar.setBounds(50, NEmpalme*30+35, 70,25);
	add(Aceptar);
	Aceptar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		validarDatos validar=new validarDatos(textfilearray);
		double [] valor=new double[textfilearray.size()];
		valor=validar.convDouble();
		if(validar.isValidado()==true){
			verificar=0;
			//verificar si las distancias de empalme no superan la del enlace
			for(int y=0;y<textfilearray.size();y+=2){
				
		            if(valor[y+1]>DistanciaEnlace){					
				       JOptionPane.showMessageDialog(dialogoPropiedadesPerdida.this,"El valor Distancia Empalme: "+valor[y+1]+" No es valido");				       
				       verificar=1;
				    }		
			}
			
			if(verificar==0){
				
				padre.arrayPerdida.clear();
				mDistancia=0;
				for(int y=0;y<textfilearray.size();y+=2){
			
					padre.arrayPerdida.add(valor[y]);
					padre.arrayPerdida.add(valor[y+1]-mDistancia);
					mDistancia=valor[y+1];
				
					
				}
				//para enlace acentende
				for(int b=textfilearray.size()-1;b>=0;b-=2){
					
					padre.arrayPerdida2.add(valor[b-1]);
					padre.arrayPerdida2.add(valor[b]);
					
				}
				
				setVisible(false);	
			}
			
		}
		else{
			JOptionPane.showMessageDialog(dialogoPropiedadesPerdida.this,"Algunos de los valores introducidos son incorrectos");
			}
		
		
			
		}
	});
	JButton Cancelar=new JButton("Cancelar");
	Cancelar.setBounds(170, NEmpalme*30+35, 80, 25);
	add(Cancelar);
	Cancelar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		setVisible(false);
			
		}
	});
	
	setVisible(true);
	

	
	}	
	public void setAtenuacion(int i,ArrayList<Double> perdida){
		JLabel Empalme=new JLabel("Empalme Numero "+(i+1));
		Empalme.setBounds(5, 28+i*30, 100, 30);
		add(Empalme);		
		JTextField atenuacion=new JTextField(Double.toString(perdida.get(i*2)));		
	    atenuacion.setBounds(120,30+i*30 , 40, 20);
		add(atenuacion);	
		JTextField distancia=new JTextField(Double.toString(perdida.get((i*2)+1)+sDistancia));
		sDistancia=perdida.get(i*2+1);
		distancia.setBounds(220, 30+i*30, 40, 20);
		add(distancia);
		textfilearray.add(atenuacion);
		textfilearray.add(distancia);
	
		
	}

}