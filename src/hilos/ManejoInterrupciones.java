package hilos;

import javax.swing.JTextArea;

import files.CreadorLog;

public class ManejoInterrupciones implements Runnable{
	
	Thread hilo_secuencia1;
	Thread hilo_secuencia2;
	Thread hilo_interrupciones;
	
	JTextArea textArea_hi;
	
	int contadorInterrupciones1 = 1;
	int contadorInterrupciones2 = 1;
	
	CreadorLog logger;
	Secuencia1 secuencia1;
	Secuencia2 secuencia2;
	
	StringBuilder sb;
	
	public ManejoInterrupciones(JTextArea textArea_h1, JTextArea textArea_h2, JTextArea textArea_hi, CreadorLog logger){
		
		this.textArea_hi = textArea_hi;
		
		secuencia1 = new Secuencia1(textArea_h1);
		hilo_secuencia1 = new Thread(secuencia1);
		hilo_secuencia1.start();
		
		secuencia2 = new Secuencia2(textArea_h2);
		hilo_secuencia2 = new Thread(secuencia2);
		hilo_secuencia2.start();
		
		this.logger = logger;
	}

	@Override
	public void run() {
		
		while(contadorInterrupciones1 < 12 && contadorInterrupciones2 < 12){
			
			try{
				if(contadorInterrupciones1 == 11){
					Thread.sleep(2000);
					hilo_secuencia1.stop();
				}
				if(contadorInterrupciones2 == 11){
					Thread.sleep(1000);
					hilo_secuencia2.stop();
					break;
				}
				
				Thread.sleep(2000);
				hilo_secuencia1.interrupt();
				
				//--------------hilo 1
				sb = new StringBuilder();
				sb.append("----------------------------------------\n");
				sb.append("ID: " + hilo_secuencia1.getId() + "\n");
				sb.append("Nombre: " + hilo_secuencia1.getName() + "\n");
				sb.append("Estado actual: " + hilo_secuencia1.getState() + "\n");
				if(secuencia1.tareaActual == 0)
					sb.append("Secuencia: Números primos\n");
				else
					sb.append("Secuencia: Abecedario\n");
				sb.append("----------------------------------------\n");
				logger.guardarInformacion(sb);
				
				
				//--------------hilo 3
				sb = new StringBuilder();
				getInformacion();
				logger.guardarInformacion(sb);
				
				textArea_hi.append("#" + contadorInterrupciones1 + " para el hilo_secuencia1 \n");
				contadorInterrupciones1++;
				
				Thread.sleep(1000);
				hilo_secuencia2.interrupt();
				
				
				//--------------hilo 2
				sb = new StringBuilder();
				sb.append("----------------------------------------\n");
				sb.append("ID: " + hilo_secuencia2.getId() + "\n");
				sb.append("Nombre: " + hilo_secuencia2.getName() + "\n");
				sb.append("Estado actual: " + hilo_secuencia2.getState() + "\n");
				if(secuencia2.tareaActual == 0)
					sb.append("Secuencia: Serie de Fibonacci \n");
				else
					sb.append("Secuencia: Números pares \n");
				sb.append("----------------------------------------\n");
				logger.guardarInformacion(sb);
				
				
				//--------------hilo 3
				sb = new StringBuilder();
				getInformacion();
				logger.guardarInformacion(sb);
				
				textArea_hi.append("#" + contadorInterrupciones2 + " para el hilo_secuencia2 \n");
				contadorInterrupciones2++;
				
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		
		logger.cerrarArchivo();
		
	}
	
	public void getInformacion(){
		int numInterrupciones = contadorInterrupciones1 + contadorInterrupciones2;
		
		sb.append("----------------------------------------\n");
		sb.append("ID: " + hilo_interrupciones.getId() + "\n");
		sb.append("Nombre: " + hilo_interrupciones.getName() + "\n");
		sb.append("Estado actual: " +hilo_interrupciones.getState() + "\n");
		sb.append("Númeo de interrupciones: " + numInterrupciones + "\n");
		sb.append("----------------------------------------\n");
	}
	
	public void setHilo(Thread hilo){
		this.hilo_interrupciones = hilo;
	}
}
