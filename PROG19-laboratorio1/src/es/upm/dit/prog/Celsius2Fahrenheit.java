/**
 * 
 */
package es.upm.dit.prog;

import java.util.Scanner;

/**
 * @author Ramón Hernández García
 *
 */
public class Celsius2Fahrenheit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner op = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		double c;
		double f;
		while (exit != true) {
			System.out.println("Conversor de temperatura:");
			System.out.println("1. Grados Celsius a Farenheit.");
			System.out.println("2. Grados Farenheit a Celsius.");
			System.out.println("3. Salir del programa.");
			System.out.println("Introduce una opción:");
			int opcion = op.nextInt();
			switch (opcion) {
				case 1:
					System.out.println("Escriba el valor en Celsius: ");
					c = sc.nextDouble();
					f = ((c * 9) / 5) + 32;
					System.out.println(c + " ºC en Farenheit son " + f + " ºF.\n");
					break;
				case 2:
					System.out.println("Escriba el valor en Farenheit: ");
					f = sc.nextDouble();
					c = ((f - 32) / 9) * 5;
					System.out.println(f + " ºF en Celsius son " + c + " ºC.\n");
					break;
				case 3:
					exit = true;
					System.out.println("Saliendo...\nGracias por usar mi programa.");
					break;
				default:
					System.out.println("La opción "+opcion+" no es válida.");
			}
		}
		// Termino los scanners
		sc.close();
		op.close();
	}

}
