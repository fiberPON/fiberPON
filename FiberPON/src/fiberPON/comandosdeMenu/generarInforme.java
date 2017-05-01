package fiberPON.comandosdeMenu;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class generarInforme {
	
	public generarInforme(String ruta){
		//Creamos un Excel
		//creamos un nuebo libro
		Workbook libro=new HSSFWorkbook();
		//creamos una nueva hoja
		Sheet hoja=libro.createSheet("Hola1");
		hoja.setColumnWidth(0,4000);
		//creamos una  fila
		Row fila=hoja.createRow(0);
		//creamos una celda
		Cell celda=fila.createCell(0);		
		//anadimos el texto
		celda.setCellValue("hola muldo");
		
		
		//guardamos el archivo
		//nombre del archivo
		String file =ruta;
		file.replace("xls", "fpon");
		
		//String cadena = "123456789";
		file = file.substring(0, file.length() - 4);
		
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(file+"xls");
			libro.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		
		
	}

}
