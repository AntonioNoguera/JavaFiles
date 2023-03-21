package d_ejerciciosPropuestos2;

public class b_mainCoches {
	//Represente Coches
	//Atributos marca modelo y color
	//Metodos
	//Arrancar motor, cambiar velocidad, acelerar, frenar y parar motor.
	public static void main(String[] args) {
		b_coche Auto1 = new b_coche("Mercedes AMG","G-63","NEGRO");
		
		Auto1.estado();
		Auto1.encenderMotor();
		Auto1.acelerar(12.15);
		Auto1.estado();
		Auto1.frenar(10);
		Auto1.estado();
	}	
}
