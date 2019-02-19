package es.upm.dit.prog.laboratorio3;

public class ElementoRadiactivo {
	private String nombre;
	private double l; //Cte radiactiva
	
	public ElementoRadiactivo (String nombre, double l) {
		this.nombre=nombre;
		this.l=l;
	}
	public double getL() {
		return this.l;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getVidaMedia() {
		return (Math.log(2)/this.l);
	}
	
	public double getProporcionDesintegrados(long tiempo) {
		return (1-Math.exp(-this.l*tiempo));
	}
	
	@Override
	public String toString() {
		return "ElementoRadiactivo [nombre=" + nombre + ", l=" + l + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(l);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	public boolean equals(ElementoRadiactivo el) {
		return (this.getNombre().equals(el.getNombre()) && this.l==el.getL());
	}
}
