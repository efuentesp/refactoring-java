package refactoring;

public class PrecioPeliculaEstreno extends PrecioPelicula {
	int getTipoPelicula() {
		return Pelicula.ESTRENO;
	}
	
	public double getPrecioRenta(int diasRentada) {
		return diasRentada * 3d;
	}
	
	@Override
	public int calcularPuntosClienteFrecuente(int diasRentada) {
		return (diasRentada > 1) ? 2 : 1;
	}
}
