package hilosTest;

public class main {
	public static void main(String[] args) {
		hilos hilo = new hilos();
        hilo.start();
        int variable = hilo.retornar();
        System.out.println(variable);
    }
}
