package app.almundo.ejercicio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;

public class DispatcherTest {

	@Test
	public void testDispatchCall() {
		try {
			int cantLlamadas=10;
	        List<Llamada> listLlamadas=new ArrayList<Llamada>();
	        
	        for (int i = 1; i < (cantLlamadas+1); i++) {
	        	listLlamadas.add(new Llamada("Llamada "+ i));
			}
	        
	        Dispatcher dispatcher=new Dispatcher();

	        dispatcher.dispatchCall(listLlamadas);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
