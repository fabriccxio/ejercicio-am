package app.almundo.ejercicio.main;

import java.util.ArrayList;
import java.util.List;

import app.almundo.ejercicio.dispatcher.Dispatcher;
import app.almundo.ejercicio.entity.Llamada;

public class CallCenter 
{
    public static void main( String[] args )
    {
        int cantLlamadas=11;
        List<Llamada> listLlamadas=new ArrayList<Llamada>();
       
        for (int i = 1; i < (cantLlamadas+1); i++) {//se carga el listado de llamadas para simular el ejercicio.
        	listLlamadas.add(new Llamada("Llamada "+ i));//se le indica un nombre para poder monitorizar la gestion de llamadas
		}
        
        Dispatcher dispatcher=new Dispatcher();
        dispatcher.dispatchCall(listLlamadas);;
    }
}
