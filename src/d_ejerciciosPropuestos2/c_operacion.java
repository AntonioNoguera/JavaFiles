package d_ejerciciosPropuestos2;

public class c_operacion { 
	
	//Como idea una funcion que permita simplificar la fraccion mediante el uso
	//de divisores
	public c_fraccion multiplicacion(c_fraccion fraccA, c_fraccion fraccB) {
		int aNum=fraccA.obtenerNumerador();
		int aDen=fraccA.obtenerDenominador();
		
		int bNum=fraccB.obtenerNumerador();
		int bDen=fraccB.obtenerDenominador();
		
		int cNum= aNum*bNum;
		int cDen= aDen*bDen;
		
		return new c_fraccion(cNum,cDen);
	}
	
	public c_fraccion suma(c_fraccion fraccA, c_fraccion fraccB) {
		int aNum = fraccA.obtenerNumerador();
		int aDen = fraccA.obtenerDenominador();
		
		int bNum = fraccB.obtenerNumerador();
		int bDen = fraccB.obtenerDenominador();
		
		int cNum = (aNum*bDen)+(bNum*aDen);
		int cDen = aDen*bDen;	
		
		return new c_fraccion(cNum, cDen);
	}
	
	public c_fraccion resta(c_fraccion fraccA, c_fraccion fraccB) {
		int aNum = fraccA.obtenerNumerador();
		int aDen = fraccA.obtenerDenominador();
		
		int bNum = fraccB.obtenerNumerador();
		int bDen = fraccB.obtenerDenominador();
		
		int cNum = (aNum*bDen)-(bNum*aDen);
		int cDen = aDen*bDen;	
		
		return new c_fraccion(cNum, cDen);
	}
	
	public c_fraccion division(c_fraccion fraccA, c_fraccion fraccB) {
		int aNum = fraccA.obtenerNumerador();
		int aDen = fraccA.obtenerDenominador();
		
		int bNum = fraccB.obtenerNumerador();
		int bDen = fraccB.obtenerDenominador();
		
		int cNum = aNum*bDen;
		int cDen = bNum*aDen;	
		
		return new c_fraccion(cNum, cDen);
	}
	
	public c_fraccion simplificar(c_fraccion fraccTemp) {
		//int tNum = fraccTemp.obtenerNumerador();
		//int tDen = fraccTemp.obtenerDenominador();
		
		
		
		return fraccTemp;
	}
}
