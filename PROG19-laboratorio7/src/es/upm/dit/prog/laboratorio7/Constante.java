package es.upm.dit.prog.laboratorio7;

public class Constante implements GeneradorNumeros {
	private double c;

	public Constante (double c) {
		this.c=c;
	}
	
	public double getSiguienteNumero() {
		return this.c;
	} //: genera y devuelve un nuevo número entero, 
	public double getUltimoNumero() {
		return this.c;
	}//: devuelve el último entero que generó el método anterior, sin generar uno nuevo,
	public String getNombreGenerador() {
		return "Constante";
	}//: devuelve una String con el nombre de la clase que genera los números.
}
