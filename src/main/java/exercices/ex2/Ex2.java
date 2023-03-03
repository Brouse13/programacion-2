package exercices.ex2;

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
public class Ex2 {

    public static void main(String[] args) {
        new Ex2().start();
    }

    private void start() {
        Film[] films = new Film[] {
                new Film("Avatar", "James Cameron", 2009, Genre.SIFI),
                new Film("Avatar2", "James Cameron", 2023, Genre.SIFI),
                new Film("Star Wars: Episodio IV", "Georges Lucas", 1997, Genre.SIFI)
        };

        try(FilmWriter writer = new FilmWriter("resources/ex2/films.dat")) {
            Arrays.stream(films).forEach(writer::write);
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }

        try(FilmReader reader = new FilmReader("resources/ex2/films.dat")) {
            while (reader.hasNext()) {
                System.out.println(reader.getObject());
            }
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }
    }
}
