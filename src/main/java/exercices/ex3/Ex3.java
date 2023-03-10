package exercices.ex3;

import java.io.*;
import java.util.Arrays;

/* ********************************************************************************************************************
 * Author:        Unai
 * Creation date: 15/02/2023
 * Last update:   15/02/2023
 * Description:   Una pel·lícula es caracteritza per un títol, el nom del director i l'any d'estrena. Escriviu un
                  programa que sigui capaç d'emmagatzemar tres registres d'aquest tipus dins un fitxer i després
                  recuperar aquesta informació del fitxer per mostrar-la per la finestra de text.
                  Plantegeu la solució emprant les classes FileWriter i FileReader.
 ******************************************************************************************************************* */
public class Ex3 {

    public static void main(String[] args) {
        new Ex3().start();
    }

    private void start() {
        //Init all available writers
        FilmWriter[] writers = new FilmWriter[Genre.values().length];

        for (int i = 0; i < writers.length; i++) {
            try {
                writers[i] = new FilmWriter("resources/ex3/" + Genre.values()[i] + ".dat");
            } catch (IOException e) {
                System.out.println("Unable to init writer " + Genre.values()[i] + ".dat");
            }
        }

        //Init all the films
        Film[] films = new Film[] {
                new Film("Avatar", "James Cameron", 2009, Genre.SIFI),
                new Film("Avatar2", "James Cameron", 2023, Genre.SIFI),
                new Film("Star Wars: Episodio IV", "Georges Lucas", 1997, Genre.SIFI)};


        //Write all the initial content plus the sentinel
        try(FilmWriter writer = new FilmWriter("resources/ex3/films.dat")) {
            Arrays.stream(films).forEach(writer::write);
            writer.write(Film.SENTINEL);
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }

        //READ ALL THE AVAILABLE FILMS AND THEN WRITE IT DEPENDING ON ITS GENRES
        try(FilmReader reader = new FilmReader("resources/ex3/films.dat")) {
            while (reader.hasNext()) {
                Film film = (Film) reader.getObject();
                writeFilmWithGenres(writers, film);
                System.out.println("Wrote film:" + film);
            }
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }finally {
            //CLOSE ALL THE PREVIOUS OPENED WRITERS
            for (int i = 0; i < writers.length; i++) {
                writers[i].write(Film.SENTINEL);
                writers[i].close();
            }
        }
    }

    /**
     * Write the film in all the files that matches the genre.
     *
     * @param writers set of all the writers ordered by {@link Genre}
     * @param film file to write
     */
    private void writeFilmWithGenres(final FilmWriter[] writers, final Film film) {
        for (int i = 0; i < film.getGenres().length; i++) {
            writers[findValue(film.getGenres()[i])].write(film);
        }
    }

    /**
     * Find the index value of the given {@param genre} on the class
     * {@link Genre}.
     *
     * @param genre genre to find index
     * @return the current genre index, otherwise -1
     */
    private int findValue(final Genre genre) {
        int index = 0;
        for (int i = 0; i < Genre.values().length; i++) {
            if (Genre.values()[i].equals(genre)) return index;
            index++;
        }
        return -1;
    }
}
