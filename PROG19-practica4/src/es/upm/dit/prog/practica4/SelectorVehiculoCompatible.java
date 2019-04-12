package es.upm.dit.prog.practica4;

public class SelectorVehiculoCompatible implements SelectorVehiculo {
	private Vector pos;
	private double t;
	
	public SelectorVehiculoCompatible (Vector pos, double t) {
		this.pos=pos;
		this.t=t;
	}

	/**
	 * Compara si el vehiculo v no es nulo y es compatible respecto a pos y a t
	 */
	public boolean seleccionar(Vehiculo v) {
		return (v != null) && v.isPosicionCompatible(this.pos, this.t);
	}
}
