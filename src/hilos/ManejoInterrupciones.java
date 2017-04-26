package hilos;

import javax.swing.JTextArea;

public class ManejoInterrupciones implements Runnable{
	
	static Thread hilo_secuencia1;
	static Thread hilo_secuencia2;
	JTextArea textArea_hi;
	
	public ManejoInterrupciones(JTextArea textArea_h1, JTextArea textArea_h2, JTextArea textArea_hi){
		
		this.textArea_hi = textArea_hi;
		
		Secuencia1 secuencia1 = new Secuencia1(textArea_h1);
		hilo_secuencia1 = new Thread(secuencia1);
		hilo_secuencia1.start();
		
		Secuencia2 secuencia2 = new Secuencia2(textArea_h2);
		hilo_secuencia2 = new Thread(secuencia2);
		hilo_secuencia2.start();
	}

	@Override
	public void run() {
		int contadorInterrupciones1 = 1;
		int contadorInterrupciones2 = 1;
		
		while(contadorInterrupciones1 < 11 && contadorInterrupciones2 < 11){
			try{
				Thread.sleep(2000);
				hilo_secuencia1.interrupt();
				textArea_hi.append("Interrupción " + contadorInterrupciones1 + " para el hilo_secuencia1 \n");
				contadorInterrupciones1++;
				
				Thread.sleep(1000);
				hilo_secuencia2.interrupt();
				textArea_hi.append("Interrupción " + contadorInterrupciones2 + " para el hilo_secuencia2 \n");
				contadorInterrupciones2++;
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
}
