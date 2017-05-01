package fiberPON.calculosResuldados;

import fiberPON.Objetos.crearObjeto;
import fiberPON.Valores.datosFibra;

public class calculoRed {
	
	private static double sumaAtenuacionDown,sumaAtenuacionUp,sumaAtenuacionVideo,sumaDistancia;
	private static double anchoBandaDown,anchoBandaUp,TdispersionDown;
	private static double anchoEspecDown,anchoEspecUp,TdispersionUp;
	private static double dispersionUp;
	private static double dispersionDown;
	private static double dispersionVideo;
	private static double rinDown;
	private static double rinUp;
	
	
	public static void Calculo(){
		

		for(int i=0;i<crearObjeto.objListONT.size();i++){
			
		    System.out.println("tamaño fibra pro: "+crearObjeto.objListONT.get(i).getdatosFibraPro().get(0).getObjeto1());
			anchoBandaDown=crearObjeto.objListONT.get(i).getdatosFibraPro().get(crearObjeto.objListONT.get(i).getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getVelocidadDownReal();
			anchoEspecDown=crearObjeto.objListONT.get(i).getdatosFibraPro().get(crearObjeto.objListONT.get(i).getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getAnchoFte();
			rinDown=crearObjeto.objListONT.get(i).getdatosFibraPro().get(crearObjeto.objListONT.get(i).getdatosFibraPro().size()-1).getObjeto1().getdatosObjeto().getRIN();		
			anchoBandaUp=crearObjeto.objListONT.get(i).getdatosObjeto().getVelocidadDown()*Math.pow(10, -6);
			anchoEspecUp=crearObjeto.objListONT.get(i).getdatosObjeto().getAnchoFte();
			rinUp=crearObjeto.objListONT.get(i).getdatosObjeto().getRIN();			
			sumaAtenuacionDown=0;
			sumaAtenuacionUp=0;
			sumaAtenuacionVideo=0;
			sumaDistancia=0;
			dispersionDown=0;
			dispersionVideo=0;
			dispersionUp=0;
			
			TdispersionDown=0;
			TdispersionUp=0;
			
			for(int y=0;y<crearObjeto.objListONT.get(i).getdatosFibraPro().size();y++){
				crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).calculos();
				TdispersionDown=TdispersionDown+(anchoEspecDown*crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getDistancia()*crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getDisCromaticaVideo());
				TdispersionUp=TdispersionUp+(anchoEspecUp*crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getDistancia()*crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getDisCromaticaDown());
				dispersionDown=dispersionDown+(-5*Math.log10(1-Math.pow((crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisDown()*anchoBandaDown*Math.pow(10, -6)*anchoEspecDown), 2)));
				dispersionVideo=dispersionVideo+(-5*Math.log10(1-Math.pow((crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisVideo()*anchoBandaDown*Math.pow(10, -6)*anchoEspecDown), 2)));
				
				System.out.println("dispersion por la fuente: "+(-5*Math.log10(1-anchoBandaDown*Math.pow(10,6)*Math.pow(10, rinDown/10)*Math.pow(6.36, 2))));				
				System.out.println("dipersicion cromatica: "+(-5*Math.log10(1-Math.pow((crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisDown()*anchoBandaDown*Math.pow(10, -6)*anchoEspecDown), 2))));
				System.out.println("dipersion video: "+(-5*Math.log10(1-Math.pow((crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisVideo()*anchoBandaDown*Math.pow(10, -6)*anchoEspecDown), 2))));
				System.out.println("ancho de banda: "+anchoBandaDown+" ancho espectral: "+anchoEspecDown+" producto disDown: "+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisDown()+" producto disVi: "+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisVideo());
				
				dispersionUp=dispersionUp+(-5*Math.log10(1-Math.pow((crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getpDisUp()*anchoBandaUp*anchoEspecUp),2)));				
				sumaAtenuacionDown=sumaAtenuacionDown+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getSumaAtenuacionDown();
				sumaAtenuacionUp=sumaAtenuacionUp+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getSumaAtenuacionUp();
				sumaAtenuacionVideo=sumaAtenuacionVideo+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getSumaAtenuacionVideo();
				sumaDistancia=sumaDistancia+crearObjeto.objListONT.get(i).getdatosFibraPro().get(y).getDistancia();
				
			}
		    System.out.println("disDown: "+dispersionDown);
		    System.out.println("disVideo: "+dispersionVideo);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaAtenuacionDown(sumaAtenuacionDown);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaAtenuacionUp(sumaAtenuacionUp);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaAtenuacionVideo(sumaAtenuacionVideo);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaDistancia(sumaDistancia);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaDispersionDown(dispersionDown-5*Math.log10(1-anchoBandaDown*Math.pow(10,6)*Math.pow(10, rinDown/10)*Math.pow(6.36, 2)));
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaDispersionVideo(dispersionVideo-5*Math.log10(1-anchoBandaDown*Math.pow(10,6)*Math.pow(10, rinDown/10)*Math.pow(6.36, 2)));
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaDispersionUp(dispersionUp-5*Math.log10(1-anchoBandaUp*Math.pow(10,6)*Math.pow(10, rinUp/10)*Math.pow(6.36, 2)));
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaTdispersionVideo(TdispersionDown);
			crearObjeto.objListONT.get(i).getdatosObjeto().setSumaTdispersionUp(TdispersionUp);
	
		
			//actualiza las etiquetas de potencia recibida en el panel simulacion			
	        for(int c=0;c<crearObjeto.arraySimulacion.size();c++){    			
        		crearObjeto.arraySimulacion.get(c).setNombresObjetos();
    		}
	    

	        

		}		
		
	}
	


}
