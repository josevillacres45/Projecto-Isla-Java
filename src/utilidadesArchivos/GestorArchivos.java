package utilidadesArchivos;

import java.io.File;

import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import modelo.Isla;


public class GestorArchivos {

	public static void guardarPortadaIsla(Isla islaImagen, String rutaReal) {
		MultipartFile archivo = islaImagen.getPortada();
		String nombreArchivo = islaImagen.getId()+".jpg";
		//vamos a crear una carpeta de subidas en la ruta real (si no existe)
		String rutaSubidas = rutaReal + "subidas";
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists()) {
			fileRutaSubidas.mkdirs();
		}
		String rutaSubidaFotos=rutaSubidas+"/"+islaImagen.getId();
		File carpetaImagen=new File(rutaSubidaFotos);
		if (!carpetaImagen.exists()) {
			carpetaImagen.mkdirs();
			System.out.println("Carpeta creada de nombre: "+islaImagen.getId());
		}
		int elementosCarpeta=carpetaImagen.list().length;
		String nombreFoto="";
		if (elementosCarpeta<3) {
			int numeroCarpeta=elementosCarpeta+1;
			nombreFoto=numeroCarpeta+".jpg";
			try {
				byte[] infoPortada = archivo.getBytes();
				if(infoPortada.length > 0) {
					String ruta =rutaSubidaFotos+"/"+nombreFoto;
					FileCopyUtils.copy(infoPortada, new File(ruta));
					System.out.println("Archivo subido en: " + ruta);
				}
			} catch (IOException e1) {
				System.out.println("no pude obtener info de la imagen");
				e1.printStackTrace();
			}
		}else {
			System.out.println("Hay demasiadas fotos en la carpeta");
		}
		
	}
	public static int devolverNumeroElementosCarpeta(String ruta,Isla isla) {
		File carpetaFotos=new File(ruta+"subidas/"+isla.getId());
		int numeroFotos=carpetaFotos.list().length;
		return numeroFotos;
	}
	
}
