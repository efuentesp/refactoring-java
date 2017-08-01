package refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTests {

	@Test
	public void emitirReciboRentaSinRentasPrevias() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		String reciboEsperado = "Rentas del Cliente: Juan Perez\nCantidad a pagar: 0.0\nHas acumulado 0 puntos adicionales a tu cuenta.";
		
		// act
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Sin recibo de rentas", reciboEsperado, reciboResultado);
	}
	
	@Test
	public void emitirReciboRentaPeliculaCatalogoDosDias() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		Pelicula salvandoSoldadoRyan = new Pelicula("Salvando al Soldado Ryan", Pelicula.CATALOGO);
		String reciboEsperado = "Rentas del Cliente: Juan Perez\n\tSalvando al Soldado Ryan\t2.0\nCantidad a pagar: 2.0\nHas acumulado 1 puntos adicionales a tu cuenta.";
		
		// act
		cliente.agregarRenta(new Renta(salvandoSoldadoRyan, 2));
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Con una renta", reciboEsperado, reciboResultado);
	}

	@Test
	public void emitirReciboRentaPeliculaCatalogoMasDosDias() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		Pelicula salvandoSoldadoRyan = new Pelicula("Salvando al Soldado Ryan", Pelicula.CATALOGO);
		String reciboEsperado = "Rentas del Cliente: Juan Perez\n\tSalvando al Soldado Ryan\t5.0\nCantidad a pagar: 5.0\nHas acumulado 1 puntos adicionales a tu cuenta.";
		
		// act
		cliente.agregarRenta(new Renta(salvandoSoldadoRyan, 4));
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Con una renta", reciboEsperado, reciboResultado);
	}
	
	@Test
	public void emitirReciboRentaPeliculaEstreno() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		Pelicula salvandoSoldadoRyan = new Pelicula("Salvando al Soldado Ryan", Pelicula.ESTRENO);
		String reciboEsperado = "Rentas del Cliente: Juan Perez\n\tSalvando al Soldado Ryan\t3.0\nCantidad a pagar: 3.0\nHas acumulado 1 puntos adicionales a tu cuenta.";
		
		// act
		cliente.agregarRenta(new Renta(salvandoSoldadoRyan, 1));
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Con una renta", reciboEsperado, reciboResultado);
	}
	
	@Test
	public void emitirReciboRentaPeliculaInfantil() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		Pelicula toyStory = new Pelicula("Toy Story", Pelicula.INFANTIL);
		String reciboEsperado = "Rentas del Cliente: Juan Perez\n\tToy Story\t1.5\nCantidad a pagar: 1.5\nHas acumulado 1 puntos adicionales a tu cuenta.";
		
		// act
		cliente.agregarRenta(new Renta(toyStory, 1));
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Con una renta", reciboEsperado, reciboResultado);
	}
	
	@Test
	public void emitirReciboRentaPeliculasVarias() {
		// arrange
		Cliente cliente = new Cliente("Juan Perez");
		Pelicula salvandoSoldadoRyan = new Pelicula("Salvando al Soldado Ryan", Pelicula.CATALOGO);
		Pelicula kong = new Pelicula("Kong", Pelicula.ESTRENO);
		Pelicula toyStory = new Pelicula("Toy Story", Pelicula.INFANTIL);
		String reciboEsperado = "Rentas del Cliente: Juan Perez\n\tSalvando al Soldado Ryan\t2.0\n\tKong\t3.0\n" + 
				"\tToy Story\t1.5\nCantidad a pagar: 6.5\nHas acumulado 3 puntos adicionales a tu cuenta.";
		
		// act
		cliente.agregarRenta(new Renta(salvandoSoldadoRyan, 1));
		cliente.agregarRenta(new Renta(kong, 1));
		cliente.agregarRenta(new Renta(toyStory, 1));
		String reciboResultado = cliente.emitirReciboRenta();
		
		// assert
		assertEquals("Con una renta", reciboEsperado, reciboResultado);
	}
}
