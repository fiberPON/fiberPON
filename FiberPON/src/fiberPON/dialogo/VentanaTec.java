package fiberPON.dialogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.main.fiberPON;
import fiberPON.util.fileChooser;
import fiberPON.util.patchFileChooser;




public class VentanaTec extends JDialog{
	
	private JTextField camino;
	private int valor=2; //valor 2 significa cerrar la ventana
	private String patch="null";
	private JRadioButton gpon;
	private JRadioButton epon;
	
	public VentanaTec(esenarioPrincipal esenarioprincipal){
		
		
		super(esenarioprincipal,"Nuevo Proyecto",true);
		setResizable(false);
		setBounds(fiberPON.anchoPantalla/2-125,fiberPON.altoPantalla/2-145, 250, 250);
		
		
		JLabel tecnologia =new JLabel("Tipo de Tecnologia");

		Box box0=Box.createHorizontalBox();
		box0.add(tecnologia);
		box0.add(Box.createHorizontalStrut(125));
		
		ButtonGroup grupoXpon=new ButtonGroup();
		gpon=new JRadioButton("    GPON             G984.x");
		gpon.setSelected(true);
		epon=new JRadioButton("    EPON             G984.x");
		grupoXpon.add(gpon);
		grupoXpon.add(epon);

		
		Box box1=Box.createHorizontalBox();
		box1.add(gpon);		
		Box box2=Box.createHorizontalBox();		
		box2.add(epon);
		
		
		Box vertical=Box.createVerticalBox();
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(box0);
		vertical.add(box1);
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(box2);
		vertical.add(Box.createVerticalStrut(10));	
      
		
		JLabel direccion =new JLabel("Direccion de almacenamiento");
		Box box3=Box.createHorizontalBox();
		box3.add(direccion);
		box3.add(Box.createHorizontalStrut(75));		

		
		camino=new JTextField("C:\\Users\\David\\Documents\\proyecto1.fpon",20);
		camino.setMaximumSize(camino.getPreferredSize());
		JButton serchcamino=new JButton("Examinar");
		serchcamino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fileChooser patchfilechooser=new fileChooser(esenarioprincipal,"Guardar");
				patch=patchfilechooser.darRuta();
			
				if(patch.compareTo("null")!=0){
					camino.setText(patch);
				}
			
			}
		});
		
		Box box4=Box.createHorizontalBox();
		box4.add(camino);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(serchcamino);
		box4.setBorder(new javax.swing.border.EtchedBorder());
		
		JButton aceptar=new JButton("Aceptar");
		JButton cancelar=new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener() {			

			public void actionPerformed(ActionEvent e) {				
			
			    if(patch.compareTo("null")==0){			    	
				
			     	patchFileChooser v=new patchFileChooser(esenarioprincipal,camino.getText());
			     	
				    if(v.getValorPatch()==0){				    	
				    
					  valor=0;	// valor 0 significa Aceptar				  
					  setVisible(false);
					  }	
			   }
			    
			   else{				   
			   
			        valor=0;
			        setVisible(false);
			   }				
		   }
		});
		
		cancelar.addActionListener(new ActionListener() {			

			public void actionPerformed(ActionEvent e) {
				
				valor=1;   //valor 1 significa Cancelar
				setVisible(false);
				
			}
		});
		
		Box box5=Box.createHorizontalBox();
		box5.add(aceptar);
		box5.add(Box.createHorizontalStrut(10));
		box5.add(cancelar);
		
		
		Box box=Box.createVerticalBox();
	
		box.add(vertical);	
		box.add(Box.createVerticalStrut(10));
		box.add(box3);		
		box.add(box4);
		box.add(Box.createVerticalStrut(20));
		box.add(box5);
		box.add(Box.createVerticalStrut(20));
		box.setBorder(new javax.swing.border.EtchedBorder());
		add(box);
		
		
		setVisible(true);
			
	}
	
	public int valorAceptar(){
		return valor;
	}
	
	public String darRuta(){
		return camino.getText();
	}
	
	public boolean tecAcept(){
		return gpon.isSelected();
	}
}