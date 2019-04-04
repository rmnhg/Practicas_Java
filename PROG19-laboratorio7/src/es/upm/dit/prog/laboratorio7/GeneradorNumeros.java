package es.upm.dit.prog.laboratorio7;

public interface GeneradorNumeros {
	public double getSiguienteNumero(); //: genera y devuelve un nuevo n�mero entero, 
	public double getUltimoNumero();//: devuelve el �ltimo entero que gener� el m�todo anterior, sin generar uno nuevo,
	public String getNombreGenerador();//: devuelve una String con el nombre de la clase que genera los n�meros.
}
