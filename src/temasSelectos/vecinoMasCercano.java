package temasSelectos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class vecinoMasCercano {
	
	static int[][] generarArreglo(String archivoObjetivo) {
		System.out.println(archivoObjetivo);
		int arregloLeido[][]= new int[10][10];
		
		String direccion = "C:\\Users\\Antonio Noguera\\workspace-Java Files\\javaFiles\\src\\temasSelectos\\"+archivoObjetivo+".txt";
		
		File archivo = new File(direccion);
		
		try {
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				System.out.println(linea);
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error a la hora de encontrar el archivo");
			e.printStackTrace();
		}
		
		return arregloLeido;
	}
	
	public static void main(String[] args ) {
		generarArreglo("5nodes");
	}	
	
}
