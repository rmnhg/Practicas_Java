package es.upm.dit.prog.practica2;

public class Vector {
	private double x;
	private double y;


	public Vector (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Devuelve la X
	public double getX() {
		return this.x;
	}

	//Devuelve la Y
	public double getY() {
		return this.y;
	}
	
	//Asigna una nueva X
	public void setX(double x) {
		this.x = x;
	}
	
	//Asigna una nueva Y
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
		return "Vector [x=" + this.x + ", y=" + this.y + "]";
	}
	
	public double modulo() {
		return Math.sqrt(Math.pow(this.x, 2.0)+Math.pow(this.y, 2.0));
	}
	
	public double angulo() {
		return Math.atan2(this.y, this.x);
	}
	
	public double distancia(Vector pos) {
		return Math.sqrt(Math.pow((this.x-pos.getX()), 2.0)+Math.pow((this.y-pos.getY()), 2.0));
	}
}