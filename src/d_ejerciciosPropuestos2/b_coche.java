package d_ejerciciosPropuestos2;

public class b_coche {
	//Atributos
	private String marca;
	private String modelo;
	private String color;
	
	private boolean estadoMotor=false;
	private double velocidad=0;
	
	//Constructor
	public b_coche() {}
	public b_coche(String mar, String mod, String col) {
		establecerMarca(mar);
		establecerModelo(mod);
		establecerColor(col);
	}
	
	public void establecerMarca(String marcaL) {
		if(marcaL.length()==0) {
			System.out.println("ERROR LA MARCA NO PUEDE SER NADA");
			return;
		}
		marca = marcaL;
	}
	
	public void establecerModelo(String modeloL) {
		if(modeloL.length()==0) {
			System.out.println("ERROR EL MODELO NO PUEDE SER NULO");
			return;
		}
		modelo=modeloL;
	}
	
	public void establecerColor(String colorL) {
		if(colorL.length()==0) {
			System.out.println("ERROR EL COLOR NO PUEDE SER NULO");
			return;
		}
		color=colorL;
	}
	
	public void encenderMotor() {
		if(estadoMotor) {
			System.out.println("ERROR EL MOTOR YA ESTA ENCENDIDO");
			return;
		}
		estadoMotor=true;
	}
	
	public void apagarMotor() {
		if(velocidad!=0) {
			System.out.println("ES PELIGROSO APAGAR EL MOTOR EN MOVIMIENTO!!!");
			return;
		}
		
		if(!estadoMotor) {
			System.out.println("ERROR EL MOTOR YA ESTA APAGADO");
			return;
		}
		estadoMotor=false;
	}
	
	public String estadoMotor() {
		String estado="Apagado";
		if(estadoMotor) {
			estado="Encendido";
		}
		return estado;
	}
	
	public void acelerar(double velocidadL) {
		if(!estadoMotor) {
			System.out.println("ERROR EL MOTOR ESTA APAGADO!!!");
			return;
		}
			
		if(velocidadL<=0) {
			System.out.println("La velocidad no puede aumentar en 0 o menos!!!");
			return;
		}
		
		velocidad+=velocidadL;
	}
	
	public void frenar(double velocidadL) {
		if(!estadoMotor) {
			System.out.println("ERROR EL MOTOR ESTA APAGADO!!!");
			return;
		}
		
		if(velocidadL<=0) {
			System.out.println("ERROR: No puedes frenar en 0 o menos");
			return;
		}
		
		if((velocidad-velocidadL)<=0) {
			System.out.println("No puedes disminuir en esa velocidad!!!!");
			return;
		}
		
		velocidad-=velocidadL;
	}
	
	public String obtenerMarca() {
		return marca;
	}
	
	public String obtenerModelo() {
		return modelo;
	}
	
	public String obtenerColor() {
		return color;
	}
	
	public double velocidadActual() {
		return velocidad;
	}
	
	public void estado() {
		System.out.println("\n\n\nREPORTE DE LA UNIDAD!!!!!!!!");
		System.out.println("La marca es: "+obtenerMarca());
		System.out.println("El modelo es: "+obtenerModelo());
		System.out.println("El color del coche es: "+obtenerColor());
		System.out.println("El motor esta: "+estadoMotor());
		System.out.println("La velocidad actual del carro es de: "+velocidad+" km/s");
	}
	
	
	
}