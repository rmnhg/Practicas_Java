package es.upm.dit.prog.laboratorio7;

public class Contador implements GeneradorNumeros{
	private double c;

	public Contador () {
		this.c=0.0;
	}
	
	public double getSiguienteNumero() {
		return ++this.c;
	} //: genera y devuelve un nuevo número entero, 
	public double getUltimoNumero() {
		return this.c;
	}//: devuelve el último entero que generó el método anterior, sin generar uno nuevo,
	public String getNombreGenerador() {
		return "Contador";
	}//: devuelve una String con el nombre de la clase que genera los números.
}
