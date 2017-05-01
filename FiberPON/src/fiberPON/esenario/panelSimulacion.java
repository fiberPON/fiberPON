package fiberPON.esenario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.Valores.datosFibra;
import fiberPON.dialogo.dialogoPropiedadesEnlace;
import fiberPON.main.fiberPON;
import fiberPON.panelObjetos.botonObjetos;
import fiberPON.puertos.menuPuertos;
import fiberPON.puertos.objetoPuertos;
import fiberPON.puertos.buscarEnlace;
import fiberPON.util.dibujoLineas;

public class panelSimulacion extends JPanel implements MouseMotionListener ,MouseListener,ActionListener{	

	public crearObjeto sistemacrearobjetos;	
	private esenarioPrincipal esenarioprincipal;
	public static Cursor cursor;
	public static int keyObjeto=10;
	public static  botonObjetos botonobjeto;
	public static JLabel lab;
	private int xp,yp,x1,y1;
	public menuPuertos vent; 
	public static int contClick=0;
	private objetosPON obj;
	//pru nos indica que ya existe una ventana de connexion para poner invisible
    private int pru,pru1;
    //constructor de la clase panelSimulacion
	public panelSimulacion(esenarioPrincipal esenarioprincipal){
		//pru 0 para cada nuevo proyecto
		pru=0;
		this.esenarioprincipal=esenarioprincipal;	
		//layout nulo
		setLayout(null);			
		//instancia del sistema objeto
		sistemacrearobjetos=new crearObjeto(this.esenarioprincipal);	
		//registramos ayente 
		addMouseMotionListener(this);
		addMouseListener(this);
		//label para marcar bordes
		lab=new JLabel();
		lab.setSize(new Dimension(40,40));
		vent=new menuPuertos(this);	
	
		
	}
		
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		
		for(datosFibra l:crearObjeto.enlaceFibra){
			l.dibujarLinea(g);
		}
		//si esta el mouse en enlace y si se dio un primer click a algun objeto
		if(contClick==1 && keyObjeto==14 && vent.isVisible()==false ){
			//dibujamos la linea que se arraastra con el mouse
			g.setColor(Color.BLUE);
			//el -5 y -3 son para que el extremo de la line se centre en el icono del mouse
			g.drawLine(x1, y1, xp-5,yp-3);}
	}	
	
	public void mouseDragged(MouseEvent e) {
		//agarramos posicion mause 
		posicionMouse(e.getX(),e.getY());
		
	}
	
	public void mouseMoved(MouseEvent e) {	
		//agarramos posicion mouse
	    posicionMouse(e.getX(),e.getY());	
		//solo si existe la ventana de conexion
	
	}
	
	public void mouseClicked(MouseEvent e) {
		    //si tiene el enlace abilitado haces click en pantalla cuando salga el menu de conexiones invisible y pones otr ves el mouse q estaba
			vent.setVisible(false);
			botonObj(botonobjeto);
		
		

		
	}

	public void mouseEntered(MouseEvent e) {
		//solo si existe la ventana de conexion
       if(keyObjeto==10){
    	   vent.setVisible(false);
       } 
		
	}
	


	public void mouseExited(MouseEvent e) {}
    //al precionar click en el panel
	public void mousePressed(MouseEvent e) {
		//agarramos posicion mouse    
	    posicionMouse(e.getX(),e.getY());
	    //keyIDs es -1 
	    ObjetoSimulacion.keyID=-1;
	    //borde del label lab nulo
	    lab.setBorder(null);
	    //deshabilitar copiar borrar
	    this.esenarioprincipal.EasyGponmenu.habCopiarBorrar(false);
	    //creamos objeto
	    sistemacrearobjetos.NuevoObjoto(e.getX(),e.getY());

	}
	
	public void mouseReleased(MouseEvent e) {
		//agarramos posicion mouse  
		posicionMouse(e.getX(),e.getY());
	}
	
	
	
	public void botonObj(botonObjetos botonobjeto){
		
		panelSimulacion.botonobjeto=botonobjeto;
		//tomamos el keyObjeto que es el tipo de objeto
        keyObjeto=panelSimulacion.botonobjeto.getkeyObjeto();
        //si keyobjeto es 10(mouse)
        if(keyObjeto==10){
        	//si es 10 que es mouse solo ponemos cursor null
        	setCursor(null);
        }
        //si no lo es establecemos el cursor con la imagen del objeto
        else{
        	cursor=fiberPON.tk.createCustomCursor(panelSimulacion.botonobjeto.getImagen(),new Point(20,20),panelSimulacion.botonobjeto.getToolTipText());
        	//establecemos el cursor
        	setCursor(cursor);
        	}
      
		
	}

	//posicion del mouse 
	public void posicionMouse(int xp,int yp){	
		
		this.xp=xp;
		this.yp=yp;
		repaint();
		esenarioprincipal.esenariosimulacion.repaint();	
		
	}
	//damos la posicion del mouse
	public Point getposicionMouse(){		
		return new Point(xp, yp);				
    }
	public void primeroClick(int x1,int y1){
		this.x1=x1;
		this.y1=y1;
		
		
	}
	
	public void prueba(objetosPON objeto){
		obj=objeto;
		if(keyObjeto==10){
			
			vent.Construir(obj, obj.getdatosObjeto().getX()+this.esenarioprincipal.getX()+155, obj.getdatosObjeto().getY()+this.esenarioprincipal.getY()+140);			
			
			}
		else if(keyObjeto==14){
			//para quitar el cursor del enlace
			setCursor(null);			
			vent.Construir(obj,  obj.getdatosObjeto().getX()+this.esenarioprincipal.getX()+155, obj.getdatosObjeto().getY()+this.esenarioprincipal.getY()+140);		 
		   
			
	        }
		}
	
	   @Override
	    public Dimension getPreferredSize()
	    {
	        return new Dimension(500, 500);
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(keyObjeto==10){
			vent.setVisible(false);
			objetoPuertos a1=(objetoPuertos)e.getSource();			
			int pp=a1.getNumero();
			buscarEnlace buscar=new buscarEnlace(obj, pp);
			dialogoPropiedadesEnlace dilog=new dialogoPropiedadesEnlace(esenarioprincipal,buscar.getFibra());
			}
		
		else{
		
		     contClick++;
		     if(contClick==1){
			
			     vent.setVisible(false);
			
		    	 //guardamos el primero click	para la linea de arrastre						
			     primeroClick(obj.getdatosObjeto().getX()+60,obj.getdatosObjeto().getY()+20);
			     //mandamos el objeto a quien se le hizo click
		         sistemacrearobjetos.objeto1Enlace(obj,e);
		         botonObj(botonobjeto);
	       
	        }
	        else if(contClick==2){
		   
		          vent.setVisible(false);
			      //contClick seteamos a 0 para volver a iniciar
			      contClick=0;	
			      //guardamos el segundo click
		          sistemacrearobjetos.objeto2Enlace(obj,e);
		          botonObj(botonobjeto);
	        }
	   }
	}
}