package refactoring;

public class Pelicula {
	public static final int CATALOGO = 0;
	public static final int ESTRENO = 1;
	public static final int INFANTIL = 2;
	
	private String titulo;
	private PrecioPelicula precio;

	public Pelicula(String titulo, int tipo) {
		setTitulo(titulo);
		setTipo(tipo);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTipo() {
		return precio.getTipoPelicula();
	}

	public void setTipo(int tipo) {
		switch (tipo) {
			case CATALOGO:
				this.precio = new PrecioPeliculaCatalogo();
				break;
			case ESTRENO:
				this.precio = new PrecioPeliculaEstreno();
				break;
			case INFANTIL:
				this.precio = new PrecioPeliculaInfantil();
				break;
			default:
				throw new IllegalArgumentException("Tipo de Película Incorrecto.");
		}
	}
	
	public double calcularImporte(int diasRentada) {
		return precio.getPrecioRenta(diasRentada);
	}
	
	public int calcularPuntosClienteFrecuente(int diasRentada) {
		int puntosClienteFrecuente = 1;
		
		// Agregar bono por renta de dos días en películas de estreno
		if ((getTipo() == Pelicula.ESTRENO) && diasRentada > 1) {
			puntosClienteFrecuente++;
		}
		
		return puntosClienteFrecuente;
	}
}
