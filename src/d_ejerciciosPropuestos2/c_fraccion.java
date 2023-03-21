package d_ejerciciosPropuestos2;

public class c_fraccion {
	//Atributos
	private int numerador;
	private int denominador;
	 
	//Constructores
	public c_fraccion() {}
	public c_fraccion(int nume, int deno) {
		this.numerador=nume;
		this.denominador=deno;
	}
	
	public void asignarNumerador(int numL) {
		this.numerador=numL;
	}
	
	public void asignarDenominador(int denL) {
		this.denominador=denL;
	}
	
	public double resultado() {
		double resultado = (double)numerador/denominador;
		return resultado;
	}
	
	public int obtenerNumerador() {
		return this.numerador;
	}
	
	public int obtenerDenominador() {
		return this.denominador;
	}
	
	public void imprimirFraccion() {
		System.out.println(numerador+"/"+denominador+" = "+resultado());
	} 
}
