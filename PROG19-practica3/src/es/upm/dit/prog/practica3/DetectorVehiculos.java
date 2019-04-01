package es.upm.dit.prog.practica3;

/**
 * Detector de vehiculos
 * @author Ramon Hernandez Garcia "ramon.hgarcia@alumnos.upm.es"
 *
 */
public class DetectorVehiculos {
	private int N = 10;
	private Vehiculo v;
	private Vehiculo[] detectados;
	private int n;
	
	public DetectorVehiculos (Vehiculo v) {
		this.detectados=new Vehiculo[N];
		this.n=0;
		this.v=v;
	}
	
	public Vehiculo getV() {
		return this.v;
	}
	
	public Vehiculo[] getDetectados() {
		return this.detectados;
	}
	
	//En el string muestro la lista de vehiculos detectados
	public String toString() {
		String str = "DetectorVehiculos [N=" + N + ", v=" + v + ", detectados=\n";
		for (int i=0; i < this.getDetectados().length; i++) {
			str+="\t"+i+". "+v+"\n";
		}
		str+=", n=" + n + "]";
		return str;
	}
	
	/**
	 * Busca un vehiculo por su id y devuelve el vehiculo con todos sus atributos
	 * @param v vehiculo ficticio con la id del vehiculo que buscamos
	 * @return vehiculo real con la misma id del vehiculo ficticio
	 */
	public Vehiculo buscaVehiculo (Vehiculo v) {
		for (Vehiculo v2: this.detectados) {
			if(v2!=null && v2.equals(v)) {
				return v2;
			}
		}
		return null;
	}

	/**
	 * Anade un vehiculo al array de vehiculos detectados en un hueco libre (null).
	 * Si no hay hueco libre, se sustituye el vehiculo con menor t por el nuevo
	 * @param v el vehiculo que se va a insertar
	 */
	public void addVehiculo (Vehiculo v) {
		if(v!=null) {
			for (int i=0; i < this.detectados.length; i++) {
				if(this.detectados[i]==null){
					this.detectados[i]=v;
					return;
				}
			}
			int indice=0;
			for (int i=0; i < this.detectados.length; i++) {
				if(this.detectados[i].getT() < this.detectados[indice].getT()) {
					indice=i;
				}
			}
			this.detectados[indice]=v;
		}
	}
	
	/**
	 * 
	 * @return devuelve un array con los vehiculos detectados no nulos
	 */
	public Vehiculo [] getVehiculos() {
		int numeroVehiculos=0;
		for (Vehiculo v: this.detectados) {
			if(v!=null) {
				numeroVehiculos++;
			}
		}
		Vehiculo[] copia = new Vehiculo[numeroVehiculos];
		int i=0;
		for (Vehiculo vAntiguo: this.detectados) {
			if(vAntiguo!=null) {
				copia[i]=vAntiguo;
				i++;
			}
		}
		return copia;
	}
	
	/**
	 * 
	 * @return devuelve los posibles vehiculos peligrosos de los vehiculos detectados
	 */
	public Vehiculo[] getVehiculosPeligrosos() {
		int numeroVehiculos=0;
		for (Vehiculo v: this.detectados) {
			if(v!=null && this.v.isPeligroso(v)) {
				numeroVehiculos++;
			}
		}
		Vehiculo[] copia = new Vehiculo[numeroVehiculos];
		int i=0;
		for (Vehiculo vAntiguo: this.detectados) {
			if(vAntiguo!=null && this.v.isPeligroso(vAntiguo)) {
				copia[i]=vAntiguo;
				i++;
			}
		}
		return copia;
	}
	
	/**
	 * 
	 * @param pos posicion
	 * @param t tiempo
	 * @return array con vehiculos compatibles con una posicion pos en el tiempo t
	 */
	public Vehiculo[] getVehiculosCompatibles (Vector pos, double t) {
		int numeroVehiculos=0;
		for (Vehiculo v: this.detectados) {
			if(v!=null && this.v.isPeligroso(v)) {
				numeroVehiculos++;
			}
		}
		Vehiculo[] copia = new Vehiculo[numeroVehiculos];
		int i=0;
		for (Vehiculo v: this.detectados) {
			if(v!=null && v.isPosicionCompatible(pos, t)) {
				copia[i]=v;
				i++;
			}
		}
		return copia;
	}

	/**
	 * Anade al array de vehiculos detectados un nuevo vehiculo con la posicion pos en el tiempo t o
	 * modifica uno ya existente moviendolo a esa posicion pos
	 * @param pos posicion
	 * @param t tiempo
	 */
	public void addDeteccion (Vector pos, double t) {
		if (this.getVehiculosCompatibles(pos, t).length != 0) {
			Vehiculo nuevo = this.getVehiculosCompatibles(pos, t)[0];
			nuevo.mover(pos, t);
			this.addVehiculo(nuevo);
		} else {
			this.addVehiculo(new Vehiculo("AUTO"+this.n++, pos, t, pos, t));
		}
	}
}
