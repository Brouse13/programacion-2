package exercices.ex1.bis;

public class Pelicula {
    private String titulo, director;
    private int fecha;

    //Para instanciar un objeto de la clase Pelicula, hay que ponerle un titulo,
    //el nombre del director de la película y el año en el que se estreno.
    public Pelicula(String titulo, String director, int fecha){
        this.titulo = titulo;
        this.director = director;
        this.fecha = fecha;
    }

// Metodos GETTER de la clase Pelicula
    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getFecha() {
        return fecha;
    }
}
