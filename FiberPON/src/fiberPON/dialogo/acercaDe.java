package fiberPON.dialogo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;

public class acercaDe extends JDialog{
	
	public acercaDe(esenarioPrincipal esenarioprincipal){
		super(esenarioprincipal,"Acerca de",true);
		setResizable(false);
		setBounds(fiberPON.anchoPantalla/2-200,fiberPON.altoPantalla/2-170, 400, 300);
		
		JLabel IMAGENPON=new JLabel();
		ImageIcon imagen=new ImageIcon("imagenes\\pon.png");
		IMAGENPON.setIcon(imagen);
	
		
		Box box0=Box.createHorizontalBox();
		box0.add(IMAGENPON);
		
		JLabel proyecto=new JLabel("Proyecto de Simulacion de redes PON");
		Font fuente=new Font("fuente",Font.BOLD,18);
		proyecto.setFont(fuente);
		Box box1=Box.createHorizontalBox();
		box1.add(proyecto);
		
		JTextPane byProyect=new JTextPane();
		byProyect.setText("\n Autor: David Huanca Mamani\n\n"+
		"            Toda contrubucion es bienvenida\n"+
		"            Simplemete enviar un correo electronico\n"+
		"            a: danovic18@hotmail.com");
		byProyect.setBackground(new Color(204, 204, 204));
		Font fuente1=new Font("fuente",Font.BOLD,14);
		byProyect.setEditable(false);
		byProyect.setFont(fuente1);
		
		Box box2=Box.createHorizontalBox();
		box2.add(byProyect);
		
		Box box=Box.createVerticalBox();
		box.add(Box.createVerticalStrut(10));
		box.add(box0);
		box.add(box1);
	
		box.add(box2);
		
		add(box);
		setVisible(true);
		
	}

}
