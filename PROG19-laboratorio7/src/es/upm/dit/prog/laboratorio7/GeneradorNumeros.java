package es.upm.dit.prog.laboratorio7;

public interface GeneradorNumeros {
	public double getSiguienteNumero(); //: genera y devuelve un nuevo número entero, 
	public double getUltimoNumero();//: devuelve el último entero que generó el método anterior, sin generar uno nuevo,
	public String getNombreGenerador();//: devuelve una String con el nombre de la clase que genera los números.
}
