package temasSelectosMochila;
 

public class mainMochila {
	public static void main(String[] args) {
		
		//Arrancando Hilo
		
		for(int i=0;i<10;i++) {
			problemaMochila hilo = new problemaMochila();
			hilo.start(); 
			try {
				hilo.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
	        hilo.seleccionDelMejorSubHijo();
		}
		
    }
}
