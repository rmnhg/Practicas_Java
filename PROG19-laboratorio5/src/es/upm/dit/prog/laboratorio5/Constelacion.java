package es.upm.dit.prog.laboratorio5;

public class Constelacion {
	private Complejo[] numero;
	
	public Constelacion (Complejo[] numero) {
		int nulls=0;
		for (int i=0; i<numero.length; i++) {
			if (numero[i]==null) {
				nulls++;
			}
		}
		Complejo[] aux = new Complejo[numero.length-nulls];
		for (int i=0,j=0; i<numero.length; i++) {
			if (numero[i]!=null) {
				aux[j]=numero[i];
				j++;
			}
		}
		this.numero=aux;
	}
	
	public Complejo[] getNumero () {
		int nulls=0;
		for (int i=0; i<this.numero.length; i++) {
			if (this.numero[i]==null) {
				nulls++;
			}
		}
		Complejo[] aux = new Complejo[this.numero.length-nulls];
		for (int i=0,j=0; i<this.numero.length; i++) {
			if (this.numero[i]!=null) {
				aux[j]=this.numero[i];
				j++;
			}
		}
		return aux;
	}
	
	public void setNumero(Complejo[] numero) {
		int nulls=0;
		for (int i=0; i<numero.length; i++) {
			if (numero[i]==null) {
				nulls++;
			}
		}
		Complejo[] aux = new Complejo[numero.length-nulls];
		for (int i=0,j=0; i<numero.length; i++) {
			if (numero[i]!=null) {
				aux[j]=numero[i];
				j++;
			}
		}
		this.numero=aux;
	}
	public String toString () {
		return "Constelacion numero="+this.numero;
	}
	
	public boolean equals (Constelacion c) {
		return this.numero==c.numero;
	}
	
	public Complejo getCentro () {
		int nulls=0;
		double r = 0;
		double im = 0;
		//Elimina referencias a null
		for (int i=0; i<this.numero.length; i++) {
			if (this.numero[i]==null) {
				nulls++;
			}
		}
		Complejo[] aux = new Complejo[numero.length-nulls];
		for (int i=0,j=0; i<numero.length; i++) {
			if (this.numero[i]!=null) {
				aux[j]=this.numero[i];
				j++;
			}
		}
		
		/* Hacemos la media de las partes reales e imaginarias del array de
		 * complejos aux.
		 */
		for(int i=0; i<aux.length;i++) {
			r=r+aux[i].getR();
			im=im+aux[i].getI();
		}
		r=r/(aux.length);
		im=im/(aux.length);
		return new Complejo(r, im);
	}
	
	public Complejo cercano (Complejo c) {
		double dist = numero[0].suma(c.opuesto()).mod();
		double distMinima;
		int n = 0;
		for(int i=0; i<numero.length; i++) {
			distMinima = numero[i].suma(c.opuesto()).mod();
			if (distMinima < dist) {
				dist=distMinima;
				n=i;
			}
		}
		return new Complejo(numero[n].getR(), numero[n].getI());
	}
 }
