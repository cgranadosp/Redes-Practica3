package hilos;

public class Secuencia1 implements Runnable {
	int tareaActual = 0;
	int numEvaluarPrimo = 1;
	int letraActual = 97;
	
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
				}
				
				if(divisor == 2){
					numPrimo = i;
					System.out.println("Número primo: "+numPrimo);
				
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						System.out.println("------Interrumpido mientras dormía-------");
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
			System.out.println(letra);
			
			i_continua++;
			
			if(i_continua>122)
				i_continua = 97;
			
			letraActual = i_continua;
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.out.println("------Interrumpido mientras dormía-------");
				cambioDeTarea();
			}
		}
			
//			if(i_continua > 122)
//				i_continua = 97;
//			
//			for(int i = i_continua; i < 123; i++){
//				char letra = (char) i;
//				
//				letraActual = i+1;
//				System.out.println(letra);
//				
//				try {
//					Thread.sleep(250);
//				} catch (InterruptedException e) {
//					System.out.println("------Interrumpido mientras dormía-------");
//					cambioDeTarea();
//				}
//				
//			}
//		}
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
