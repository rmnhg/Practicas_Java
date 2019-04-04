package es.upm.dit.prog.laboratorio7;

public class Aleatorio implements GeneradorNumeros {
	private int maximo;
	private double ultimo;
	private java.util.Random random;

	public Aleatorio (int maximo) {
		random = new java.util.Random();
		this.maximo = maximo;
		this.ultimo = random.nextInt(maximo-1);
	}
	
	public double getSiguienteNumero() {
		ultimo = random.nextInt(maximo-1);
		return ultimo;
	} //: genera y devuelve un nuevo número entero, 
	public double getUltimoNumero() {
		return ultimo;
	}//: devuelve el último entero que generó el método anterior, sin generar uno nuevo,
	public String getNombreGenerador() {
		return "Aleatorio";
	}//: devuelve una String con el nombre de la clase que genera los números.
}
