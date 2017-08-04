package refactoring;

public class PrecioPeliculaInfantil extends PrecioPelicula {
	int getTipoPelicula() {
		return Pelicula.INFANTIL;
	}

	public double getPrecioRenta(int diasRentada) {
		double monto = 1.5;

		if (diasRentada > 3) {
			monto += (diasRentada - 3) * 1.5;
		}
		
		return monto;
	}
}
