package c_POO;

public class CCuenta {
	//Atributos
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipodeInteres;
	
	//Constructores
		//Constructor Vacio
	public CCuenta(){}
		//Constructor Declarado
	public CCuenta(String nom, String cue, double sal, double tipo) {
		asignarNombre(nom);
		asignarCuenta(cue);
		ingreso(sal);
		asignarTipoDeInteres(tipo);
	}
	
	//Metodos
	public void asignarNombre(String nom) {
		if(nom.length()==0) {
			System.out.println("Error Cadena Vacía");
			return;
		}
		nombre=nom;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void asignarCuenta(String cue) {
		if(cue.length()==0) {
			System.out.println("Cadena Vacía");
			return ;
		}
		cuenta=cue;
	}
	
	public String obtenerCuenta() {
		return cuenta;
	}
	
	public double estado() {
		return saldo;
	}
	
	public void ingreso(double cant) {
		if(cant<0) {
			System.out.println("Error: Cantidad negativa");
			return;
		}
		
		saldo+=cant;
	}
	
	public void reintegro(double cant) {
		System.out.println(cant);
		if((saldo-cant)<0) {
			System.out.println("Error: No tiene el saldo necesario para poder retirar esa cantidad.");
			return;
		} 
		saldo=saldo-cant; 
	}
	
	public void asignarTipoDeInteres(double tipo) {
		if(tipo<0) {
			System.out.println("El tipo de intenes no es válido.");
			return;
		}
		tipodeInteres = tipo;
	}
	
	
	public double obtenerTipoDeInteres() {
		return tipodeInteres;
	}
}