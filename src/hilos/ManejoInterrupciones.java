package hilos;

public class ManejoInterrupciones implements Runnable{
	
	static Thread hilo_secuencia1;
	static Thread hilo_secuencia2;

	public static void main(String args[]){
		
		Secuencia2 secuencia2 = new Secuencia2();
		hilo_secuencia2 = new Thread(secuencia2);
		//hilo_secuencia2.start();
		
		Secuencia1 secuencia1 = new Secuencia1();
		hilo_secuencia1 = new Thread(secuencia1);
		hilo_secuencia1.start();
		
		ManejoInterrupciones interrupciones = new ManejoInterrupciones();
		Thread hilo_interrupciones = new Thread(interrupciones);
		hilo_interrupciones.start();
	}

	@Override
	public void run() {
		int contador = 0;
		
		while(contador < 10){
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
			hilo_secuencia1.interrupt();
			
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				e.printStackTrace();
			}
			//hilo_secuencia2.interrupt();
			
			contador++;
		}
	}
}
