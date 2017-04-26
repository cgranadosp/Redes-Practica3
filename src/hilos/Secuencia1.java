package hilos;

import javax.swing.JTextArea;

public class Secuencia1 implements Runnable {
	
	int tareaActual = 0;
	int numEvaluarPrimo = 1;
	int letraActual = 97;
	JTextArea textArea_h1;
	int numInterrupcion = 0;
	
	public Secuencia1(JTextArea textArea_h1){
		this.textArea_h1 = textArea_h1;
	}
	
	//Tarea 0
	public void calcularNumeroPrimo(){
		while(true){
			int numPrimo = 0;
			int divisor = 0;
			int i_continua = numEvaluarPrimo;
			
			for(int i = i_continua; i < 1000; i++){
				for(int j = 1; j < i+1; j++){
					
					numEvaluarPrimo = i+1;
					if(i%j == 0)
						divisor++;
					
					if(numEvaluarPrimo>997)
						numEvaluarPrimo = 1;
				}
				
				if(divisor == 2){
					numPrimo = i;
					//System.out.println("Número primo: "+numPrimo);
					textArea_h1.append(numPrimo + "\n");
				
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						numInterrupcion++;
						textArea_h1.append("------Interrupción #" + numInterrupcion + "------ \n Abecedario \n");
						cambioDeTarea();
					}
				}
				
				divisor = 0;
			}
		}
	}
	
	
	//Tarea 1
	public void imprimirAbecedario(){
		int i_continua = letraActual;
		
		while(true){
			char letra = (char) i_continua;
			//System.out.println(letra);
			textArea_h1.append(letra + "\n");
			
			i_continua++;
			
			if(i_continua>122)
				i_continua = 97;
			
			letraActual = i_continua;
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				numInterrupcion++;
				textArea_h1.append("------Interrupción #" + numInterrupcion + "------ \n Números primos \n");
				cambioDeTarea();
			}
		}
	}
	
	public void cambioDeTarea(){
		if(tareaActual == 0){
			tareaActual = 1;
			imprimirAbecedario();
		}else{
			tareaActual = 0;
			calcularNumeroPrimo();
		}
	}

	@Override
	public void run() {
		calcularNumeroPrimo();
	}
}
