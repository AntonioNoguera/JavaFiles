package a_Introduccion;

public class ProcesosAricmeticos {
	public static void main(String[] args) {
		int A=1, B=5, C=16, Resultado;
		
		//Para la suma
		Resultado = A+B+C;
		System.out.println("El resultado de la suma de: "+A+" + "+B+" + "+C+" = "+Resultado);
		
		//Para la resta
		Resultado = -A-B-C;
		System.out.println("El resultado de la resta total es: "+A+" - "+B+" - "+C+" = "+Resultado);
		
		//Para la multiplicación
		Resultado = A*B*C;
		System.out.println("El resultado del producto total es: "+A+" × "+B+" × "+C+" = "+Resultado);
		
		float ResultadoF = A/B/C;
		System.out.println("El resultado de la división total es: "+A+" / "+B+" / "+C+" = "+ResultadoF);
	}
}
