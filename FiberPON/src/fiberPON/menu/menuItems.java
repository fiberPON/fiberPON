package fiberPON.menu;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class menuItems extends JMenuItem {
	
	public menuItems(String name, ActionListener oyente){
		setEnabled(false);
	    setText(name);	
	    addActionListener(oyente);	
	}
	
	public menuItems(String name, ActionListener oyente,int tecla,int teclaE){
		setEnabled(false);
		setText(name);
		setAccelerator(KeyStroke.getKeyStroke(tecla,teclaE));	
	    addActionListener(oyente);
	}


}
