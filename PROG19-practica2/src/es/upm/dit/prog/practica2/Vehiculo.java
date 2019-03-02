package es.upm.dit.prog.practica2;

public class Vehiculo {
	
	private String id;
	private Vector pos0;
	private double t0;
	private Vector pos;
	private double t;
	
	//Constantes
	private static final double MINIMAL_DISTANCE = 2;
	private static final double SAFETY_DISTANCE = 20;
	
	public Vehiculo(String id, Vector pos0, double t0, Vector pos, double t) {
		this.id = id;
		this.pos0 = pos0;
		this.t0 = t0;
		this.pos = pos;
		this.t = t;
	}

	//Establece el id del vehiculo
	public void setId(String id) {
		this.id=id;
	}

	//Establece el id del vehiculo
	public void setT(double t) {
		this.t=t;
	}
	
	//Devuelve el id del vehiculo
	public String getId() {
		return this.id;
	}
	
	//Devuelve el vector posicion inicial del vehiculo
	public Vector getPos0() {
		return this.pos0;
	}
	
	//Devuelve el t0 del vehiculo
	public double getT0() {
		return this.t0;
	}
	
	//Devuelve el vector posicion del vehiculo
	public Vector getPos() {
		return this.pos;
	}
	
	//Devuelve el t del vehiculo
	public double getT() {
		return this.t;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + this.id + ", pos0=" + this.pos0 + ", t0=" + this.t0 + ", pos=" + this.pos + ", t=" + this.t + "]";
	}
	
	public Vector getVelocidad() {
		//Calcula el vector velocidad salvo que no haya pasado tiempo de t0 a t
		if (this.t == this.t0) {
			return new Vector (0.0, 0.0);
		} else {
			double x = (this.pos.getX() - this.pos0.getX())/(this.t - this.t0);
			double y = (this.pos.getY() - this.pos0.getY())/(this.t - this.t0);
			return new Vector (x, y);
		}
	}
	
	public boolean isParado() {
		//El vehiculo esta parado si el modulo de la velocidad vale 0
		return (this.getVelocidad().modulo() == 0.0);
	}
	
	public void mover(Vector pos, double t) {
		//Al mover el vehiculo, las coordenadas finales son las iniciales y el tiempo final es el inicial
		this.pos0=this.pos;
		this.pos=pos;
		this.t0=this.t;
		this.t=t;
	}
	
	//Cambia la posicion final
	public void setPos(Vector pos) {
		this.pos = pos;
	}
	
	/* Este metodo lo que hace es cambiar la posicion del vehiculo manteniendo su velocidad intacta
	 * al pasarle un tiempo y calcular su posicion final en ese tiempo, pasándosela a mover(pos, t)
	 * para que la actualice 
	 */
	public void mover (double t) {
		if (t == this.t) {
			return;
		} else {
			double x = (this.pos.getX() + (this.getVelocidad().getX() * (t - this.t)));
			double y = (this.pos.getY() + (this.getVelocidad().getY() * (t - this.t)));
			mover(new Vector (x, y), t);
		}
	}
	
	/* Este metodo lo que hace es verificar la posicion de un vehiculo en el futuro en un tiempo
	 * determinado para saber si llegara a ese punto o estara a menos de 2 metros de el
	 */
	public boolean isPosicionCompatible(Vector pos, double t) {
		Vehiculo aux = new Vehiculo("aux", this.getPos0(), this.getT0(), this.getPos(), this.getT());
		aux.mover(t);
		return (aux.pos.distancia(pos) < MINIMAL_DISTANCE);
	}
	
	public double impacto(Vehiculo v2) {
		double dx = v2.getPos().getX() - this.getPos().getX();
		double dy = v2.getPos().getY() - this.getPos().getY();
		double dvx = this.getVelocidad().getX() - v2.getVelocidad().getX();
		double dvy = this.getVelocidad().getY() - v2.getVelocidad().getY();
		double tx = dx/dvx;
		double ty = dy/dvy;
		Vector dv = new Vector (dvx, dvy);
		if (this.pos.distancia(v2.getPos()) < MINIMAL_DISTANCE) {
			return 0.0;
		} else if ((dv.modulo() < MINIMAL_DISTANCE) || 
				(dx == 0 && dvx != 0) ||
				(dy == 0 && dvy != 0) ||
				(dvx == 0 && dx != 0) ||
				(dvy == 0 && dy != 0)) {
			return Double.POSITIVE_INFINITY;
		} else if (dvx == 0) {
			return dy/dvy;
		} else if (dvy == 0) {
			return dx/dvx;
		} else if (tx == ty) {
			 return tx;
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	/* Este metodo te dice si hay peligro de impacto si la distancia entre dos vehiculos es
	 * menor que 2 o si la distancia que hay entre vehiculos es menor de 20
	 */
	public boolean isPeligroso(Vehiculo v2) {
		return (this.pos.distancia(v2.getPos()) < MINIMAL_DISTANCE) || (Math.abs(this.impacto(v2)*this.getVelocidad().modulo()) < SAFETY_DISTANCE);
	}
}