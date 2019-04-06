package es.upm.dit.prog.laboratorio8;

import java.util.*;

public class RadarTramo {
	private String id;
	private double l;
	private double Vmax;
	private Map<String, Long> vehiculos;
	private Map<String, Long> vehiculosMultados;

	public RadarTramo(String id, double l, double Vmax) {
		this.id=id;
		this.l=l;
		this.Vmax=Vmax;
		this.vehiculos=new HashMap<String, Long>();
		this.vehiculosMultados=new HashMap<String, Long>();
	}
	
	/**
	 * El m�todo para indicar que entra un nuevo veh�culo es:
	 * public void entra(String v), y a�ade una nueva entrada
	 * al atributo HashMap, con la clave v y con System.currentTimeMillis() como valor.
	 * @param v
	 */
	public void entra (String v) {
		this.vehiculos.put(v, new Long(System.currentTimeMillis()));
	}
	
	public Set<String> getVehiculosTramo() {   
		return this.vehiculos.keySet();
	}
	
	public  Set<String> getVehiculosMultados() {
		return this.vehiculosMultados.keySet();
	}
	
	/**
	 * public void sale(String v), que mira si el veh�culo est� en el atributo,
	 * si est� toma el valor del tiempo en el que entr� y el tiempo actual, con
	 * lo que ya conoce cu�nto ha tardado. Tambi�n deber� borrar el veh�culo del HashMap.
	 * @param v
	 */
	public void sale (String v) {
		long tiempo = System.currentTimeMillis()-this.vehiculos.get(v);
		double velocidad = this.l/tiempo;
		if (velocidad > this.Vmax) {
			this.vehiculosMultados.put(v, this.vehiculos.get(v));
		}
		this.vehiculos.remove(v);
	}
	
	public void borraVehiculosMultados() {
		this.vehiculosMultados.clear();
	}
}
