package es.upm.dit.prog.practica2;

import static org.junit.Assert.assertEquals;

public class PruebaVehiculo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector[] poss = new Vector[10];
		for (int i = 0; i < poss.length; i++) {
			poss[i] = new Vector(i*10.0, i*10.0);
		}
		double t = 0;
		Vehiculo v0 = new Vehiculo ("id0", poss[0], t, poss[1], ++t);
		for (int i = 0; i < poss.length; i++) {
			t++;
			v0.mover(t);
			System.out.println(v0 + "\nVelocidad= " + v0.getVelocidad());
			assertEquals(new Vector(10.0, 10.0), v0.getVelocidad());
		}

		
		
		final int NPASOS = 10;
		t = 0;
		Vector[] pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i * 10.0);
		}
		Vector[] pos2 = new Vector[NPASOS];
		for (int i = 0; i < pos2.length; i++) {
			pos2[i] = new Vector (90 - (i*10.0), i * 10.0);
		}

		Vehiculo v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		Vehiculo v2 = new Vehiculo("v2", pos2[0], t, pos2[1], t+10);

		t += 10;
		System.out.println("------------- CRUCE -----------");
		for (int i = 1; i < NPASOS; i++) {
			t += 10;
			v1.mover(pos1[i], t);
			v2.mover(pos2[i], t);
			System.out.println(v1 + " " + v1.getVelocidad());
			System.out.println(v2 + " " + v2.getVelocidad());
			System.out.println("Impacto esperado en " + v1.impacto(v2) + " s");
			System.out.println("Es peligroso: " + v1.isPeligroso(v2));
		}
		
		// ----------------------------------------
		t = 0;
		pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i*10.0);
		}
		pos2 = new Vector[NPASOS];
		for (int i = 0; i < pos2.length; i++) {
			pos2[i] = new Vector (10 + (i*10.0), i*10.0);
		}

		v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		v2 = new Vehiculo("v2", pos2[0], t, pos2[1], t+10);
		
		t += 10;
		System.out.println("------------- PARALELOS IGUAL SENTIDO -----------");
		for (int i = 1; i < NPASOS; i++) {
			t += 10;
			v1.mover(pos1[i], t);
			v2.mover(pos2[i], t);
			System.out.println(v1);
			System.out.println(v2);
			System.out.println("Impacto esperado en " + v1.impacto(v2) + " s");
			System.out.println("Es peligroso: " + v1.isPeligroso(v2));
		}
	
		// ----------------------------------------
		
		t = 0;
		pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i*10.0);
		}
		pos2 = new Vector[NPASOS];
		for (int i = 0; i < pos2.length; i++) {
			pos2[i] = new Vector (90 - (i*10.0), 80 - (i*10.0));
		}

		v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		v2 = new Vehiculo("v2", pos2[0], t, pos2[1], t+10);
		
		t += 10;
		System.out.println("------------- PARALELOS DISTINTO SENTIDO -----------");
		for (int i = 1; i < NPASOS; i++) {
			t += 10;
			v1.mover(pos1[i], t);
			v2.mover(pos2[i], t);
			System.out.println(v1 + " " + v1.getVelocidad());
			System.out.println(v2 + " " + v2.getVelocidad());
			System.out.println("Impacto esperado en " + v1.impacto(v2) + " s");
			System.out.println("Es peligroso: " + v1.isPeligroso(v2));
		}
		
		// ----------------------------------------
		t = 0;
		pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i*10.0);
		}
		pos2 = new Vector[NPASOS];
		for (int i = 0; i < pos2.length; i++) {
			pos2[i] = new Vector (-i*10.0, 90 + (i*10.0));
		}

		v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		v2 = new Vehiculo("v2", pos2[0], t, pos2[1], t+10);
		
		t += 10;		
		System.out.println("------------- CRUCE EN EL PASADO -----------");
		for (int i = 1; i < NPASOS; i++) {
			t += 10;
			v1.mover(pos1[i], t);
			v2.mover(pos2[i], t);
			System.out.println(v1 + " " + v1.getVelocidad());
			System.out.println(v2 + " " + v2.getVelocidad());
			System.out.println("Impacto esperado en " + v1.impacto(v2) + " s");
			System.out.println("Es peligroso: " + v1.isPeligroso(v2));
		}
		

		// ----------------------------------------
		t = 0;
		pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i*10.0);
		}
		pos2 = new Vector[NPASOS];
		for (int i = 0; i < pos2.length; i++) {
			pos2[i] = new Vector (90 - (i*6.0), i * 7.5);
		}

		v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		v2 = new Vehiculo("v2", pos2[0], t, pos2[1], t+10);
		
		t += 10;		
		System.out.println("------------- CRUCE NO COINCIDEN -----------");
		for (int i = 1; i < NPASOS; i++) {
			t += 10;
			v1.mover(pos1[i], t);
			v2.mover(pos2[i], t);
			System.out.println(v1 + " " + v1.getVelocidad());
			System.out.println(v2 + " " + v2.getVelocidad());
			System.out.println("Impacto esperado en " + v1.impacto(v2) + " s");
			System.out.println("Es peligroso: " + v1.isPeligroso(v2));
		}

		// ----------------------------------------
		t = 0;
		pos1 = new Vector[NPASOS];
		for (int i = 0; i < pos1.length; i++) {
			pos1[i] = new Vector (i*10.0, i*10.0);
		}
		v1 = new Vehiculo("v1", pos1[0], t, pos1[1], t+10);
		
		t += 10;		
		System.out.println("------------- COMPATIBLE -----------");
		for (int i = 0; i < NPASOS -1 ; i++) {
			System.out.println(v1 + " Velocidad= " + v1.getVelocidad());
			for (int j = -10 ; j < 10; j ++)
				for (int k = -10; k < 10; k ++) {
					Vector v = new Vector(pos1[i + 1].getX() + j, pos1[i + 1].getY() + k);
					if (v1.isPosicionCompatible(v, t + 10))
						System.out.println("Es compatible con: " + v + " en t= "+ (t + 10));
					//else System.out.println("No es compatible con: " + v + " en t= " + (t+10));
				}
			t += 10;
			v1.mover(pos1[i], t);
		}
	
		
	}

}
