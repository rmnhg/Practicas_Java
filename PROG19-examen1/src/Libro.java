
public class Libro {
	private String nombre;
	private int anio;
	private boolean prestado;
	
	public Libro (int anio, String nombre) {
		this.anio=anio;
		this.nombre=nombre;
		this.prestado=false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean getPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	public String toString() {
		return "Libro [anio="+this.getAnio()+", nombre="+this.getNombre()+"]";
	}
}
