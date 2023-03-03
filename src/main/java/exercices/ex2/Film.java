package exercices.ex2;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {
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

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", premiereDate=" + premiereDate +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
