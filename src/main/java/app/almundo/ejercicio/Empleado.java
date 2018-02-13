package app.almundo.ejercicio;

import java.util.Random;

public class Empleado implements Runnable{
	
	private Llamada llamada;
	private long initialTime;
	
	public Empleado(Llamada llamada,long initialTime) {
		super();
		this.llamada = llamada;
		this.initialTime = initialTime;
	}
	
	public void run() {
		procesarLlamada();
	}

	private void procesarLlamada() {
		System.out.println("hilo:"+Thread.currentThread().getName()+"-LLamada:"+llamada.getNombre() +"	HA empezado EN EL TIEMPO ------------: " + (System.currentTimeMillis() - this.initialTime) / 1000	+"seg");
		tiempoLlamada();
		System.out.println("hilo:"+Thread.currentThread().getName()+"-LLamada:"+llamada.getNombre() +"	HA TERMINADO DE PROCESAR EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
	}
	
	private void tiempoLlamada() {
		try {
			long rango = (long)10 - (long)5 + 1;
		    // compute a fraction of the range, 0 <= frac < range
		    long fraction = (long)(rango * new Random().nextDouble());
		    int randomNumber =  (int)(fraction + 5);    
		    //System.out.println("Generated : " + randomNumber);
			Thread.sleep(randomNumber * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
