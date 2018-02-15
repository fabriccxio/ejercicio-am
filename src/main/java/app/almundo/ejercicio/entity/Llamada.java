package app.almundo.ejercicio.entity;

public class Llamada {
	
	private String nombre;//nombre para realizar un seguimiento

	public Llamada(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Obtiene el nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea el nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
