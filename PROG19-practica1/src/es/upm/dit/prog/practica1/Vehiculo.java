package es.upm.dit.prog.practica1;

public class Vehiculo {
	
	private String id;
	private Vector pos0;
	private double t0;
	private Vector pos;
	private double t;
	
	public Vehiculo(String id, Vector pos0, double t0, Vector pos, double t) {
		super();
		this.id = id;
		this.pos0 = pos0;
		this.t0 = t0;
		this.pos = pos;
		this.t = t;
	}

	public void setId(String id) {
		this.id=id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Vector getPos0() {
		return this.pos0;
	}
	
	public double getT0() {
		return this.t0;
	}
	
	public Vector getPos() {
		return this.pos;
	}
	
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
		return "Vehiculo [id=" + id + ", pos0=" + pos0 + ", t0=" + t0 + ", pos=" + pos + ", t=" + t + "]";
	}
	
	public Vector getVelocidad() {
		if (this.t == this.t0) {
			return new Vector (0.0, 0.0);
		} else {
			double x = (this.pos.getX() - this.pos0.getX())/(this.t - this.t0);
			double y = (this.pos.getY() - this.pos0.getY())/(this.t - this.t0);
			return new Vector (x, y);
		}
	}
	
	public boolean isParado() {
		return (this.getVelocidad().modulo() == 0.0);
	}
	
	public void mover(Vector pos, double t) {
		this.pos0=this.pos;
		this.pos=pos;
		this.t0=this.t;
		this.t=t;
	}
	
	public void setPos(Vector pos) {
		this.pos = pos;
	}
}
