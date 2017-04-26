package hilos;

import javax.swing.JTextArea;

public class Secuencia2 implements Runnable {

	int tareaActual = 0;
	int numEvaluarFibonacci = 0;
	int numEvaluarPar = 0;
	JTextArea textArea_h2;
	 
	int numInterrupcion = 0;
	
	public Secuencia2(JTextArea textArea_h2){
		this.textArea_h2 = textArea_h2;
	}

	//Tarea 0
	public void calcularFibonacci(){
		
		Double funcion;
		int numFibonacci;
		
		while(true){
			funcion = ((1/Math.sqrt(5))*Math.pow((1+Math.sqrt(5))/2, numEvaluarFibonacci))+0.5;
			numFibonacci = funcion.intValue();
			
			if(numFibonacci==2147483647)
				numEvaluarFibonacci = 0;
			else
				numEvaluarFibonacci++;
			
			//System.out.println("Fibonacci: "+numFibonacci);
			textArea_h2.append(numFibonacci + "\n");
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				numInterrupcion++;
				textArea_h2.append("----Interrupción #" + numInterrupcion + "---- \n Números pares \n");
				cambioDeTarea();
			}
			
		}
	}
	
	//Tarea 1
	public void calcularNumeroPar(){
		while(true){
			numEvaluarPar += 2;
			textArea_h2.append(numEvaluarPar + "\n");
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				numInterrupcion++;
				textArea_h2.append("----Interrupción #" + numInterrupcion + "---- \n Serie de Fibonacci \n");
				cambioDeTarea();
			}
		}
	}
	
	public void cambioDeTarea(){
		if(tareaActual == 0){
			tareaActual = 1;
			calcularNumeroPar();
		}else{
			tareaActual = 0;
			calcularFibonacci();
		}
	}
	
	public StringBuilder getInformacion(StringBuilder sb){
		
		sb.append("----------------------------------------\n");
		sb.append("ID: " + Thread.currentThread().getId() + "\n");
		sb.append("Nombre: " + Thread.currentThread().getName() + "\n");
		sb.append("Estado actual: " + Thread.currentThread().getState() + "\n");
		if(tareaActual == 0)
			sb.append("Secuencia: Serie de Fibonacci \n");
		else
			sb.append("Secuencia: Números pares \n");
		sb.append("----------------------------------------\n");
		
		return sb;
	}

	@Override
	public void run() {
		calcularFibonacci();
	}
}
