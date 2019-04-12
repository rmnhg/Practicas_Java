package es.upm.dit.prog.practica4;

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
			str+="\t"+i+". "+this.detectados[i]+"\n";
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
		for (int i=0; i < this.detectados.length; i++) {
			if(this.detectados[i]!=null && this.detectados[i].equals(v)) {
				return this.detectados[i];
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
			boolean metido = false;
			for (int i=0; i < this.detectados.length; i++) {
				if(!metido && this.detectados[i]==null){
					this.detectados[i]=v;
					metido=true;
					break;
				}
			}
			if (!metido) {
				double t = this.detectados[0].getT();
				int indice=0;
				for (int i=0; i < this.detectados.length; i++) {
					if(this.detectados[i].getT() < t) {
						t=this.detectados[i].getT();
						indice=i;
					}
				}
				this.detectados[indice]=v;
			}
		}
	}
	
	/**
	 * Devuelve un array de vehiculos que cumplen una determinada condicion
	 * @param s selector de vehiculos que define la condicion que deben cumplir los vehiculos que se
	 * devuelven (ninguna, peligrosos, compatibles)
	 * @return un array de vehiculos con los vehiculos no nulos que cumplen la condicion definida en
	 * el selector de vehiculos pasado como parametro. Si el parametro es null, devuelve un array de
	 * vehiculos vacio
	 */
	public Vehiculo [] getVehiculos(SelectorVehiculo s) {
		if (s == null)
			return new Vehiculo[0];
		int numeroVehiculos=0;
		for (int i=0; i < this.detectados.length; i++) {
			if(s.seleccionar(this.detectados[i])) {
				numeroVehiculos++;
			}
		}
		Vehiculo[] copia = new Vehiculo[numeroVehiculos];
		int j=0;
		for (int i=0; i < this.detectados.length; i++) {
			if(s.seleccionar(this.detectados[i])) {
				copia[j]=this.detectados[i];
				j++;
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
		SelectorVehiculo s = new SelectorVehiculoCompatible(pos, t);
		if (this.getVehiculos(s).length!= 0) {
			Vehiculo nuevo = this.getVehiculos(s)[0];
			nuevo.mover(pos, t);
			this.addVehiculo(nuevo);
		} else {
			this.addVehiculo(new Vehiculo("AUTO"+this.n++, pos, t, pos, t));
		}
	}
}
