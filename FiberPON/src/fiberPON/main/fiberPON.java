package fiberPON.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

import fiberPON.esenario.esenarioPrincipal;


public class fiberPON{

	//Valores de pc host
	public static final Toolkit tk =Toolkit.getDefaultToolkit();
	public static final Dimension tamanoPantalla =tk.getScreenSize();
	public static final int altoPantalla =tamanoPantalla.height;
	public static final int anchoPantalla =tamanoPantalla.width;   
	
	
	public static void main(String[] args) {
		
		// Look and Feel 
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); }
		catch (Exception e)
			 { System.out.println("No se ha podido cambiar la interfaz"); }
		
		//Instancia del Esenario Principal
		esenarioPrincipal esenarioprincipal = new esenarioPrincipal();	
		//No hacer nada si se preciona la X
		esenarioprincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		esenarioprincipal.setVisible(true);
			
	}
	
}  
// existe dos errores si abres un proyecto no se puede cerrar sin guardar
//acepta valores numericos si terminan con f o l