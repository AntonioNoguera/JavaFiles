package d_ejerciciosPropuestos2;

public class c_mainFracciones {
	//La asignación basicamente consiste en que mantengamos los valores del denominador
	//En operaciones con fraccioens
	
	public static void main(String[] args) {
		c_fraccion fraccionA = new c_fraccion(2,3);
		c_fraccion fraccionB = new c_fraccion(1,5);
		c_fraccion fraccionC = new c_fraccion();
		
		c_operacion ope = new c_operacion();
		
		fraccionC = ope.division(fraccionA,fraccionB);
		
		fraccionC.imprimirFraccion();
	}
}