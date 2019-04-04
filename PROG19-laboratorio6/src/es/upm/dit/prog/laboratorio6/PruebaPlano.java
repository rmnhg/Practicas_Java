package es.upm.dit.prog.laboratorio6;

import javax.swing.SwingUtilities;

public class PruebaPlano {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Plano p = new Plano("PROG 2019", 20, 15);
				p.creaCiudad(1);

				p.escribe("Ciudad original");
				//new PlanoGrafico(p, "Ciudad original");
				p.estadisticas();

				try {
					// TODO: ANADIR AQUI LAS LLAMADAS A LOS METODOS A PROBAR

					System.out.println("*************** Dentro (3,4) = " + p.dentro(3, 4));
					System.out.println("*************** Dentro (33,4) = " + p.dentro(33, 4));
					p.limitaAltura(15);
					p.construyeEdificio(2, 0, 20);
					p.destruyeEdificio(0, 1);
					p.creaCarretera(0, 0, 19, 14);

					p.creaCarretera(0, 14, 19, 0);
					p.creaCarretera(10, 14, 10, 0);
					p.creaCarretera(12, 14, 12, 0);
				} catch (Exception exc) {
					System.err.println("Se ha producido un error: " + exc.getMessage());
					System.exit(1);
				}

				p.escribe("Ciudad remodelada");
				//new PlanoGrafico(p, "Ciudad remodelada");
				p.estadisticas();
			}
		});

	}
}
