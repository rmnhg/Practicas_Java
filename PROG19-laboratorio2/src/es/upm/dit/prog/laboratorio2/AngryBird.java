
package es.upm.dit.prog.laboratorio2;

public class AngryBird {
	
	private String id;
	private double v;
	private double angulo;
	
	private static final double g = 9.80665;
	
	public AngryBird(String id, double v, double angulo) {
		super();
		this.id = id;
		this.v = v;
		this.angulo = angulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public double getTiempo() {
		return (2*this.v*Math.sin(this.angulo))/g;
	}
	
	public double getAltura() {
		return (this.v*Math.sin(this.angulo)*this.v*Math.sin(this.angulo))/(2*g);
	}
	
	public double getDistancia() {
		return (2*this.v*Math.cos(this.angulo)*this.v*Math.sin(this.angulo))/g;
	}
}
