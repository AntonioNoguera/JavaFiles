package e_ejerciciosPropuestos3;

public class a_ejercicio3 {
	static double evaluador(double a, double b, double c,double x) {
		double resultado = a*Math.pow(x, 3) + b*Math.pow(x, 2) - c*x + 3;
		return resultado;
	}
	
	public static void main(String[] args) {
		double a=5,b=-1.7,c=2,x=10.5;
		System.out.println(evaluador(a,b,c,x));
	}
}
