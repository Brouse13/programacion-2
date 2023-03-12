package exercices.ex2_bis;

import java.io.Serializable;

public class Film implements Serializable {

    private String title;
    private String director;
    private int date;
    private String filmGenre;


    /**
     * Metodo constructor de la clase Film. Recibe como parametro el titulo, el director, año de estreno y el genero
     * de la pelicula.
     * @param title
     * @param director
     * @param date
     * @param fg
     */
    public Film(String title, String director, int date, FilmGenre fg) {
        this.title = title;
        this.director = director;
        this.date = date;
        this.filmGenre = fg.name();
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getDate() {
        return date;
    }

    /**
     * Metodo Override toString de la clase Film
     * @return
     */
    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", date=" + date +
                ", filmGenre='" + filmGenre + '\'' +
                '}';
    }
}
