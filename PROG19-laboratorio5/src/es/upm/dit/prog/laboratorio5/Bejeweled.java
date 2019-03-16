/**
 *
 */
package es.upm.dit.prog.laboratorio5;

import java.util.Random;

/**
 * @author 
 * @version 
 */
public class Bejeweled {

	private int[][] tablero;
	private final static int MAXGEMASDISTINTAS = 5;
	private Random r;
	
	public Bejeweled(int [][] tablero) {
		this.tablero = tablero;
		this.r = new Random();
	}
	
	@Override
	public String toString() {
		String res = "---------------------\n";
		//for (int i = tablero.length-1; i >= 0; i--) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				res += tablero[i][j]+ " ";
			}
			res += "\n";
		}
		return res + "---------------------\n";
	}

	public void copiarFila(int from, int to) {
		for (int i = 0; i < this.tablero[from].length; i++) {
			this.tablero[to][i] = this.tablero[from][i];
		}
	}
	
	public void addUltimaFila() {
		for (int i = 0; i < this.tablero[this.tablero.length -1].length; i ++) {
			this.tablero[this.tablero.length -1][i] = this.r.nextInt(MAXGEMASDISTINTAS-1) +1;
		}
	}
	
	public int maxIguales (int fila) throws Exception {
		if(fila < 0 || fila > (tablero.length-1)) {
			throw new Exception("Error, fila="+fila+" is out of bounds.");
		}
		int duplicados = 0;
		int[] repeticiones = new int[tablero[fila].length];
		for (int i=0; i < tablero[fila].length; i++) {
			duplicados=1;
			for(int j=i; j < tablero[fila].length-1; j++) {
				if(tablero[fila][j]==tablero[fila][j+1]) {
					duplicados++;
				}
			}
			repeticiones[i]=duplicados;
		}
		int max = repeticiones[0];
		for(int i=0; i<repeticiones.length;i++) {
			if(repeticiones[i]>max) {
				max=repeticiones[i];
			}
		}
		return max;
	}

	public void eliminarFila(int fila) throws Exception {
		if(fila < 0 || fila > (tablero.length-1)) {
			throw new Exception("Error, fila="+fila+" is out of bounds.");
		}
		for(int i=fila; i < (tablero.length-1); i++) {
			this.copiarFila(i+1,i);
		}
		this.addUltimaFila();
	}
	
	
	public void actualizar() throws Exception {
		for (int i = 0; i < this.tablero.length; i++) {
			while (this.maxIguales(i) >= 3) {
				this.eliminarFila(i);
			}
		}	
	}
	
	
	
	/**
	 * getter que devuelve el numero de filas del tablero
	 * @return numero de filas del tablero
	 */
	public int getFilasTablero(){
		return tablero.length;
	}

	/**
	 * getter que devuelve el numero de columnas del tablero
	 * @return numero de columnas del tablero
	 */
	public int getColumnasTablero(){
		return tablero[0].length;
	}

}
