package es.upm.dit.prog.practica1;

public class Vector {
	private double x;
	private double y;


	public Vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Vector other = (Vector) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}
	
	public double modulo() {
		return Math.sqrt(this.x*this.x+this.y*this.y);
	}
	
	public double angulo() {
		return Math.atan2(this.y, this.x);
	}
	
	public double distancia(Vector pos) {
		Vector distancia = new Vector((this.x-pos.getX()), (this.y-pos.getY()));
		return distancia.modulo();
	}
}
