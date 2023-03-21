package c_POO;

public class CCuentaAhorro extends CCuenta{
	
	//Atributos
	private double cuotaDeMantenimiento;
	//Constructores
	public CCuentaAhorro() {	}
	
	public CCuentaAhorro(String nom, String cue, double sal, double tipo, double mant) {
		super(nom, cue, sal, tipo);
		AsignarCuotaMant(mant);
	}
	
	public void AsignarCuotaMant(double mant) {
		if(mant<0) {
			System.out.println("Error: El valor de la cuota no puede ser Menor a 0!!!");
			return;
		}
		cuotaDeMantenimiento = mant;
	}
	
	public double ObtenerCuota() {
		return cuotaDeMantenimiento;
	}
	
	public void reintegro(double cantidad) {
		double saldo = estado();
		double tipoDeInteres = obtenerTipoDeInteres();
		
		
		if(tipoDeInteres >= 3.5) {
			if((saldo-cantidad)<1500) {
				System.out.println("Error: No cuentas con el saldo necesarioa!!!!");
				return;
			}
		} 
		super.reintegro(cantidad);
	}
	
	
}
