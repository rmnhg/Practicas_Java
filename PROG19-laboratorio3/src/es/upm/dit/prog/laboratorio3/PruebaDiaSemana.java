package es.upm.dit.prog.laboratorio3; 

import java.util.Scanner; 

public class PruebaDiaSemana {
    
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el año = ");
        int anno = sc.nextInt();
        System.out.print("Introduzca el mes (1-12) = ");
        int mes = sc.nextInt();
        System.out.print ("Introduzca el día del mes = ");
        int dia = sc.nextInt();
        DiaSemana ds = new DiaSemana();
        System.out.println ("El día de la semana es: " +
                ds.getDiaSemana(anno, mes, dia));
        sc.close();
    }
}
