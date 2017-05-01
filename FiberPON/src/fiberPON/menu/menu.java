package fiberPON.menu;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

//import easygpon.Objetos.ObjetoSimulacion;
import fiberPON.esenario.esenarioPrincipal;


public class menu extends JMenuBar{
	
	
	 private esenarioPrincipal esenarioprincipal;
 
	
	    public menu(esenarioPrincipal esenarioprincipal){		    
	    
	    this.esenarioprincipal=esenarioprincipal;	
	    // Menu archivo	mas sus Items
	    archivo = new JMenu("Archivo");
	    
	    nuevo = new menuItems("Nuevo", this.esenarioprincipal, 78, 2);
	    nuevo.setEnabled(true);
	    abrir = new menuItems("Abrir", this.esenarioprincipal,65,2);
	    abrir.setEnabled(true);
	    exportarExcel=new menuItems("Exportar Proyecto", this.esenarioprincipal);
	    guardar = new menuItems("Guardar",this.esenarioprincipal,83,2);
	 
	    guardar_como = new menuItems("Guardar Como",this.esenarioprincipal,71,2); 
	    
	    salir = new menuItems("Salir",this.esenarioprincipal,115,8);
	    salir.setEnabled(true);
	    archivo.add(nuevo);
	    archivo.add(abrir);
	    //archivo.add(exportarExcel);
	    archivo.add(guardar);
	    archivo.add(guardar_como);
	    archivo.addSeparator();
	    archivo.add(salir);
	    
	    //Menu editar
	    editar=new JMenu("Editar");
	    copiar=new menuItems("Copiar", this.esenarioprincipal,67,2);
	    
	    pegar=new menuItems("Pegar", this.esenarioprincipal,86,2);
	    borrar=new menuItems("Borrar", this.esenarioprincipal,127,0);
	    
	    editar.add(copiar);
	    editar.add(pegar);
	    editar.add(borrar);
	    
	    //Menu Ver
	   // ver = new JMenu("Ver");    
	   // zoom = new JMenu("Zoom");
	   // acercarse = new menuItems("Acercar",this.esenarioprincipal,521,2);
	   // alejarse = new menuItems("Alejar",this.esenarioprincipal,45,2); 
	    //ver.add(zoom);
	   // zoom.add(acercarse);
	   // zoom.add(alejarse);
	    
	    // Menu Ayuda mas sus Items
	    ayuda = new JMenu("Ayuda");
	    licencia = new menuItems("Licencia",this.esenarioprincipal);
	    licencia.setEnabled(true);	 
	    acercaDe = new menuItems("Acerca de",this.esenarioprincipal);
	    acercaDe.setEnabled(true);	
	    ayuda.add(licencia);
	    ayuda.add(acercaDe);
	    
	    //Añadimos a la barra de menu
	    add(archivo);
	    add(editar);
	   // add(ver);
	    add(ayuda);
	   

	    //popupONU = new JPopupMenu();
	    //popupONU.add(copiar);
	    //popupONU.add(borrar);
	    //popupONU.addSeparator();
   
	   }
	    
	    
	    
	    public void habCopiarBorrar(boolean habilitar){
	    	
	    	borrar.setEnabled(habilitar);
	    	copiar.setEnabled(habilitar);
	    	
	    	this.esenarioprincipal.barraherramientas.habCopiarBorrar(habilitar);
	    	
	    }


		public void habGuardarcomo(boolean habilitar){	    	
	    	guardar_como.setEnabled(habilitar);	
	    	exportarExcel.setEnabled(habilitar);
	    }  
		
		public void habGuardar(boolean habilitar){
			
			guardar.setEnabled(habilitar);
			
			this.esenarioprincipal.barraherramientas.habGuardar(habilitar);
		}

	    
	    public void activarPegar(boolean habilitar){
	    	
	    	pegar.setEnabled(habilitar);
	    	this.esenarioprincipal.barraherramientas.activarPegar(habilitar);
	  
	    }
	    

	private JMenu archivo;
	private JMenu ver;
	private JMenu editar;
	private JMenu ayuda;
	private JMenu zoom;
	private menuItems nuevo;
	private menuItems abrir;
	private menuItems exportarExcel;
	public menuItems guardar;
	public menuItems guardar_como;
	private menuItems salir;
	private menuItems acercarse;
	private menuItems alejarse;
	private menuItems licencia;
	private menuItems acercaDe;
	private menuItems copiar;
	private menuItems pegar;
	private menuItems borrar;
	//public JPopupMenu popupONU;
	

	}

