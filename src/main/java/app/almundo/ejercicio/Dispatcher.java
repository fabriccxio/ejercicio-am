package app.almundo.ejercicio;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Dispatcher {
	
	private int cantMaxLlamadas=3;
	
	public void dispatchCall(List<Llamada> listadollamadas) {
		
		long init = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newFixedThreadPool(cantMaxLlamadas);

		for (Llamada llamadaEntrante : listadollamadas) {
			Empleado empleadoRunnable=new Empleado(llamadaEntrante,init);
			
				executor.execute(empleadoRunnable);
//				if (executor instanceof ThreadPoolExecutor) {
//				    System.out.println(
//				        "Pool size is now " +
//				        ((ThreadPoolExecutor) executor).getQueue().size()
//				    );
//				}
			
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(120, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
	
	}

}
