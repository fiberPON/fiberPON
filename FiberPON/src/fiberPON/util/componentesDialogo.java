package fiberPON.util;


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
import javax.swing.border.EtchedBorder;

import fiberPON.esenario.esenarioPrincipal;

public abstract  class componentesDialogo extends JDialog implements ActionListener{
	
	private componentesDialogo dialogoPropiedades;
	private JTextField valor,valor1,valor2;	
	private JTextField nombre;
	private JCheckBox verNombre;	
	
	public componentesDialogo(esenarioPrincipal esenarioprincipal,String name){		
	super(esenarioprincipal,"configuracion "+name,true);		
	
	}
	
	public void setDialogo(componentesDialogo dialogoPropiedades){		
		this.dialogoPropiedades=dialogoPropiedades;
		
		
	}
	
	public void setBotones(String aceptar, String cancelar){
		JButton Aceptar = new JButton(aceptar);
		JButton Cancelar = new JButton(cancelar);
		Aceptar.addActionListener(this.dialogoPropiedades);
		Cancelar.addActionListener(this.dialogoPropiedades);
		Box cajaBotones=Box.createHorizontalBox();	
		cajaBotones.add(Aceptar);
		cajaBotones.add(Box.createHorizontalStrut((int)(dialogoPropiedades.getWidth()*(0.37)-Aceptar.getSize().getWidth()-Cancelar.getSize().getWidth())));	
		cajaBotones.add(Cancelar);
	    cajaBotones.setBounds((int)(dialogoPropiedades.getWidth()*(0.10)),(int)(dialogoPropiedades.getHeight()*(0.85)),(int)(dialogoPropiedades.getWidth()*(0.8)),(int)(dialogoPropiedades.getHeight()*(0.08)));
	    
	    dialogoPropiedades.add(cajaBotones);
	}
	
	public void setBotonesCustom(String aceptar, String cancelar,int separacionInicial,int separacion,int y){
		JButton Aceptar = new JButton(aceptar);
		JButton Cancelar = new JButton(cancelar);
		Aceptar.addActionListener(this.dialogoPropiedades);
		Cancelar.addActionListener(this.dialogoPropiedades);
		Box cajaBotones=Box.createHorizontalBox();
		cajaBotones.add(Box.createHorizontalStrut(separacionInicial));	
		cajaBotones.add(Aceptar);
		cajaBotones.add(Box.createHorizontalStrut(separacion));	
		cajaBotones.add(Cancelar);
	    cajaBotones.setBounds(0,y,dialogoPropiedades.getWidth(),30);	    
	    dialogoPropiedades.add(cajaBotones);
	}
	
	public JTextField setCaracteristicas(int posY,String tipo,double dato,String unidades){
		
	    JLabel Tipo=new JLabel(tipo);
	    Tipo.setBounds(15,posY,170,20);
	    dialogoPropiedades.add(Tipo);
		valor=new JTextField(Double.toString(dato));
		valor.setBounds(240,posY, 40, 20);
		dialogoPropiedades.add(valor);
		JLabel unidad=new JLabel(unidades);
		unidad.setBounds(285,posY, 30, 20);
		dialogoPropiedades.add(unidad);
		return valor;
	  
	}
	
	public JTextField setCaracteristicasCustom(int posY,int x1,int x2,int x3,String tipo,double dato,String unidades){
		
	    JLabel Tipo=new JLabel(tipo);
	    Tipo.setBounds(x1,posY,170,20);
	    dialogoPropiedades.add(Tipo);
		valor=new JTextField(Double.toString(dato));
		valor.setBounds(x2,posY, 40, 20);
		dialogoPropiedades.add(valor);
		JLabel unidad=new JLabel(unidades);
		unidad.setBounds(x3,posY, 70, 20);
		dialogoPropiedades.add(unidad);
		return valor;
	  
	}
	
	
	public JTextField setCaracteristicasEntero(int posY,String tipo,int dato,String unidades){
		
	    JLabel Tipo=new JLabel(tipo);
	    Tipo.setBounds(15,posY,170,20);
	    dialogoPropiedades.add(Tipo);
		valor=new JTextField(Integer.toString(dato));
		valor.setBounds(240,posY, 40, 20);
		dialogoPropiedades.add(valor);
		JLabel unidad=new JLabel(unidades);
		unidad.setBounds(285,posY, 30, 20);
		dialogoPropiedades.add(unidad);
		return valor;
	  
	}
	public JTextField setCaracteristicasEnteroCustom(int posY,int x1,int x2,int x3,String tipo,int dato,String unidades){
		
	    JLabel Tipo=new JLabel(tipo);
	    Tipo.setBounds(x1,posY,170,20);
	    dialogoPropiedades.add(Tipo);
		valor=new JTextField(Integer.toString(dato));
		valor.setBounds(x2,posY, 40, 20);
		dialogoPropiedades.add(valor);
		JLabel unidad=new JLabel(unidades);
		unidad.setBounds(x3,posY, 30, 20);
		dialogoPropiedades.add(unidad);
		return valor;
	  
	}
	public JTextField [] setCaracteristicas2(int posY,String tipo,double dato1,double dato2,String unidades){
		
	    JLabel Tipo=new JLabel(tipo);
	    Tipo.setBounds(15,posY,120,20);
	    dialogoPropiedades.add(Tipo);
		valor1=new JTextField(Double.toString(dato1));
		valor1.setBounds(195,posY, 40, 20);
		valor2=new JTextField(Double.toString(dato2));
		valor2.setBounds(240,posY, 40, 20);
		dialogoPropiedades.add(valor1);
		dialogoPropiedades.add(valor2);
		JLabel unidad=new JLabel(unidades);
		unidad.setBounds(285,posY, 30, 20);
		dialogoPropiedades.add(unidad);
		JTextField [] textfile=new JTextField[2];
		textfile[0]=valor1;
		textfile[1]=valor2;
		return textfile;
	  
	}
	
	public void setImagenTitulo(int posY,Icon iconoObjeto, String descripcion){
		JLabel imagenObjeto=new JLabel();	
		imagenObjeto.setIcon(iconoObjeto);	
		JLabel descripcionObjeto=new JLabel(descripcion);	
		Box caja=Box.createHorizontalBox();
		caja.setBounds(0, posY,dialogoPropiedades.getWidth(),iconoObjeto.getIconHeight());
		caja.add(Box.createHorizontalStrut(10));
		caja.add(imagenObjeto);
		caja.add(Box.createHorizontalStrut(10));	
		caja.add(descripcionObjeto);
		caja.add(Box.createHorizontalStrut(150));
		
		dialogoPropiedades.add(caja);
		
	}
	
	public void setNombreObjeto(int posY,String labelNombre,String Jtextfile,boolean isNombre){
		
		JLabel nombreObj=new JLabel(labelNombre);
		Box caja1=Box.createHorizontalBox();
		caja1.add(nombreObj);
		caja1.add(Box.createHorizontalStrut(235));
		
		nombre=new JTextField(Jtextfile,15);
		nombre.setMaximumSize(nombre.getPreferredSize());		
		verNombre=new JCheckBox("Mostrar Nombre");	
		verNombre.setSelected(isNombre);		
		Box caja2=Box.createHorizontalBox();
		caja2.add(nombre);
		caja2.add(Box.createHorizontalStrut(95));
		caja2.add(verNombre);		
		Box boxvertical=Box.createVerticalBox();
		boxvertical.setBounds(0, posY,dialogoPropiedades.getWidth(),40);
		
		boxvertical.add(caja1);
		boxvertical.add(caja2);
		dialogoPropiedades.add(boxvertical);
		
	}
	
	public void setNombreObjetoCustom(int posY,int x1,int x2,int x3,int x4,String labelNombre,String Jtextfile,boolean isNombre){
		
		JLabel nombreObj=new JLabel(labelNombre);
		Box caja1=Box.createHorizontalBox();					
		caja1.add(nombreObj);
		caja1.add(Box.createHorizontalStrut(x1));	
		
		nombre=new JTextField(Jtextfile,15);
		nombre.setMaximumSize(nombre.getPreferredSize());		
		verNombre=new JCheckBox("Mostrar Nombre");	
		verNombre.setSelected(isNombre);		
		Box caja2=Box.createHorizontalBox();
		caja2.add(Box.createHorizontalStrut(x2));
		caja2.add(nombre);
		caja2.add(Box.createHorizontalStrut(x3));
		caja2.add(verNombre);
		caja2.add(Box.createHorizontalStrut(x4));
		Box boxvertical=Box.createVerticalBox();
		boxvertical.setBounds(0, posY,dialogoPropiedades.getWidth(),40);		
		boxvertical.add(caja1);
		boxvertical.add(caja2);
		dialogoPropiedades.add(boxvertical);
		
	}
	
	public String darNombre(){
		return nombre.getText();
	}
	public boolean darVerNombre(){
		return verNombre.isSelected();
	}	
}
