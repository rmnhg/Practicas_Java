package es.upm.dit.prog.laboratorio4;

public class Complejo {
	private double a;
	private double b;
	
	public Complejo(double a, double b) {
		this.a=a;
		this.b=b;
	}
	
	public double getA() {
		return this.a;
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public double getB() {
		return this.b;
	}
	
	public void setB(double b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
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
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Complejo [a=" + this.a + ", b=" + this.b + "]";
	}
	
	// Devuelve el modulo
	public double modulo() {
		return Math.sqrt(this.a*this.a+this.b*this.b);
	}

	// Devuelve el angulo respecto al eje x: use Math.atan2
	public double angulo() {
		return Math.toDegrees(Math.atan2(this.b, this.a));
	}

	// Devuelve otro objeto Complejo opuesto a this
	public Complejo opuesto()  {
		return new Complejo (-this.getA(), -this.getB());
	}

	// Devuelve otro objeto Complejo conjugado de this
	public Complejo conjugado() {
		return new Complejo (this.getA(), -this.getB());
	}

	// Devuelve otro objeto Complejo suma de this + c
	public Complejo suma (Complejo c) {
		return new Complejo ((this.getA()+c.getA()), (this.getB()+c.getB()));
	}

	// Devuelve otro objeto Complejo multiplicación de this * c
	public Complejo multiplica (Complejo c) {
		//(a1*a2-b1*b2)+(a1*b2+a2*b1)i
		return new Complejo ((this.getA()*c.getA()-this.getB()*c.getB()), (this.getA()*c.getB()+c.getA()*this.getB()));
	}

	// Devuelve otro objeto Complejo división de this / c
	public Complejo divide (Complejo c) {
		//((a*c+b*d)/(c*c+d*d))+((b*c-a*d)/(c*c+d*d))i
		return new Complejo (((this.getA()*c.getA()+this.getB()*c.getB())/(c.getA()*c.getA()+c.getB()*c.getB())), ((this.getB()*c.getA()-this.getA()*c.getB())/(c.getA()*c.getA()+c.getB()*c.getB())));
	}

}
