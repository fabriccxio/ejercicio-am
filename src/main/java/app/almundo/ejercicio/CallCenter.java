package app.almundo.ejercicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class CallCenter 
{
    public static void main( String[] args )
    {
        int cantLlamadas=10;
        List<Llamada> listLlamadas=new ArrayList<Llamada>();
        
        for (int i = 1; i < (cantLlamadas+1); i++) {
        	listLlamadas.add(new Llamada("Llamada "+ i));
		}
        
        Dispatcher dispatcher=new Dispatcher();
        
        dispatcher.dispatchCall(listLlamadas);;
    }
}
