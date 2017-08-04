package refactoring;

public abstract class PrecioPelicula {
	abstract int getTipoPelicula();

	abstract double getPrecioRenta(int diasRentada);
	
	public int calcularPuntosClienteFrecuente(int diasRentada) {
		return 1;
	}
}
