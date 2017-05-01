package fiberPON.esenario;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fiberPON.Objetos.ObjetoSimulacion;
import fiberPON.Objetos.crearObjeto;
import fiberPON.Objetos.objetosPON;
import fiberPON.comandosdeMenu.abrirProyecto;
import fiberPON.comandosdeMenu.borrarObjeto;
import fiberPON.comandosdeMenu.copiarObjeto;
import fiberPON.comandosdeMenu.generarInforme;
import fiberPON.comandosdeMenu.guardarProyecto;
import fiberPON.comandosdeMenu.guardarcomoProyecto;
import fiberPON.comandosdeMenu.pegarObjeto;
import fiberPON.comandosdeMenu.salirProyecto;
import fiberPON.dialogo.VentanaTec;
import fiberPON.dialogo.acercaDe;
import fiberPON.dialogo.dialogoPropiedadesOLT;
import fiberPON.dialogo.dialogoPropiedadesONU;
import fiberPON.dialogo.dialogoPropiedadesPerdida;
import fiberPON.dialogo.dialogoPropiedadesSplitter;
import fiberPON.main.fiberPON;
import fiberPON.menu.barraHerramientas;
import fiberPON.menu.menu;
import fiberPON.panelObjetos.botonObjetos;
import fiberPON.panelObjetos.panelObjetos;


public class esenarioPrincipal extends JFrame implements ActionListener{
	
	// Panel del JInternalFrame
	private JDesktopPane panelCentral;	
	//Menu del Esenario Principal
	public menu EasyGponmenu;
	//Contador de Ventana del Esenario Simulacion
	public static int contadorVentanas=0;
	//panel de menu componentes
	public panelObjetos panelObjetos;
	//Esenario Simulacion
	public esenarioSimulacion esenariosimulacion;
	//Componentes del menu
	private abrirProyecto abrirproyecto;
	private copiarObjeto copiarobjeto;
	private pegarObjeto pegarobjeto;	
	private guardarProyecto guardarproyecto;
	private borrarObjeto borarrobjeto;
	private salirProyecto salirproyecto;
	private guardarcomoProyecto guardarcomoproyecto;
	//Direccion donde se guardar el proyecto
	private String ruta;
	//valor  JOptionpane de mensaje guardar esenario simulacion 
	private int valor;
	//tipo de tecnologia gpon = 1 y epon = 2 
	public static int tec;
	//ventana acerca de
	private acercaDe acercade;
	
	private ObjetoSimulacion ss;
    //Dmienciones de la ventana principal
	
	
	private objetosPON objeto;
	public static int x=(int)(fiberPON.anchoPantalla*0.05);
	public static int y=(int)(fiberPON.altoPantalla*0.05);
	public static int ancho=(int)(fiberPON.anchoPantalla*0.9);
	public static int alto=(int)(fiberPON.altoPantalla*0.85);
	public barraHerramientas barraherramientas;
	//Constructor de la Clase esenarioPrincipal
	public esenarioPrincipal(){
		
	    //Dimencion a la pantalla principal
		setBounds(x,y,ancho,alto);
		//icono
		Image miIcono=fiberPON.tk.getImage("imagenes/fiberPON.gif");
		setTitle("fiberPON");
		setIconImage(miIcono);
		//Instanciar el menu y añadir
		EasyGponmenu=new menu(this);
		setJMenuBar(EasyGponmenu);
		//barra de herramientas
	    barraherramientas=new barraHerramientas(this);
		add(barraherramientas,BorderLayout.NORTH);
		//Instancial el panel donde estara la ventana de simulacion y añadimos
		panelCentral=new JDesktopPane();		
	    add(panelCentral,BorderLayout.CENTER);
	    //Istanciamos el menu de objetos y añadimos
	    panelObjetos=new panelObjetos(this);
	    add(panelObjetos,BorderLayout.WEST);
	    //menu de objetos deshabilitado
	    panelObjetos.deshabilitar();	    
	    //antes de cerrar el prgrama
	    addWindowListener(new WindowAdapter() {	   
	    	public void windowClosing(WindowEvent e) {	    		
	    		super.windowClosing(e);
	    		//Instancia clase salir proyecto
	    		salirproyecto=new salirProyecto(esenarioPrincipal.this,ruta);
	    	}
	    });
	}
	
	//accion al precionar una opcion del menu	
	public void actionPerformed(ActionEvent e) {
		//reiniciamos el conteo de click
		panelSimulacion.contClick=0;
		String opcionItems=e.getActionCommand();		
	
		if(opcionItems.compareTo("")==0){
			String a=(String)e.getSource().toString();
			if(e.getSource().toString().compareTo("1")==0){esenariosimulacion.panelsimulacion.botonObj((botonObjetos)e.getSource());}
			else{
				JButton boton=(JButton)e.getSource();
				opcionItems=boton.getToolTipText();
			
			}	
				
			}
			
		//si es guardar
		if(opcionItems.compareTo("Guardar")==0){guardarProyecto();}
		//si es guardar como
		else if(opcionItems.compareTo("Guardar Como")==0){guardarcomoproyecto=new guardarcomoProyecto(this);}
		//si es abrir
		else if(opcionItems.compareTo("Abrir")==0){ abrirProyecto();}
		//si es nuevo
		else if(opcionItems.compareTo("Nuevo")==0){isVentana();}	
		//si es copiar
		else if(opcionItems.compareTo("Copiar")==0){
			copiarobjeto=new copiarObjeto(ss);
			EasyGponmenu.activarPegar(true);
			objeto=copiarobjeto.getObjetoCopiado();
			}
		//si es pegar
		else if(opcionItems.compareTo("Pegar")==0){pegarobjeto=new pegarObjeto(this, objeto);}
		//si es borrar
		if(opcionItems.compareTo("Borrar")==0){
			borarrobjeto=new borrarObjeto(ss);
			esenariosimulacion.panelsimulacion.repaint();
			//borarrobjeto=new borrarObjeto(esenariosimulacion);
			}
		//si es salir
		else if(opcionItems.compareTo("Salir")==0){salirproyecto=new salirProyecto(this,ruta);}
		//si es acerca de
		else if(opcionItems.compareTo("Acerca de")==0){acercade=new acercaDe(this);}
		//si es licencia
		else if(opcionItems.compareTo("Licencia")==0){acercade=new acercaDe(this);}
		//exportar proyecto
		else if(opcionItems.compareTo("Exportar Proyecto")==0){generarInforme generarI=new generarInforme(ruta);}
	}
	//Guardar Proyecto
	public void guardarProyecto(){		
		//otra mentira de java no se puede si lo pasas al guardarproyecto
		guardarproyecto=new guardarProyecto(this,ruta);
		
	}
	public void getobj(ObjetoSimulacion ss){
		this.ss=ss;
		
	}
	
	//comprobar si hay ventanas abiertas
	public void isVentana(){
		//Si no hay ventana abierta
		if(contadorVentanas==0){
			//crear proyecto
	        crearProyecto();
			
		}
		//si hay una ventana abierta
		else{	
			
			antesdeCerrarSimulacion(esenariosimulacion);
			  //si el valor del JOptionpane es diferente de cancelar
			  if(valor!=JOptionPane.CANCEL_OPTION){
				 //crear proyecto 
			     crearProyecto();
			  }			
			}
		
	}
	//crear proyecto
	public void crearProyecto(){
		//instancia ventana tecnologia
		  VentanaTec ve=new VentanaTec(this);		
			//si precionamos aceptar devuelve un cero, capturamos la ruta y el tipo de tecnologia 
			  if(ve.valorAceptar()==0){
				  ruta=ve.darRuta();
				  if(ve.tecAcept()==true){
					  //si tec = 1 es GPON
					  tec=1;}
				  else{
					  //si tec = 2 es EPON
					  tec=2;}
			  //creamos nuevo proyecto	  
			  nuevoProyecto();
			  }
	}
	//abrir proyecto
	public void abrirProyecto(){
		//si no hay ventana abierta
		if(contadorVentanas==0){
			//instanciamos abrir proyecto
			abrirproyecto=new abrirProyecto(this);
            ruta=abrirproyecto.darRuta();
           
            }
		
		else{
			antesdeCerrarSimulacion(esenariosimulacion);
			//si no hay ventana abierta 
			if(contadorVentanas==0){	
				abrirproyecto=new abrirProyecto(this);
                ruta=abrirproyecto.darRuta();}
			}
		
		
	}
	//nuevo proyecto	
	public void nuevoProyecto(){				
	    //instancia de nuevo proyecto
		esenariosimulacion=new esenarioSimulacion(this);
		//incrementamos contador ventana
		contadorVentanas++;	
		//añadimos el esenario simulacion al panel central
		panelCentral.add(esenariosimulacion);		
	}
	
	public void antesdeCerrarSimulacion(esenarioSimulacion esenariosimulacion){
		//si no hay nada en el array de objetos cerrar la ventana simulacion
		if(crearObjeto.listaObjetos.size()==0){
			esenariosimulacion.dispose();
		}
		//si menu guardar esta desactivado cerrar la ventana simulacion
		else if(this.EasyGponmenu.guardar.isEnabled()==false){			
			esenariosimulacion.dispose();
		}
		//si hay una ventana simulacion abierta sin guardar preguntar si desea guardar
		else{valor=JOptionPane.showConfirmDialog(this, "¿desea guarda el proyecto?");
		        //si la opcion es si
				if(valor==JOptionPane.YES_OPTION){
					guardarProyecto();
					esenariosimulacion.dispose();
				}
				//si la opcion es no
				else if (valor==JOptionPane.NO_OPTION) {
					esenariosimulacion.dispose();
				}
				
		   }	
				
    }
	
	public void crearDialogo(objetosPON objeto){
		
		if(objeto.getdatosObjeto().getKeyObjeto()==11){
			
			dialogoPropiedadesOLT dialogo =new dialogoPropiedadesOLT(this,objeto);
			//dialogoPropiedadesPerdida dialogo=new dialogoPropiedadesPerdida(this, "perdida1", objeto.getdatosObjeto().getIconoObjeto(), "peridida2");
						   			
		}
		if(objeto.getdatosObjeto().getKeyObjeto()==12){
			
			dialogoPropiedadesONU dialogo =new dialogoPropiedadesONU(this,objeto);					
							
			   			
		}
		if(objeto.getdatosObjeto().getKeyObjeto()==13){
			dialogoPropiedadesSplitter dialogo =new dialogoPropiedadesSplitter(this,objeto);		
				   			
		}	
	}


	
	

}
