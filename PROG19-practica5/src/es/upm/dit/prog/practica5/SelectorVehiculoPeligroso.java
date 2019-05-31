package es.upm.dit.prog.practica5;

public class SelectorVehiculoPeligroso implements SelectorVehiculo {
	private Vehiculo v;
	
	public SelectorVehiculoPeligroso (Vehiculo v) {
		this.v=v;
	}

	/**
	 * Compara si el vehiculo v no es nulo y es peligroso respecto a this.v
	 */
	public boolean seleccionar(Vehiculo v) {
		return (v != null) && v.isPeligroso(this.v);
	}
}
