package hilosTest; 

public class hilos extends Thread {
	
	public int retornar() {
		return 10;
	}
    public void run() {
        System.out.println("¡Hola desde el hilo!");
       
    }
}
