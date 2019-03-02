package es.upm.dit.prog.practica2;

import java.util.Scanner;

public class PruebaVehiculo {

	public static void main(String[] args) {
		
		double t = 0.0;
		
		Vector pos0 = new Vector (0.0, 0.0);
		Vehiculo v0 = new Vehiculo ("id0", pos0, t, pos0, t);
		
		Vehiculo v = new Vehiculo ("id1", pos0, t, pos0, t);
		System.out.println(v);
		System.out.println("Velocidad: " + v.getVelocidad() + " Parado?= " + v.isParado() + " Distancia al origen= " + v.getPos().distancia(v0.getPos()));
		
		t += 1;
		v.mover(new Vector (100.0, 100.0), t);
		System.out.println(v.toString());
		System.out.println("Velocidad: " + v.getVelocidad() + " Parado?= " + v.isParado() + " Distancia al origen= " + v.getPos().distancia(v0.getPos()));

		t += 1;
		v.mover(new Vector (200.0, 200.0), t);
		System.out.println(v.toString());
		System.out.println("Velocidad: " + v.getVelocidad() + " Parado?= " + v.isParado() + " Distancia al origen= " + v.getPos().distancia(v0.getPos()));

		
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduzca valores de x e y (Ctrl-D para acabar):");
		while (sc.hasNext()) {
			t++;
				v.mover(new Vector(sc.nextDouble(), sc.nextDouble()), t);
			System.out.println(v.toString());
			System.out.println("Velocidad: " + v.getVelocidad() +
					" Parado?= " + v.isParado() + " Distancia al origen= " + v.getPos().distancia(v0.getPos()));
			
			System.out.println("Introduzca valores de x e y (Ctrl-D para acabar):");
		}
		sc.close();
		// distancia
		// mover
	}

}
