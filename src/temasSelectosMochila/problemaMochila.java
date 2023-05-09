package temasSelectosMochila;

//Coded by, Michael Noguera

//Tabular Granular
//Busqueda local (Se añadio 09/05/23)
  
import java.util.ArrayList;

public class problemaMochila extends Thread {
	
	private int nHilo = 0;
	
	private ArrayList<Double> Pesos = new ArrayList<Double>();
	private ArrayList<Double> Valores = new ArrayList<Double>(); 
	private ArrayList<Double> Rueda = new ArrayList<Double>();
	
	private double Capacidad = 0;
	
	private ArrayList<ArrayList<Integer>> Soluciones = new ArrayList<ArrayList<Integer>>();
	private int miembrosPorGeneracion = 10;
	
	private ArrayList<Integer> mejorSolucionHilo = new ArrayList<Integer>();
	
	//Funciones Auxiliares
	public double getPeso(ArrayList<Integer> listaSolucion) {
		double aptitud=0;
		
		for(int i=0;i<listaSolucion.size();i++) {
			aptitud+=Pesos.get(listaSolucion.get(i));
		}
		
		return aptitud;
	}
	
	public double getValor(ArrayList<Integer> listaSolucion) {
		double ValorT=0;
		
		for(int i=0;i<listaSolucion.size();i++) {
			ValorT+=Valores.get(listaSolucion.get(i));
		}
		
		return ValorT;
	}
	
	public ArrayList<Integer> returnMejorSolucion() {
		return mejorSolucionHilo;
	}
	
	//Funciones Principales
	public ArrayList<Integer> seleccionDelMejorSubHijo() {
		
		boolean flagSoluciones = true;
		 
		double vSolucion = 0;
		
		//Ocupo determinar la solucion con un bucle
		//Por que si no, asumo, que la primer solucion, es valida de capacidad
		
		//Si todas las soluciones de la generacion, quedan incapacitadas, tendremos que
		//Aclaralo por mensaje
		
		int iterador=0;
		
		do {
			if(getPeso(Soluciones.get(iterador))<=Capacidad) {
				mejorSolucionHilo = Soluciones.get(iterador);
				vSolucion = getValor(mejorSolucionHilo);
				flagSoluciones=false;
			}
			iterador++;
		}while(flagSoluciones && iterador<Soluciones.size());
		
		if(flagSoluciones) {
			//No hay solucion en esta generacion
			System.out.println("En esta generacion todas las soluciones han quedado invalidas, por exceder la capacidad.");
		}else {
			for(int i=0;i<Soluciones.size();i++) {
				if(vSolucion<getValor(Soluciones.get(i)) && getPeso(Soluciones.get(i))<=Capacidad) {
					mejorSolucionHilo = Soluciones.get(i); 
					vSolucion=getValor(mejorSolucionHilo);
				}
			}
			 
			
			System.out.print("Mejor Solucion del Hilo "+nHilo+": "+mejorSolucionHilo);
			System.out.print("\tPeso: "+getPeso(mejorSolucionHilo));
			System.out.println("\tValor: "+getValor(mejorSolucionHilo));
		}
		
		return mejorSolucionHilo;
	} 
	
	public ArrayList<Integer> conversionDec(ArrayList<Integer> listaSolucion){
		
		ArrayList<Integer> parseDec = new ArrayList<Integer>(); 
		
		for(int i=0;i<listaSolucion.size();i++) {
			if(listaSolucion.get(i)==1) { 
				parseDec.add(i);
			}
		} 
		
		return parseDec;
	}
	
	public ArrayList<Integer> conversionBool(ArrayList<Integer> listaSolucion){
		ArrayList<Integer> parseBool = new ArrayList<Integer>();
		
		//System.out.println(listaSolucion);
		
		for(int i=0;i<Pesos.size();i++) {
			if(listaSolucion.contains(i)) {
				parseBool.add(1);
			}else {
				parseBool.add(0);
			}
		} 
		
		return parseBool;
	}
	
	public void apareamientoSoluciones() {  
		
		for(int i=0;i<Soluciones.size();i+=2) {
			//Casillas 
			
			ArrayList<Integer> solucionA = new ArrayList<Integer>();
			ArrayList<Integer> solucionB = new ArrayList<Integer>();
			
			ArrayList<Integer> aux = new ArrayList<Integer>();
			
			
			//Soluciones
			solucionA = conversionBool(Soluciones.get(i));
			solucionB = conversionBool(Soluciones.get(i+1));  
			/*
			System.out.print("Nueva Solucion: "+solucionA);
			System.out.println("= "+getValor(solucionA));
			
			System.out.print("Nueva Solucion: "+solucionB);
			System.out.println("= "+getValor(conversionDec(solucionB)));
			*/
			
			int nodoCambio = (int)(Math.round((Math.random()*(solucionA.size()-1))));
			
			//System.out.println("Nodo Cambio: "+nodoCambio);
			for(int j=0;j<nodoCambio;j++) { 
				aux.add(solucionA.get(j));
				solucionA.set(j,solucionB.get(j));
				solucionB.set(j, aux.get(j));
			}
			/*
			System.out.print("Nueva Solucion: "+solucionA);
			System.out.println("= "+getValor(conversionDec(solucionA)));
			
			System.out.print("Nueva Solucion: "+solucionB);
			System.out.println("= "+getValor(conversionDec(solucionB)));
			*/
			this.Soluciones.set(i,conversionDec(solucionA));
			this.Soluciones.set(i+1,conversionDec(solucionB));
			
		}
		
	}
	
	public void aspirantesSoluciones(ArrayList<Double> listaProbabilidades) {
		
		ArrayList<ArrayList<Integer>> neoSoluciones = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<Soluciones.size();i++) {
			
			double tiroRuleta=Math.random(); 
			for(int j=0; j<listaProbabilidades.size(); j++) {
				
				if(tiroRuleta<listaProbabilidades.get(j)) {
					
					neoSoluciones.add(Soluciones.get(j));
					//System.out.println("Solucion Seleccionada: "+Soluciones.get(j));
					break;
					
				}
			}
			
		}
		
		this.Soluciones = neoSoluciones;
	}

	public ArrayList<Double> aptitudSoluciones() {
		
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
		
		//System.out.println("Total de Soluciones ="+aptAcum);
		return aptAcum;
		
	}
	
	public boolean verificacionDePeso(ArrayList<Integer> listaSolucion, int NuevoObjeto) {
		
		double PesoAcum=Pesos.get(NuevoObjeto);
		
		PesoAcum+= getPeso(listaSolucion); 
		
		if(PesoAcum<=Capacidad) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void generarSoluciones() {
		
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
								//if(getPeso(Solucion)>(Capacidad/2)) {
									
									flagObjetos = false;

								//}
							}
						}
						break;
					}
					
				}  
			}while(flagObjetos); 
			//System.out.println("Solucion Generada = "+Solucion);
			this.Soluciones.add(Solucion);
		}
	}
	
	//Constructor
	public problemaMochila(int id, double capacidad,ArrayList<ArrayList<Double>> datosMochila) {
		this.nHilo = id;
		this.Capacidad = capacidad;
		this.Pesos = datosMochila.get(0);
		this.Valores = datosMochila.get(1);
		this.Rueda = datosMochila.get(2); 
	}
	
	public problemaMochila(double capacidad,ArrayList<Double> Pesos,ArrayList<Double> Valores, ArrayList<Integer> Solucion) { 
		this.Capacidad = capacidad;
		this.Pesos = Pesos;
		this.Valores = Valores; 
		this.mejorSolucionHilo = Solucion; 
	}
	 
	public void busquedaLocal() { 
		
		boolean mejorSolucionFlag=true;

		int limiteIterador = (conversionBool(this.mejorSolucionHilo).size());
		
		do {
			
			double AptitudMstr= getValor(this.mejorSolucionHilo); 
			
			int mejorI=0;
			int mejorJ=0;
			
			double mejorApt=Double.MAX_VALUE;
			
			for(int i=0; i<limiteIterador;i++) {
				
				ArrayList<Integer> SolucionBin = conversionBool(this.mejorSolucionHilo); 
				SolucionBin.set(i, SolucionBin.get(i)==0 ? 1 : 0);  
				
				for(int j=0; j<limiteIterador; j++) {
					if(i!=j) {
						SolucionBin.set(j, SolucionBin.get(j)==0 ? 1 : 0);
						double tmpValor = getValor(conversionDec(SolucionBin));
						double tmpPeso = getPeso(conversionDec(SolucionBin));
						
						if(AptitudMstr< tmpValor && tmpPeso<=Capacidad) {
							
							if(mejorApt>tmpValor) { 
								mejorApt = tmpValor;
								mejorI=i;
								mejorJ=j; 
							}
						}
						SolucionBin.set(j, SolucionBin.get(j)==0 ? 1 : 0);
					}
				}

			}
			
			if(mejorI!=0 && mejorJ!=0) {
				System.out.println("\nSe ha encontrado una mejor solucion en la busqueda Local.");
				System.out.println("La anterior aptitud era de: " + AptitudMstr+" alternando estado de "+mejorI+" y "+mejorJ+" se encontro la aptitud "+ mejorApt);
				ArrayList<Integer> SolucionBin = conversionBool(this.mejorSolucionHilo);
				SolucionBin.set(mejorI, SolucionBin.get(mejorI)==0 ? 1 : 0); 
				SolucionBin.set(mejorJ, SolucionBin.get(mejorJ)==0 ? 1 : 0); 
				
				this.mejorSolucionHilo=conversionDec(SolucionBin);
				
				System.out.println("\nNueva Mejor solucion"+mejorSolucionHilo); 
				System.out.println("De peso: "+ getPeso(mejorSolucionHilo));
				System.out.println("Y de valor: "+ getValor(mejorSolucionHilo));
				 
			}else {
				mejorSolucionFlag=false;
			}
		}while(mejorSolucionFlag);
		
	}
	//Clase del arranque
	public void run() { 
		
		// Se genera un solucion parcial, en esta se usara valor/peso para obtener las aptitudes,  
		generarSoluciones();
		
		// Funcion que determina la aptitud de cada solucion, y genera otra ruleta basada en la aptitud total
		ArrayList<Double> probSeleccion = new ArrayList<Double>(); 
		probSeleccion = aptitudSoluciones();
		
		// Una vez seleccionadas se arranca la fase de apareamiento 
		aspirantesSoluciones(probSeleccion); 
		
		// Nueva generacion de soluciones aparece
		apareamientoSoluciones();
		  
		seleccionDelMejorSubHijo();
		
		mainMochila finalizacion = new mainMochila();
		finalizacion.adicionMonitor(nHilo,mejorSolucionHilo,getValor(mejorSolucionHilo),getPeso(mejorSolucionHilo));
	} 	
}