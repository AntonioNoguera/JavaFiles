package temasSelectosMochila;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainMochila {
	//Referente en cada Hilo
	private static ArrayList<ArrayList<Integer>> solucionHilo = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<Double> pesoHilo = new ArrayList<Double>();
	private static ArrayList<Double> valorHilo = new ArrayList<Double>();
	
	
	
	private static ArrayList<Double> Pesos = new ArrayList<Double>();
	private static ArrayList<Double> Valores = new ArrayList<Double>();
	private static ArrayList<Double> ValorPeso = new ArrayList<Double>();
	
	private static ArrayList<Double> RuedaObjetos = new ArrayList<Double>();
	
	private static double Capacidad = 0;
	
	private static int nDeGeneraciones = 10;
	
	private static double Sumatoria = 0;
	
	
	
	public void adicionMonitor(int id, ArrayList<Integer> Solucion, double Valor,double Peso) {
		solucionHilo.set(id,Solucion);
		valorHilo.set(id,Valor);
		pesoHilo.set(id,Peso);
	}
	
	static void mejorDeLosHilos() {
		int  mejorSolucion = 0;
		for(int i=1;i<solucionHilo.size();i++) {
			if(valorHilo.get(mejorSolucion)<valorHilo.get(i)) {
				mejorSolucion=i;
			}
		}
		
		System.out.println("\n\nLa mejor solucion es: "+solucionHilo.get(mejorSolucion));
		System.out.println("De peso: "+pesoHilo.get(mejorSolucion));
		System.out.println("Y de valor: "+valorHilo.get(mejorSolucion));
		
	}
	
	static void ruedaDeObjetos() { 
		
		double aumProb=0;
		for(int i=0;i<Pesos.size();i++) { 
			
			aumProb+=(ValorPeso.get(i)/Sumatoria);
			RuedaObjetos.add(aumProb);
			
		}
		System.out.println("Ruleta de Objetos: "+RuedaObjetos);
	}
	
	static void leerArchivo(String Archivo) { 
		 
		String direccion = "C:\\Users\\Antonio Noguera\\workspace-Java Files\\javaFiles\\src\\temasSelectosMochila\\"+Archivo+".txt";
		File archivo = new File(direccion); 
		
		try {
			Scanner lector = new Scanner(archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaEncontrada = linea.split(" "); 
				
				if(lineaEncontrada.length>2) { 
					Double Peso = Double.parseDouble(lineaEncontrada[1]);
					Double Valor = Double.parseDouble(lineaEncontrada[2]);
					
					Pesos.add(Peso); 
					Valores.add(Valor);
					
					ValorPeso.add(Valor/Peso);  
					
					Sumatoria+=(Valor/Peso);
					
				}else if(lineaEncontrada.length>1) {
					Capacidad = Double.parseDouble(lineaEncontrada[1]);
				}
			}
			
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error a la hora de encontrar el archivo");
			e.printStackTrace();
		}
		
		System.out.println("Pesos: "+Pesos);
		System.out.println("Valores: "+Valores);
		System.out.println("Capacidad de la Mochila: "+Capacidad);
		System.out.println("Total del Valor/Peso: "+Sumatoria);
	}
	
	public static void main(String[] args) { 
		
		//Se genera todo lo necesario para poder usar el hilo 
		leerArchivo("10Objects");
		
		ruedaDeObjetos(); 
		
		//Genear el arreglo que esper a los valores de los hilos
		for(int i=0;i<nDeGeneraciones;i++) {
			ArrayList<Integer> solucionB = new ArrayList<Integer>();
			solucionHilo.add(solucionB);
			valorHilo.add(0.0);
			pesoHilo.add(0.0);
		}
		
		//Paquete de datos indispensables para el hilo
		ArrayList<ArrayList<Double>> DatosMochila = new ArrayList<ArrayList<Double>>();
		
		DatosMochila.add(Pesos);
		DatosMochila.add(Valores); 
		DatosMochila.add(RuedaObjetos); 
		//Arrancando Hilos
		
		for(int i=0;i<nDeGeneraciones;i++) {
			problemaMochila hilo = new problemaMochila(i,Capacidad,DatosMochila);
			hilo.start();
			try {
	            hilo.join(); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
		 
		mejorDeLosHilos();
    }
	
	

}
