package fiberPON.menu;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class barraHerramientas extends JToolBar {

	private JButton botonNuevo;
	private JButton botonAbrir;
	private JButton botonGuardar;
	private JButton botonCopiar;
	private JButton botonBorrar;
	private JButton botonPegar;
	
	
	public barraHerramientas(ActionListener oyente){
		
		botonNuevo=Boton("imagenes\\botonNuevo.gif","Nuevo",oyente);
		botonNuevo.setEnabled(true);
		add(botonNuevo);
		botonAbrir=Boton("imagenes\\botonAbrir.gif","Abrir",oyente);
		botonAbrir.setEnabled(true);
		add(botonAbrir);
		botonGuardar=Boton("imagenes\\botonGuardar.gif","Guardar",oyente);
		add(botonGuardar);
		addSeparator();
		botonBorrar=Boton("imagenes\\botonCortar.gif","Borrar",oyente);
		add(botonBorrar);
		botonCopiar=Boton("imagenes\\botonCopiar.gif","Copiar",oyente);
		add(botonCopiar);
		botonPegar=Boton("imagenes\\botonPegar.gif","Pegar",oyente);
		add(botonPegar);
		
		

	}
	
	public void habGuardar(boolean habilitar){
		
		botonGuardar.setEnabled(habilitar);
		
	}
	
	public void habCopiarBorrar(boolean habilitar){
    	
    	botonCopiar.setEnabled(habilitar);
    	botonBorrar.setEnabled(habilitar);
    	
    }
	
    public void activarPegar(boolean habilitar){
 	   
    	botonPegar.setEnabled(habilitar);
    }
	
	public JButton Boton(String url,String texto,ActionListener oyente){
		ImageIcon imagen=new ImageIcon(url);
		JButton boton=new JButton(imagen);
		boton.setPreferredSize(new Dimension(25, 25));
		boton.setToolTipText(texto);
		boton.addActionListener(oyente);
		boton.setEnabled(false);
		return boton;
	}
}
