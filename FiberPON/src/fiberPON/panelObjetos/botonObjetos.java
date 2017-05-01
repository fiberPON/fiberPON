package fiberPON.panelObjetos;


import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import fiberPON.esenario.esenarioPrincipal;


public class botonObjetos extends JButton {
	
	private int keyObjeto;
	private Dimension d;
	private ImageIcon imagenObjeto;
	public botonObjetos(esenarioPrincipal oyente,String nombre, ImageIcon imagenObjeto, int keyObjeto){
		
		//tamaño del objeto en el panel de objetos
		d=new Dimension(50, 50);		
		this.imagenObjeto=imagenObjeto;
		this.keyObjeto=keyObjeto;
		setPreferredSize(d);
		setIcon(this.imagenObjeto);		
		setToolTipText(nombre);		
		addActionListener(oyente);
	
		
		
	}
	//devuelve el tipo de objeto keyObjeto
	public int getkeyObjeto(){		
		return keyObjeto;
	}
	//devuelve la imagen del objeto
	public Image getImagen(){
		return this.imagenObjeto.getImage();
	}
	@Override
	public String toString() {
		return "1";
	}
	
	
	

	

}


