package refactoring;

public class PrecioPeliculaCatalogo extends PrecioPelicula {
	int getTipoPelicula() {
		return Pelicula.CATALOGO;
	}
	
	public double getPrecioRenta(int diasRentada) {
		double monto = 2;

		if (diasRentada > 2) {
			monto += (diasRentada - 2) * 1.5;
		}
		
		return monto;
	}
}
