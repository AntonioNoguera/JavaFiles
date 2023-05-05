package temasSelectos;

//Coded by, Michael Noguera

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class problemaMochila {
	
	private static ArrayList<Double> Pesos = new ArrayList<Double>();
	private static ArrayList<Double> Valores = new ArrayList<Double>();
	private static ArrayList<Double> ValorPeso = new ArrayList<Double>();
	
	private static double Capacidad = 0;
	
	private static ArrayList<ArrayList<Integer>> Soluciones = new ArrayList<ArrayList<Integer>>();
	
	private static ArrayList<Double> Rueda = new ArrayList<Double>();
	
	private static int miembrosPorGeneracion = 10;
	
	private static double Sumatoria = 0;
	
	static void seleccionDelMejorSubHijo() {
		
		ArrayList<Integer> mejorSolucion = Soluciones.get(0);
		double vSolucion=getValor(mejorSolucion);
		
		for(int i=1;i<Soluciones.size();i++) {
			if(vSolucion<getValor(Soluciones.get(i)) && getPeso(Soluciones.get(i))<=Capacidad) {
				mejorSolucion = Soluciones.get(i);
			}
		}
		
		System.out.print("Mejor Solucion de la generacion: "+mejorSolucion);
		System.out.print("\tPeso: "+getPeso(mejorSolucion));
		System.out.print("\tValor: "+getValor(mejorSolucion));
	}
	
	static double getValor(ArrayList<Integer> listaSolucion) {
		double ValorT=0;
		
		for(int i=0;i<listaSolucion.size();i++) {
			ValorT+=Valores.get(listaSolucion.get(i));
		}
		
		return ValorT;
	}
	
	
	static ArrayList<Integer> conversionDec(ArrayList<Integer> listaSolucion){
		
		ArrayList<Integer> parseDec = new ArrayList<Integer>();
		
		//System.out.println(listaSolucion);
		
		for(int i=0;i<listaSolucion.size();i++) {
			if(listaSolucion.get(i)==1) { 
				parseDec.add(i);
			}
		}
		
		//System.out.println(parseBool);
		
		return parseDec;
	}
	
	static ArrayList<Integer> conversionBool(ArrayList<Integer> listaSolucion){
		ArrayList<Integer> parseBool = new ArrayList<Integer>();
		
		//System.out.println(listaSolucion);
		
		for(int i=0;i<Pesos.size();i++) {
			if(listaSolucion.contains(i)) {
				parseBool.add(1);
			}else {
				parseBool.add(0);
			}
		}
		
		//System.out.println(parseBool);
		
		return parseBool;
	}
	
	static void apareamientoSoluciones() {  
		
		for(int i=0;i<Soluciones.size();i+=2) {
			//Casillas
			ArrayList<Integer> solucionA = new ArrayList<Integer>();
			ArrayList<Integer> solucionB = new ArrayList<Integer>();
			
			ArrayList<Integer> aux = new ArrayList<Integer>();
			
			
			//Soluciones
			solucionA = conversionBool(Soluciones.get(i));
			solucionB = conversionBool(Soluciones.get(i+1));
			
			System.out.println(solucionA);
			System.out.println(solucionB);
			
			
			int nodoCambio = (int)(Math.round((Math.random()*(solucionA.size()-1))));
			
			System.out.println("Nodo Cambio: "+nodoCambio);
			for(int j=0;j<nodoCambio;j++) {
				
				aux.add(solucionA.get(j));
				solucionA.set(j,solucionB.get(j));
				solucionB.set(j, aux.get(j));
			}
			
			System.out.print("Nueva Solucion: "+solucionA);
			System.out.println("= "+getValor(conversionDec(solucionA)));
			
			System.out.print("Nueva Solucion: "+solucionB);
			System.out.println("= "+getValor(conversionDec(solucionB)));
			 
		}
		
	}
	
	
	static void imprimirSoluciones() {
		System.out.println("IMPRIMIENDO SOLUCIONES!!");
		for(int i=0;i<Soluciones.size();i++) {
			ArrayList<Integer> Solucion = Soluciones.get(i);
			System.out.print("Solucion"+Solucion);
			System.out.println("= "+getValor(Solucion));
		}
	}
	
	static void aspirantesSoluciones(ArrayList<Double> listaProbabilidades) {
		
		ArrayList<ArrayList<Integer>> neoSoluciones = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<listaProbabilidades.size();i++) {
			
			double tiroRuleta=Math.random(); 
			for(int j=0; j<Rueda.size(); j++) {
				
				if(tiroRuleta<listaProbabilidades.get(j)) {
					
					neoSoluciones.add(Soluciones.get(j));
					System.out.println("Solucion Seleccionada: "+Soluciones.get(j));
					break;
					
				}
			}
			
		}
		
		Soluciones = neoSoluciones;
	}
	
	//Funciones
	static ArrayList<Double> aptitudSoluciones() {
		
		double aptitudTotal = 0;
		for(int i=0;i<Soluciones.size();i++) {
			aptitudTotal+= getValor(Soluciones.get(i));
		}
		
		ArrayList<Double> aptAcum = new ArrayList<Double>();
		
		double acum=0;
		for(int i=0;i<Soluciones.size();i++) {
			acum+=(getValor(Soluciones.get(i)))/aptitudTotal;
			aptAcum.add(acum);
		}
		
		System.out.println("Total de Soluciones ="+aptAcum);
		return aptAcum;
		
	}
	
	static double getPeso(ArrayList<Integer> listaSolucion) {
		double aptitud=0;
		
		for(int i=0;i<listaSolucion.size();i++) {
			aptitud+=Pesos.get(listaSolucion.get(i));
		}
		
		return aptitud;
	}
	
	static boolean verificacionDePeso(ArrayList<Integer> listaSolucion, int NuevoObjeto) {
		
		double PesoAcum=Pesos.get(NuevoObjeto);
		
		PesoAcum+= getPeso(listaSolucion); 
		
		if(PesoAcum<=Capacidad) {
			return true;
		}else {
			return false;
		}
		
	}
	
	static void generarSoluciones() {
		for(int i=0;i<miembrosPorGeneracion;i++) {
			
			//Nueva Fila
			ArrayList<Integer> Solucion = new ArrayList<Integer>(); 
			boolean flagObjetos=true;
			do {
				
				double tiroRuleta=Math.random();  
				for(int j=0; j<Rueda.size(); j++) {	 
					
					if(tiroRuleta<=Rueda.get(j)) {  
						if(!Solucion.contains(j)) {
							if(verificacionDePeso(Solucion,j)) {
								
								Solucion.add(j);
								
							}else {
								if(getPeso(Solucion)>(Capacidad/2)) {
									
									flagObjetos = false;
									
								}
							}
						}
						break;
					}
					
				} 
				
			}while(flagObjetos); 
			System.out.println("Solucion Generada: "+Solucion);
			Soluciones.add(Solucion);
		}
	}
	
	static void ruedaDeObjetos() { 
		
		double aumProb=0;
		for(int i=0;i<Pesos.size();i++) { 
			
			aumProb+=(ValorPeso.get(i)/Sumatoria);
			Rueda.add(aumProb);
			
		}
		System.out.println("Ruleta de Objetos: "+Rueda);
	}
	
	static void leerArchivo(String Archivo) { 
		 
		String direccion = "C:\\Users\\Antonio Noguera\\workspace-Java Files\\javaFiles\\src\\temasSelectos\\"+Archivo+".txt";
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
		
		//System.out.println("Pesos: "+Pesos);
		//System.out.println("Valores: "+Valores);
		//System.out.println(Capacidad);
		//System.out.println(Sumatoria);
	}
	
	//Hilo Principal
	public static void main(String[] args) {
		// Funcion que lee el archivo y que genera un arreglo con los valores de la mochila
		leerArchivo("10Objects");
		
		// Se arranca bucle
		ruedaDeObjetos();
		
		// Se genera un solucion parcial, en esta se usara valor/peso para obtener las aptitudes,  
		generarSoluciones();
		
		// Funcion que determina la aptitud de cada solucion, y genera otra ruleta basada en la aptitud total
		ArrayList<Double> probSeleccion = new ArrayList<Double>(); 
		probSeleccion = aptitudSoluciones();
		
		// Una vez seleccionadas se arranca la fase de apareamiento 
		aspirantesSoluciones(probSeleccion); 
		
		// Nueva generacion de soluciones aparece
		apareamientoSoluciones();
		
		// Fase de perturbacion arranca
		seleccionDelMejorSubHijo();
		
	}
}