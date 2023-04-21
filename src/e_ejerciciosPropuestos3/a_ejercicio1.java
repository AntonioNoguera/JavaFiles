package e_ejerciciosPropuestos3;

public class a_ejercicio1 {
	/**una aplicacion que visualice en el monitor los siguientes mensajes
	Bienvenido al mundo de JAVA
	Podrás dar solución a muchos problemas.
	
	LA PALABRA STATIC INDICA AL USUARIO QUE EL METODO PERTENECE A LA ISNTANCIA, Y NO ES NECESARIO CREAR UN OBJETO
	PARA PODER USAR DICHA FUNCION
	
	Si declaramos la funcion como static void, solamente esta clase tendra acceso a esta funcion, 
	para el test(A) fue requerido hacer uso de la palabra reservada public, de esta forma esta clase tiene acceso a esta
	funcion, estando en otro paquete
	
	**/
	
	
	
	 public static void Bienvenida(String nombre) {
		System.out.println("Bienvenido "+nombre+"!, al mundo de JAVA. \nPodras dar solucion a muchos problemas.");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Bienvenida("Antonio");
	}
}
