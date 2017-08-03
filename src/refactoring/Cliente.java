package refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
	private String nombre;
	private ArrayList<Renta> rentas = new ArrayList<>();
	
	public Cliente(String nombre) {
		this.setNombre(nombre);
	}
	
	public void agregarRenta(Renta renta) {
		rentas.add(renta);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String emitirReciboRenta() {
		double montoTotal = 0;
		int puntosClienteFrecuente = 0;
		StringBuilder resultado = new StringBuilder();
		resultado.append("Rentas del Cliente: " + getNombre() + "\n");
		Iterator<Renta> listaRentas = this.rentas.iterator();
		
		while (listaRentas.hasNext()) {
			Renta pelicula = listaRentas.next();
			
			double monto = pelicula.calcularImporte();
			
			puntosClienteFrecuente += pelicula.calcularPuntosClienteFrecuente();
			
			// Muestra detalle de la renta
			resultado.append("\t" + pelicula.getPelicula().getTitulo() + "\t" + monto + "\n");
			montoTotal += monto;
		}
		
		// Agregar totales
		resultado.append("Cantidad a pagar: " + montoTotal + "\n");
		resultado.append("Has acumulado " + puntosClienteFrecuente + " puntos adicionales a tu cuenta.");
		
		return resultado.toString();
	}

	public String emitirReciboRentaHTML() {
		double montoTotal = 0;
		int puntosClienteFrecuente = 0;
		StringBuilder resultado = new StringBuilder();
		resultado.append("<h1>Rentas del Cliente: <em>" + getNombre() + "</em></h1><br>");
		Iterator<Renta> listaRentas = this.rentas.iterator();
		
		resultado.append("<table>");
		while (listaRentas.hasNext()) {
			Renta pelicula = listaRentas.next();
			
			double monto = pelicula.calcularImporte();
			
			puntosClienteFrecuente += pelicula.calcularPuntosClienteFrecuente();
			
			// Muestra detalle de la renta
			resultado.append("<tr><td>" + pelicula.getPelicula().getTitulo() + "</td><td>" + monto + "</td></tr>");
		
			montoTotal += monto;
		}
		resultado.append("</table><br>");
		
		// Agregar totales
		resultado.append("<p>Cantidad a pagar: " + montoTotal + "</p><br>");
		resultado.append("<p>Has acumulado " + puntosClienteFrecuente + " puntos adicionales a tu cuenta.</p><br>");
		
		return resultado.toString();
	}
}
