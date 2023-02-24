package exercices.ex1;

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
public class Ex1 {

    public static void main(String[] args) {
        new Ex1().start();
    }

    private void start() {
        Film[] films = new Film[] {
                new Film("Avatar", "James Cameron", 2009),
                new Film("Avatar2", "James Cameron", 2023),
                new Film("Star Wars: Episodio IV", "Georges Lucas", 1997)
        };

        try(ObjectSerializer serializer = new ObjectSerializer("resources/ex1/films.txt")) {
            Arrays.stream(films).forEach(serializer::write);
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }

        try(ObjectDeSerializer deSerializer = new ObjectDeSerializer("resources/ex1/films.txt")) {
            while (deSerializer.hasNext()) {
                System.out.println(Film.fromString(deSerializer.getLine()));
            }
        }catch (IOException e) {
            System.out.println("Unable to open file resource");
        }
    }
}
