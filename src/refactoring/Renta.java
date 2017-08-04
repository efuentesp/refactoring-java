package refactoring;

public class Renta {
	private Pelicula pelicula;
	private int diasRentada;
	
	public Renta(Pelicula pelicula, int diasRentada ) {
		setPelicula(pelicula);
		setDiasRentada(diasRentada);
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getDiasRentada() {
		return diasRentada;
	}

	public void setDiasRentada(int diasRentada) {
		this.diasRentada = diasRentada;
	}
	
	public double calcularImporte() {
		return getPelicula().calcularImporte(getDiasRentada());
	}
	
	public int calcularPuntosClienteFrecuente() {
		return getPelicula().calcularPuntosClienteFrecuente(getDiasRentada());
	}
}
