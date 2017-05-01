package fiberPON.Objetos;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import fiberPON.dialogo.dialogoPropiedadesOLT;
import fiberPON.dialogo.dialogoPropiedadesONU;
import fiberPON.dialogo.dialogoPropiedadesSplitter;
import fiberPON.esenario.esenarioPrincipal;
import fiberPON.esenario.panelSimulacion;


public class ObjetoSimulacion extends JLabel implements MouseMotionListener, MouseListener{	

	//keyID del objeto
	public static int keyID,keyObjeto;	
	private objetosPON objeto;
	private esenarioPrincipal esenarioprincipal;
	public JLabel labelNombre1,labelNombre2,labelNombre3,labelImagen;
	private int xp,yp;	
	private DecimalFormat decimales;
	
	//constructor del ObjetoSimulacion
	public ObjetoSimulacion(esenarioPrincipal esenarioprincipal,objetosPON objeto){	
        	
		this.objeto=objeto;		
		this.esenarioprincipal=esenarioprincipal;
		//dimenciones del objeto simulacion
	    setSize(new Dimension(120,90));		   
	    setLocation(this.objeto.getdatosObjeto().getX(),this.objeto.getdatosObjeto().getY());							
		setLayout(null);
		//formato para mostrar decimlaes
	    decimales = new DecimalFormat("0.00");
		
		//Label Imagen del objeto
		labelImagen=new JLabel();
		labelImagen.setSize(new Dimension(40, 40));
		labelImagen.setLocation(40,0);
		labelImagen.setIcon(this.objeto.getdatosObjeto().getIconoObjeto());
		//registramos a la imagen como oyente
		labelImagen.addMouseMotionListener(this);
		labelImagen.addMouseListener(this);
		//añadimos la imagen al objeto simulacion
		add(labelImagen);
		//label Nombre 1
		labelNombre1=new JLabel();
		labelNombre1.setHorizontalAlignment(SwingConstants.CENTER);		
		labelNombre1.setSize(new Dimension(120,15));
		labelNombre1.setLocation(0,40);		
		add(labelNombre1);
		//label Nombre 2
		labelNombre2=new JLabel();
		labelNombre2.setHorizontalAlignment(SwingConstants.CENTER);		
		labelNombre2.setSize(new Dimension(120,15));
		labelNombre2.setLocation(0,55);
		//labelNombre2.setFont(new Font("Serif", Font.BOLD, 12));
		//labelNombre2.setForeground(Color.red);
		add(labelNombre2);
		//label Nombre 2
		labelNombre3=new JLabel();
		labelNombre3.setHorizontalAlignment(SwingConstants.CENTER);		
		labelNombre3.setSize(new Dimension(120,15));
		labelNombre3.setLocation(0,70);	
		add(labelNombre3);
		setNombresObjetos();		
		
		
		
	}
	
	//set nombres
	
	public void setNombresObjetos(){
		
		//label Nombre 1
				if(objeto.getdatosObjeto().isVerNombre1()==true){
					labelNombre1.setText(objeto.getdatosObjeto().getNombre1());
					labelNombre2.setLocation(0, 55);}
				else{
					labelNombre1.setText(null);
				    labelNombre2.setLocation(0	, 40);}		
				if(objeto.getdatosObjeto().isVerNombre2()==true){
					labelNombre2.setText(objeto.getdatosObjeto().getNombre2());
					labelNombre3.setLocation(0,70);
				}
				else{
					labelNombre2.setText(null);
					if(objeto.getdatosObjeto().isVerNombre1()==false){
						labelNombre3.setLocation(0,40);	
					}
					else{labelNombre3.setLocation(0,55);	}
					
				}		
				if(objeto.getdatosObjeto().isVerNombre3()==true){
					if(objeto.getdatosObjeto().laMenorAtenuacion()<objeto.getdatosObjeto().getSensibilidad()){
						labelNombre3.setFont(new Font("Serif", Font.BOLD, 12));
						labelNombre3.setForeground(Color.red);
					}
					else{
						labelNombre3.setFont(new Font("Serif", Font.BOLD, 12));
						labelNombre3.setForeground(Color.black);
					}
					labelNombre3.setText(objeto.getdatosObjeto().getNombre3()+decimales.format(objeto.getdatosObjeto().laMenorAtenuacion()));
					}
				else{labelNombre3.setText(null);}		
						
				//añadimos el objeto simulacion al panel simulacion		
				this.esenarioprincipal.esenariosimulacion.panelsimulacion.add(this);	
				//repintamos el panel
				this.esenarioprincipal.esenariosimulacion.panelsimulacion.repaint();
				
		
	}
	

	@Override
	public void mouseClicked(MouseEvent eq) {
		
		posicionMouse(eq.getX()+this.getX()+40,eq.getY()+this.getY());
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.prueba(objeto);
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.posicionMouse(eq.getX()+this.getX()+40,eq.getY()+this.getY());
		
		//si se da 2 click al objeto simulacion		
	   if(eq.getClickCount()==2){ 
		   //ucultar meno conexiones
		   this.esenarioprincipal.esenariosimulacion.panelsimulacion.vent.setVisible(false);
		   //creamos el menu del objeto
           crearDialogoOpciones();
  
           
	   }    
	  
		  
	         if(objeto.getdatosObjeto().getKeyObjeto()==12){
	        	 System.out.println("potencia total down: "+objeto.getdatosObjeto().getAtenuacionTotalDown());
	        	 System.out.println("potencia total video: "+objeto.getdatosObjeto().getAtenuacionTotalVideo());
	        	 System.out.println("suma potencia down: "+objeto.getdatosObjeto().getSumaAtenuacionDown());
	        	 System.out.println("suma potencia Video: "+objeto.getdatosObjeto().getSumaAtenuacionVideo());
	        	 System.out.println("suma dispersion Down: "+objeto.getdatosObjeto().getSumaDispersionDown());
	        	 System.out.println("suma dispersion Video: "+objeto.getdatosObjeto().getSumaDispersionVideo());
	        	 System.out.println("potencia total down: "+objeto.getdatosObjeto().getAtenuacionTotalDown());
	        	 System.out.println("potencia total Video: "+objeto.getdatosObjeto().getAtenuacionTotalVideo());
	        	 System.out.println("la menor atenuacion: "+objeto.getdatosObjeto().laMenorAtenuacion());
	         }
	   
		
		
	}
	
	//seteamos label si el mouse entra a la imagen y tambien lo quitamos si no entra
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override    
	public void mouseEntered(MouseEvent e) {
    	labelImagen.setBorder(new BevelBorder(BevelBorder.RAISED));    	
    }
	@Override
	public void mouseExited(MouseEvent e) {
		labelImagen.setBorder(null);		
	}
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void mousePressed(MouseEvent ex) {
		//damos la posicion del mouse 
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.posicionMouse(ex.getX()+this.getX()+40,ex.getY()+this.getY());
		//seteamos el borde del lab 	
		panelSimulacion.lab.setBorder(new javax.swing.border.EtchedBorder());
		//habilitamos copiar y borrar
		this.esenarioprincipal.EasyGponmenu.habCopiarBorrar(true);
		//añadimos lab a la imagen del objeto simulacion
		labelImagen.add(panelSimulacion.lab);
		//repintamos el panel
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.repaint();
		//cogemos el keyID del objeto  
		keyID=this.objeto.getdatosObjeto().getKeyID();
		keyObjeto=this.objeto.getdatosObjeto().getKeyObjeto();
		// para borrrar el objeto para copiar lo que hace es mandar el objeto al esenario principal
	    this.esenarioprincipal.getobj(this);
		
		
	}

	public void mouseReleased(MouseEvent ex) {
		//guardamos la posicion del mouse
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.posicionMouse(ex.getX()+this.getX()+40,ex.getY()+this.getY());
		// checkPopup(ex);		 
	}
	
	public void mouseDragged(MouseEvent e) {		
		//guardamos la posicion del mouse 
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.posicionMouse(e.getX()+this.getX()+40,e.getY()+this.getY());
		posicionMouse(e.getX()+this.getX()+40,e.getY()+this.getY());
		setposicionObjeto();
		this.esenarioprincipal.EasyGponmenu.habGuardar(true);
		
		//////////todo esto es para el cros bar del panel///////////////////////////////////////////////////////////////////////
        /*
		int pp=this.getX()-this.esenarioprincipal.esenariosimulacion.getWidth()+80;
		int ph=this.getY()-this.esenarioprincipal.esenariosimulacion.getHeight()+80;
		System.out.println(pp+" "+ph);
		if(pp>0){
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setSize(new Dimension(this.esenarioprincipal.esenariosimulacion.getWidth()+pp,this.esenarioprincipal.esenariosimulacion.getHeight()));
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setPreferredSize(this.esenarioprincipal.esenariosimulacion.panelsimulacion.getSize());
	        System.out.println("holass");
	        
		}		
		else {
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setSize(new Dimension(this.esenarioprincipal.esenariosimulacion.getWidth()-42, this.esenarioprincipal.esenariosimulacion.panelsimulacion.getHeight()));
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setPreferredSize(this.esenarioprincipal.esenariosimulacion.panelsimulacion.getSize());
			System.out.println(this.esenarioprincipal.esenariosimulacion.getWidth()+"gg");}
		if(ph>0){
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setSize(new Dimension(this.esenarioprincipal.esenariosimulacion.getWidth(),this.esenarioprincipal.esenariosimulacion.getHeight()+ph));
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setPreferredSize(this.esenarioprincipal.esenariosimulacion.panelsimulacion.getSize());
		    System.out.println("hh");
		}
		else {
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setSize(this.esenarioprincipal.esenariosimulacion.panelsimulacion.getWidth(), this.esenarioprincipal.esenariosimulacion.getHeight()-56);
			this.esenarioprincipal.esenariosimulacion.panelsimulacion.setPreferredSize(this.esenarioprincipal.esenariosimulacion.panelsimulacion.getSize());
			}
        */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}
	//metodo para colocar el objeto en la posicion del mouse
	public void setposicionObjeto(){
		
		setLocation(xp-this.getWidth()/2,yp-this.getHeight()/2+25);
		//guardamos estas pocisiones
		this.objeto.getdatosObjeto().setX(this.getX());
		this.objeto.getdatosObjeto().setY(this.getY());		
	}

	public void mouseMoved(MouseEvent e) {
		//guardamos la posicion del mouse
		this.esenarioprincipal.esenariosimulacion.panelsimulacion.posicionMouse(e.getX()+this.getX()+40,e.getY()+this.getY());
		posicionMouse(e.getX()+this.getX()+40,e.getY()+this.getY());
	}

    //mostrar dialogo
	public void crearDialogoOpciones(){
		
          this.esenarioprincipal.crearDialogo(objeto); 
          setNombresObjetos();
    }
	

	
	public void posicionMouse(int xp,int yp){
		
		
		this.xp=xp;
		this.yp=yp;
		
	}

	

	 public objetosPON getObjetosPON(){
		 return objeto;
	 }

	@Override
	public String toString() {
		return "objetosimulacion numero "+objeto.getdatosObjeto().getKeyID()+objeto.getdatosObjeto().getKeyObjeto();
	}
	 
}
