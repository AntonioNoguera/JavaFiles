package b_ejerciciosPropuestos1;

public class ejercicio2 {
	//Calcula la suma y la media de cuatro números de tipo int
	public static void main(String[] args){
		int A=2, B=23, C=42,Suma=0;
		
		Suma=A+B+C;
		float Promedio = (float)Suma/3;
		
		System.out.println("El resultado de la sumatoria es: "+Suma);
		System.out.println("El resultado de la media es: "+Promedio);
	}
}