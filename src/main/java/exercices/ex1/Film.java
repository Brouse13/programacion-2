package exercices.ex1;

public class Film implements Serialize {
    private final String name;
    private final String director;
    private final int premiereDate;

    public Film(String name, String director, int premiereDate) {
        this.name = name;
        this.director = director;
        this.premiereDate = premiereDate;
    }

    public static Film fromString(String film) {
        String[] split = film.split("#");
        if (split.length != 3) throw new RuntimeException("Unable to parse film");


        try {
            return new Film(split[0], split[1], Integer.parseInt(split[2]));
        }catch (NumberFormatException e) {
            throw new RuntimeException("Unable to parse film");
        }
    }

    @Override
    public String serialize() {
        return name + "#" + director + "#" + premiereDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", premiereDate=" + premiereDate +
                '}';
    }
}
