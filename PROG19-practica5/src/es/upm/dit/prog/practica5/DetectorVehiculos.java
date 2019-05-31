package es.upm.dit.prog.practica5;

import java.util.*;

/**
 * Detector de vehiculos
 * @author Ramon Hernandez Garcia "ramon.hgarcia@alumnos.upm.es"
 *
 */
public class DetectorVehiculos {
	private Vehiculo v;
	private List<Vehiculo> detectados;
	private int n;

	public DetectorVehiculos(Vehiculo v) {
		this.v=v;
		this.detectados = new ArrayList<Vehiculo>();
		this.n=0;
	}
	
	public Vehiculo getV() {
		return this.v;
	}

	@Override
	public String toString() {
		return "DetectorVehiculos [v=" + v + ", detectados=" + detectados + ", n=" + n + "]";
	}
	
	/**
	 * Anade un vehiculo a la lista de vehiculos detectados.
	 * @param v el vehiculo que se va a insertar
	 */
	public void addVehiculo(Vehiculo v) {
		this.detectados.add(v);
	}

	/**
	 * Busca un vehiculo por su id y devuelve el vehiculo con todos sus atributos
	 * @param v vehiculo ficticio con la id del vehiculo que buscamos
	 * @return vehiculo real con la misma id del vehiculo ficticio
	 */
	public Vehiculo buscaVehiculo(Vehiculo v) {
		if (this.detectados.contains(v)) {
			return this.detectados.get(this.detectados.indexOf(v));
		}
		return null;
	}

	/**
	 * Devuelve una lista de vehiculos que cumplen una determinada condicion
	 * @param s selector de vehiculos que define la condicion que deben cumplir los vehiculos que se
	 * devuelven (ninguna, peligrosos, compatibles).
	 * @return una lista de vehiculos con los vehiculos no nulos que cumplen la condicion definida en
	 * el selector de vehiculos pasado como parametro. Si el parametro es null, devuelve una lista de
	 * vehiculos vacia.
	 */
	public List<Vehiculo> getVehiculos(SelectorVehiculo s) {
		if (s == null)
			return new ArrayList<Vehiculo>();
		List<Vehiculo> res = new ArrayList<Vehiculo>();
		for(Vehiculo v: this.detectados) {
			if(s.seleccionar(v)) {
				res.add(v);
			}
		}
		return res;
	}

	/**
	 * Anade a la lista de vehiculos detectados un nuevo vehiculo con la posicion pos en el tiempo t o
	 * modifica uno ya existente moviendolo a esa posicion pos.
	 * @param pos posicion
	 * @param t tiempo
	 */
	public void addDeteccion (Vector pos, double t) {
		SelectorVehiculo s = new SelectorVehiculoCompatible(pos, t);
		if (this.getVehiculos(s).size() != 0) {
			Vehiculo nuevo = this.getVehiculos(s).get(0);
			nuevo.mover(pos, t);
			this.addVehiculo(nuevo);
		} else {
			this.addVehiculo(new Vehiculo("AUTO"+this.n++, pos, t, pos, t));
		}
	}
}
