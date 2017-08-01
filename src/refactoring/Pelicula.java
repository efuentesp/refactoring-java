package refactoring;

public class Pelicula {
	public static final int CATALOGO = 0;
	public static final int ESTRENO = 1;
	public static final int INFANTIL = 2;
	
	private String titulo;
	private int tipo;
	
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
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
