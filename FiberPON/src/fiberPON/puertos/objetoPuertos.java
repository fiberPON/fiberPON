package fiberPON.puertos;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.esenario.panelSimulacion;

public class objetoPuertos extends JButton {
	
	private int N;
		
		public objetoPuertos(int N,boolean activar,panelSimulacion panelsimulacion){
			this.N=N;
			ImageIcon imagen1=new ImageIcon("imagenes\\amarrillo.gif");
			ImageIcon imagen2=new ImageIcon("imagenes\\verde.gif");
			//para poner el puerto 0 del spliter en IN 
			if(N==0 && ObjetoSimulacion.keyObjeto==13){
				setText("port In "+N);
				setIcon(imagen1);
			    }
			else{
				setText("port Out "+N);
			    setIcon(imagen2);
			    }
			
			
		    setToolTipText("puerto numero "+N);
		    setEnabled(activar);
		    setPreferredSize(new Dimension(120, 25));
		    addActionListener(panelsimulacion);
		    N++;
		    
		    
		}

		
		public int getNumero(){
			return N;
		}
		
	
	 

}
