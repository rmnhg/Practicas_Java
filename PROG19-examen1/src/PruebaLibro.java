
public class PruebaLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro Q = new Libro (1605, "Quijote");
		boolean QuijoteDisponible = Q.getPrestado();
		System.out.println("El Quijote esta disponible="+QuijoteDisponible);
		Libro libro1 = new Libro (2000, "Los Juegos del Hambre");
		Libro libro2 = new Libro (2010, "It");
		System.out.println("El libro1 es mas antiguo que el libro 2 y el libro 1 no esta prestado="+(libro1.getAnio() < libro2.getAnio() && libro1.getPrestado()==false));
		Libro[][] matriz = new Libro[100][150];
		Libro[] misLibros = new Libro[10];
		Libro aux = misLibros[0];
		misLibros[0]=misLibros[misLibros.length-1];
		misLibros[misLibros.length-1]=aux;
		double c = ((double) 7%4)/4.0;
		System.out.println("((double) 7%4)/4.0="+c);
		char letra = 'c';
		System.out.println("letra="+letra+" esta en mayusculas="+Character.isUpperCase(letra));
		int n=20;
		System.out.println("n="+n+" es multiplo de 2 y de 5="+(n%2==0 && n%5==0));;
	}

}
