package c_POO;

public class poo {
	public static void main(String[] args) { 
		CCuentaAhorro cuenta01 = new CCuentaAhorro("Un nombre","Una Cuenta",6000,3.5,0.80);
		
		cuenta01.reintegro(cuenta01.ObtenerCuota());
		System.out.println(cuenta01.estado());
		cuenta01.ingreso(6000);
		System.out.println(cuenta01.estado());
		cuenta01.reintegro(10000); 
		
		System.out.println(cuenta01.obtenerNombre());
		System.out.println(cuenta01.obtenerCuenta());
		System.out.println(cuenta01.estado());
		System.out.println(cuenta01.obtenerTipoDeInteres());
	}
}
