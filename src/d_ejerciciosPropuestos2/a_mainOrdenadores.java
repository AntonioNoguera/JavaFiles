package d_ejerciciosPropuestos2;

public class a_mainOrdenadores {
	public static void main(String[] args) {
		a_ordenador ordenadorA = new a_ordenador("Toshiba","Intel",12);
		
		ordenadorA.encenderPantalla();
		ordenadorA.encenderOrdenador();
		ordenadorA.establecerAplicacion("League of Legends");
		
		ordenadorA.estado();
	}
}
