package es.upm.dit.prog.practica5;

public interface SelectorVehiculo {
	/**
	 * Devuelve si un vehiculo cumple una determinada condicion o no
	 * @param v vehiculo a comparar
	 * @return si v cumple una determinada condicion o no ademas de no ser nulo
	 */
	public boolean seleccionar(Vehiculo v);
}
