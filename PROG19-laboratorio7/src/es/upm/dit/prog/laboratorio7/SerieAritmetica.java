package es.upm.dit.prog.laboratorio7;

public class SerieAritmetica implements GeneradorNumeros {
	private double t0;
	private double t;
	private int n;

	public SerieAritmetica (double t0, double t) throws Exception {
		if (t<=0) {
			throw new Exception();
		} else {
			this.t0=t0;
			this.t=t;
			this.n=0;
		}
	}
	
	public double getSiguienteNumero() {
		return t0+t*++n;
	} //: genera y devuelve un nuevo número entero, 
	public double getUltimoNumero() {
		return t0+t*n;
	}//: devuelve el último entero que generó el método anterior, sin generar uno nuevo,
	public String getNombreGenerador() {
		return "SerieAritmetica";
	}//: devuelve una String con el nombre de la clase que genera los números.
}
