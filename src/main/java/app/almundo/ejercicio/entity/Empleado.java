package app.almundo.ejercicio.entity;

import java.util.Random;

public class Empleado implements Runnable{
	
	private Llamada llamada;//llamada a tratar
	private long initialTime;//tiempo en que inicia el proceso
	private String tipo;
	
	public Empleado(Llamada llamada,long initialTime, String tipo) {
		super();
		this.llamada = llamada;
		this.initialTime = initialTime;
		this.tipo=tipo;
	}
	
	public void run() {
		System.out.println("Hilo ["+Thread.currentThread().getName()+"] LLamada ["+llamada.getNombre() +"] Empleado ["+tipo+"] Empezo en el tiempo [" + (System.currentTimeMillis() - this.initialTime) / 1000	+"] seg");
		procesarLlamada();
		System.out.println("Hilo ["+Thread.currentThread().getName()+"] LLamada ["+llamada.getNombre() +"] Empleado ["+tipo+"]Termino de procesar en el tiempo [" + (System.currentTimeMillis() - this.initialTime) / 1000 + "] seg");
	}
	
	/**
	 * Procesa la llamada asignada a este operador siendo aleatorio el tiempo que puede llevar procesarla.
	 */
	private void procesarLlamada() {
		try {
			Thread.sleep(tiempoLlamada() * 1000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Obtiene un valor aleatorio entre 5 y 10
	 * @return un entero
	 */
	private int tiempoLlamada() {
		long rango = (long)10 - (long)5 + 1;
		long fraction = (long)(rango * new Random().nextDouble());
	    return (int)(fraction + 5);
	}
	
}
