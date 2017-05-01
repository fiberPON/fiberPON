
package fiberPON.dialogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import fiberPON.Objetos.objetosPON;
import fiberPON.calculosResuldados.calculoRed;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.componentesDialogo;


public class dialogoPropiedadesSplitter extends componentesDialogo implements ActionListener{
	
	
	
	private JComboBox<String> comboDivisiones;	
	private String [] divisionesGpon;
	private String [] divisionesEpon;   
    private objetosPON objeto;
    private JTextField atenuacion;
    private int ports;
    
	public dialogoPropiedadesSplitter(esenarioPrincipal esenarioprincipal,objetosPON objeto){
		
	super(esenarioprincipal,objeto.getdatosObjeto().getNombre1());
	setResizable(false);
	this.objeto=objeto;
	setBounds(fiberPON.anchoPantalla/2-150,fiberPON.altoPantalla/2-145, 300,250);
	setDialogo(this);
	setLayout(null);
	setImagenTitulo(10, this.objeto.getdatosObjeto().getIconoObjeto(), "Divisor Optico");

	setNombreObjetoCustom(64, 190, 10, 50,10, "Nombre del Divisor", objeto.getdatosObjeto().getNombre1(), objeto.getdatosObjeto().isVerNombre1());
    
	if(this.objeto.getdatosObjeto().getNpuertos()==9){ports=0;}
	else if(this.objeto.getdatosObjeto().getNpuertos()==17){ports=1;}
	else if(this.objeto.getdatosObjeto().getNpuertos()==33){ports=2;}
	else if(this.objeto.getdatosObjeto().getNpuertos()==65){ports=3;}

	
	
	
	JLabel numeroDivisiones=new JLabel("Numero de Divisiones");	
	divisionesGpon=new String[4];	
	divisionesGpon[0]="1:8";
	divisionesGpon[1]="1:16";
	divisionesGpon[2]="1:32";	
	divisionesGpon[3]="1:64";


	
	divisionesEpon=new String[3];	
	divisionesEpon[0]="1:8";
	divisionesEpon[1]="1:16";
	divisionesEpon[2]="1:32";	

	

	
	if(objeto.getdatosObjeto().getTipotec()==1){comboDivisiones=new JComboBox<String>(divisionesGpon);}
	else{
	comboDivisiones=new JComboBox<String>(divisionesEpon);
	}
	comboDivisiones.setSelectedIndex(ports);
	comboDivisiones.setMaximumSize(comboDivisiones.getPreferredSize());
	
    Box cajaH2=Box.createHorizontalBox();
    cajaH2.add(Box.createHorizontalStrut(10));
	cajaH2.add(numeroDivisiones);
	cajaH2.add(Box.createHorizontalStrut(93));
	cajaH2.add(comboDivisiones);
	cajaH2.add(Box.createHorizontalStrut(5));
	cajaH2.setBounds(0, 105, getWidth(),30);
	add(cajaH2);
	
	
    atenuacion=setCaracteristicasCustom(140, 10, 205, 250, "Perdida en el divisor Optico", objeto.getdatosObjeto().getAtenuacion(), "dB");	
	setBotonesCustom("Aceptar", "Cancelar", 45, 60, this.getHeight()-70);
	

	setVisible(true);
	}	

	public void actionPerformed(ActionEvent e) {
	
		String opcion=e.getActionCommand();						
		
		if(opcion.compareTo("Aceptar")==0){
			
		try{
			double valorPotencia = Double.parseDouble(atenuacion.getText()); //si acepta d y f
			objeto.getdatosObjeto().setAtenuacion(valorPotencia);
			if(comboDivisiones.getSelectedIndex()==0){
				
				objeto.getdatosObjeto().setNpuertos(9);;}
			
			else if(comboDivisiones.getSelectedIndex()==1){
				objeto.getdatosObjeto().setNpuertos(17);
			    
				}
			else if(comboDivisiones.getSelectedIndex()==2){
				objeto.getdatosObjeto().setNpuertos(33);
				
				}
			else if(comboDivisiones.getSelectedIndex()==3){
				objeto.getdatosObjeto().setNpuertos(65);
				
				}
		
			
			objeto.getdatosObjeto().setNombre2(comboDivisiones.getItemAt(comboDivisiones.getSelectedIndex()));
			objeto.getdatosObjeto().setNombre1(darNombre());
			objeto.getdatosObjeto().setVerNombre1(darVerNombre());		
			calculoRed.Calculo();
		    setVisible(false);
		  
		}
		catch(Exception ex){JOptionPane.showMessageDialog(this,"Este valor: \""+atenuacion.getText()+"\" no es un numero");}
		}
		else if(opcion.compareTo("Cancelar")==0){setVisible(false);}
		
		
	}
}