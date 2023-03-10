package exercices.ex3;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {
    public static Film SENTINEL = new Film("UNKNOWN", "UNKNOWN", -1);
    private final String name;
    private final String director;
    private final int premiereDate;

    private final Genre[] genres;

    public Film(String name, String director, int premiereDate, Genre... genres) {
        this.name = name;
        this.director = director;
        this.premiereDate = premiereDate;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getPremiereDate() {
        return premiereDate;
    }

    public Genre[] getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", premiereDate=" + premiereDate +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Film film)) return false;

        return film.director.equals(director) &&
                film.name.equals(name) &&
                film.premiereDate == premiereDate &&
                Arrays.equals(genres, film.genres);
    }
}
