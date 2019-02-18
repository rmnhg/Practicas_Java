package es.upm.dit.prog.practica1;

public class PruebaVector {

	public static void main(String[] args) {
		Vector v0 = new Vector(0.0, 0.0);
		System.out.print (v0);
		System.out.println (" Mod= " + v0.modulo() + " Ang= " + v0.angulo() + " Rad= " + Math.toDegrees(v0.angulo()));

		Vector v1 = new Vector(-100.0, -100.0);
		System.out.print (v1);
		System.out.println (" Mod= " + v1.modulo() + " Ang= " + v1.angulo() + " Rad= " + Math.toDegrees(v1.angulo()));
		
		Vector v2 = new Vector(100.0, -100.0);
		System.out.print (v2);
		System.out.println (" Mod= " + v2.modulo() + " Ang= " + v2.angulo() + " Rad= " + Math.toDegrees(v2.angulo()));
		
		Vector v3 = new Vector(100.0, 100.0);
		System.out.print (v3);
		System.out.println (" Mod= " + v3.modulo() + " Ang= " + v3.angulo() + " Rad= " + Math.toDegrees(v3.angulo()));
		
		Vector v4 = new Vector(-100.0, 100.0);
		System.out.print (v4);
		System.out.println (" Mod= " + v4.modulo() + " Ang= " + v4.angulo() + " Rad= " + Math.toDegrees(v4.angulo()));

		System.out.println("Distancia v0-v0=" + v0.distancia(v0));
		System.out.println("Distancia v0-v1=" + v0.distancia(v1));
		System.out.println("Distancia v0-v2=" + v0.distancia(v2));
		System.out.println("Distancia v0-v3=" + v0.distancia(v3));
		System.out.println("Distancia v0-v4=" + v0.distancia(v4));
		System.out.println("Distancia v1-v1=" + v1.distancia(v1));
		System.out.println("Distancia v1-v2=" + v1.distancia(v2));
		System.out.println("Distancia v1-v3=" + v1.distancia(v3));
		System.out.println("Distancia v1-v4=" + v1.distancia(v4));
		System.out.println("Distancia v2-v2=" + v2.distancia(v2));
		System.out.println("Distancia v2-v3=" + v2.distancia(v3));
		System.out.println("Distancia v2-v4=" + v2.distancia(v4));
		System.out.println("Distancia v3-v3=" + v3.distancia(v3));
		System.out.println("Distancia v3-v4=" + v3.distancia(v4));
		System.out.println("Distancia v4-v4=" + v4.distancia(v4));
	}

}
