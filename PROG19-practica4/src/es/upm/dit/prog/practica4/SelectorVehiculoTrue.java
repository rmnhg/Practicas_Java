package es.upm.dit.prog.practica4;

public class SelectorVehiculoTrue implements SelectorVehiculo {
	/**
	 * Compara si el vehiculo v no es nulo
	 */
	public boolean seleccionar(Vehiculo v) {
		return (v != null);
	}
}
