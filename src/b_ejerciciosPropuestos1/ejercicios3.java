package b_ejerciciosPropuestos1;

public class ejercicios3 {
	//Esscriba un metodo denominado calcular y que devuelva el resultado de la
	//Expresion (b²-4ac)/2a
	
	public static float calcular(int a, int b, int c) {
		
		float numerador = (float)((b*b)-(4*a*c))/(2*a);
		
		return numerador;
	}
	
	public static void main(String[] args) {
		int A=1, B=5, C=2;
		System.out.println(calcular(A,B,C));
	}
}
