package temasSelectos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class vecinoMasCercano { 
	
	static double obtencionCosto(ArrayList<Integer> recorrido, ArrayList<ArrayList<Double>> matrizDistancias) {
		
		double costo = 0;
		System.out.println("\nCosto de la ruta Obtenida:");
		for(int i=0;i<(recorrido.size()-1);i++) {
			ArrayList<Double> nodoInicio = matrizDistancias.get(recorrido.get(i));
			costo += nodoInicio.get(recorrido.get(i+1)); 
			System.out.printf("%.4f + ",nodoInicio.get(recorrido.get(i+1)));
		}
		System.out.print("= "+costo);
		
		return costo;
	}
	
	static ArrayList<Double> limpiezaDeAspirantes(ArrayList<Double> listaSucia, ArrayList<Integer> subRuta){ 
		
		for(int i=0;i<listaSucia.size();i++) {
			if(subRuta.contains(i)){	
				listaSucia.set(i,-4.2);		
			}
		}
		
		return listaSucia;
	}

	static int seleccionVecino(ArrayList<Integer> rutaParcial, ArrayList<ArrayList<Double>> matrizDistancias) {
		
		//Linea que va a seleccionar todo el nodo de la matriz
		ArrayList<Double> distanciasDelUltimoNodo = matrizDistancias.get(rutaParcial.get(rutaParcial.size()-1));
		System.out.println("\nNodo Base: "+(rutaParcial.get(rutaParcial.size()-1)));
		
		//Linea que despliega la funcion de limpieza del nodo(eliminara los nodos que ya estan en la subruta)
		ArrayList<Double> listaLimpia = limpiezaDeAspirantes(distanciasDelUltimoNodo,rutaParcial);
		
		//For que va a seleccionar el nodo mas cercano. 
		int nodoSeleccionado=0;
		
		//Generacion de ruleta
		
		ArrayList<Double> listaAptitudes= new ArrayList<Double>();
		
		
		//Obtencion aptitud Total
		double aptitudTotal = 0;
	
		for(int i=0;i<listaLimpia.size();i++) { 
			if(listaLimpia.get(i)>0){	
				aptitudTotal+=(1/listaLimpia.get(i));	
			}
		}
		
		//Generador de Ruleta
		double acumAptitudes=0;
		
		for(int i=0;i<listaLimpia.size();i++) {
			if(listaLimpia.get(i)>0) {
				acumAptitudes+=((1/listaLimpia.get(i))/aptitudTotal);
				System.out.printf("Al nodo %d = %.4f\n",i,(1/listaLimpia.get(i))/aptitudTotal); 
				listaAptitudes.add(acumAptitudes);
			}else {
				listaAptitudes.add(0.0);
			}
		}
		
		
		
		
		double tiroRuleta=Math.random();
		System.out.println("Valor Obtenido por ruleta: "+tiroRuleta);
		System.out.println("Lista de Aptitudes Acum: "+listaAptitudes);
		
		for(int i=0;i<listaLimpia.size();i++) {
			if(tiroRuleta<=listaAptitudes.get(i)) {
				
				nodoSeleccionado=i;
				break;
			}
		}
		System.out.println("Nodo seleccionado = "+ nodoSeleccionado);
		return nodoSeleccionado;
	}
	
	
	static double distanciaEntreNodos(ArrayList<Integer> nodoA, ArrayList<Integer> nodoB) {
		double distancia=0;
		
		for(int i=0;i<nodoA.size();i++){	distancia+= Math.pow(nodoA.get(i)-nodoB.get(i),2);	} 
		
		return Math.sqrt(distancia);
	}
	
	static ArrayList<ArrayList<Double>> generarMatrizDistancia(ArrayList<ArrayList<Integer>> nodosMatriz){
		
		//referentes a la matriz a crear
		ArrayList<ArrayList<Double>> matrizD = new ArrayList<ArrayList<Double>>();
			
		for (int i = 0; i < nodosMatriz.size(); i++) {
			
		    ArrayList<Integer> nodoA = nodosMatriz.get(i);  
		    
		    //Fila de la matriz a crear
		    ArrayList<Double> fila = new ArrayList<Double>();
		    
		    for (int j = 0; j < nodosMatriz.size(); j++) {
		    	
		    	ArrayList<Integer> nodoB = nodosMatriz.get(j); 
		    	if(i!=j) { 
		    		fila.add(distanciaEntreNodos(nodoA,nodoB));
		    	}else {
		    		fila.add(-4.2);
		    	}
		        
		    }
		    matrizD.add(fila);
		} 
		
		return matrizD;
	}
	
	static ArrayList<ArrayList<Integer>> generarArreglo(String archivoObjetivo) { 
		ArrayList<ArrayList<Integer>> nodos = new ArrayList<ArrayList<Integer>>();
		 
		String direccion = "C:\\Users\\Antonio Noguera\\workspace-Java Files\\javaFiles\\src\\temasSelectos\\"+archivoObjetivo+".txt";
		File archivo = new File(direccion);
		
		int lineaEfectiva = 0; 
		
		try {
			Scanner lector = new Scanner(archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				
				if(lineaEfectiva>2) { 
					
					ArrayList<Integer> fila = new ArrayList<Integer>();
					
					String[] lineaEncontrada = linea.split(" "); 
					
					for(int i=0;i<lineaEncontrada.length;i++) {  
						fila.add(Integer.parseInt(lineaEncontrada[i]));
					}
					
					nodos.add(fila); 
					 
				}
				
				lineaEfectiva++;
				
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error a la hora de encontrar el archivo");
			e.printStackTrace();
		}
		
		return nodos;
	}
	
	public static void main(String[] args ){
		
		//Lectura de la matriz de nodos
		ArrayList<ArrayList<Integer>> matrizObtenida = generarArreglo("5nodes");
		
		//Impresion de la matriz de nodos
		System.out.println("Nodos Empleados: ");
		for (int i = 0; i < matrizObtenida.size(); i++) {
		    ArrayList<Integer> subLista = matrizObtenida.get(i);
		    System.out.println((i)+".-"+subLista); 
		}
		
		//Generacion de la matriz de distancias
		ArrayList<ArrayList<Double>> matrizDeDistancias = generarMatrizDistancia(matrizObtenida);
		
		//Lectura de matriz de distancia 
		
		System.out.println("\nDistancias entre los nodos: ");
		for (int i = 0; i < matrizDeDistancias.size(); i++) {
		    ArrayList<Double> subLista = matrizDeDistancias.get(i);
		    System.out.println((i)+".-"+subLista); 
		}
		
		//Gereneación de la ruta
		ArrayList<Integer> rutaCreada = new ArrayList<Integer>();
		
		//Seleccion del nodo al azar
		rutaCreada.add((int)(Math.round((Math.random()*(matrizDeDistancias.size()-1)))));
		
		//Seleccion del mas cercano
		do {
			rutaCreada.add(seleccionVecino(rutaCreada,matrizDeDistancias));
		}while(rutaCreada.size() < matrizDeDistancias.size());
		
		rutaCreada.add(rutaCreada.get(0));
		
		//Impresión de la ruta creada
		
		System.out.println("\nRuta Obtenida = "+rutaCreada); 
		
		obtencionCosto(rutaCreada,matrizDeDistancias);
	}	
}