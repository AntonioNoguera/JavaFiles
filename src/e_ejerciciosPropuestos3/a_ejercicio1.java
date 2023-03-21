package e_ejerciciosPropuestos3;

public class a_ejercicio1 {
	/**una aplicacion que visualice en el monitor los siguientes mensajes
	Bienvenido al mundo de JAVA
	Podrás dar solución a muchos problemas.
	
	LA PALABRA STATIC INDICA AL USUARIO QUE EL METODO PERTENECE A LA ISNTANCIA, Y NO ES NECESARIO CREAR UN OBJETO
	PARA PODER USAR DICHA FUNCION
	**/
	
	 static void Bienvenida(String nombre) {
		System.out.println("Bienvenido "+nombre+"!, al mundo de JAVA. \nPodras dar solucion a muchos problemas.");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Bienvenida("Antonio");
	}
}
