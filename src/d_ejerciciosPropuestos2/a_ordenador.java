package d_ejerciciosPropuestos2;

public class a_ordenador {
	// Atributos
	private String marca;
	private String procesador;
	private double peso;

	private boolean encendidoFlag = false;
	private boolean pantallaFlag = false;
	private String aplicacion = "Ninguna";
	
	//Constructores
	public a_ordenador() {}
	
	public a_ordenador(String mar, String pro, double pesoL) {
		establecerMarca(mar);
		establecerProcesador(pro);
		establecerPeso(pesoL);
	}
	
	// Metodos

	public void establecerMarca(String marcaL) {
		if (marcaL.length() == 0) {
			System.out.println("Error: no puedes establecer una cadena vacia");
			return ;
		}
		marca=marcaL;
	}
	
	public void establecerProcesador(String procesadorL) {
		if(procesadorL.length() == 0) {
			System.out.println("ERROR: Procesador VACIO");
			return;
		}
		procesador = procesadorL;
	}
	
	public void establecerPeso(double pesoL) {
		if(pesoL<1) {
			System.out.println("ERROR EL PESO NO PUEDE SER NEGATIVO");
			return ;
		}
		peso=pesoL;
	}
	
	public void encenderOrdenador() {
		if(encendidoFlag==true) {
			System.out.println("ERROR LA PANTALLA YA ESTA ENCENDIDA");
			return;
		}
		encendidoFlag=true;
	}
	
	public void apagarOrdenador() {
		if(encendidoFlag!=true) {
			System.out.println("ERROR YA ESTA ENCENDIDO EL ORDENADOR");
			return;
		}
		encendidoFlag=false;
	}
	
	public void encenderPantalla() {
		if(encendidoFlag==true) {
			System.out.println("ERROR: YA ESTA ENCENDIDA LA PANTALLA");
			return;
		}
		pantallaFlag = true;
	}
	
	public void apagarPantalla() {
		if(pantallaFlag!=true) {
			System.out.println("ERROR: YA ESTA APAGADA LA PANTALLA");
			return;
		}
		pantallaFlag = false;
	}
	
	public void establecerAplicacion(String aplicacionL) {
		if(aplicacion.length()!=0) {
			System.out.println("La aplicación: "+aplicacion+" se ha detenido!");
		}
		aplicacion=aplicacionL;
		System.out.println("La aplicacion: "+aplicacionL+" se ha arrancado!!!!");
	}
	
	public String estadoPantalla() {
		String estado = "Apagada";
		
		if(pantallaFlag==true) {
			estado="Encendida";
		}
		
		return estado;
	}
	
	public String estadoOrdenador() {
		String estado = "Apagado";
		
		if(encendidoFlag==true) {
			estado="Encendido";
		}
		
		return estado;
	}
	 
	
	public void estado() {
		System.out.println("La marca del ordenador es: "+marca);
		System.out.println("El procesador es: "+procesador);
		System.out.println("El peso es de: "+peso+" kg");
		System.out.println("El ordenador esta: "+estadoOrdenador());
		System.out.println("La pantalla esta: "+estadoPantalla());
		System.out.println("La aplicacion actual es: "+aplicacion);
		
	}
	
}
