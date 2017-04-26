package hilos;

public class Secuencia2 implements Runnable {

	int tareaActual;

	public void calcularFibonacci(){
		
		Double funcion;
		int numFibonacci;
		int n = 0;
		
		while(true){
			funcion = ((1/Math.sqrt(5))*Math.pow((1+Math.sqrt(5))/2, n))+0.5;
			numFibonacci = funcion.intValue();
			
			if(numFibonacci==2147483647)
				n = 0;
			else
				n++;
			
			System.out.println("Fibonacci: "+numFibonacci);
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.out.println("------Interrumpido mientras dormía-------");
				
			}
			
		}
	}
	
	public void calcularNumeroPar(){
		int numeroPar = 0;
		
		while(true){
			numeroPar = numeroPar+2;
			System.out.println("Número par: "+numeroPar);
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

	@Override
	public void run() {
		calcularFibonacci();
	}
}
