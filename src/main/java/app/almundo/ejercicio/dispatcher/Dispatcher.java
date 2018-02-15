package app.almundo.ejercicio.dispatcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import app.almundo.ejercicio.entity.Llamada;
import app.almundo.ejercicio.entity.Empleado;

public class Dispatcher {
	
	private int cantMaxLlamadas=10;
	private static final String EMPLEADO_OPERADOR="OPERADOR";
	private static final String EMPLEADO_SUPERVISOR="SUPERVISOR";
	private static final String EMPLEADO_DIRECTOR="DIRECTOR";
	
	/**
	 * Se encarga de asignar la llamadas a los operadores libres.
	 * En este caso se cuenta con 10 operadores libres inicialmente
	 * @param listadollamadas
	 */
	public void dispatchCall(List<Llamada> listadollamadas) {
		long init = System.currentTimeMillis();//Obtiene el tiempo inicial en que se ejecuta el metodo
		
		ExecutorService executorOperador = Executors.newFixedThreadPool(cantMaxLlamadas);//indicamos la cantidad de hilos que se van a disponer para tratar las tareas

		for (Llamada llamadaEntrante : listadollamadas) {
			Empleado operadorRunnable=new Empleado(llamadaEntrante,init,EMPLEADO_OPERADOR);
			executorOperador.execute(operadorRunnable);
		}
		
		executorOperador.shutdown();
		
		try {
			executorOperador.awaitTermination(120, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long fin = System.currentTimeMillis();//Toma el tiempo para determinar el tiempo total del hilo principal 
        System.out.println("Tiempo total de procesamiento ["+(fin-init)/1000+"] Segundos");
	}

}
