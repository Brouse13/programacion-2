package exercices.ex2_bis;

import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

    private Scanner in;
    private String title;
    private String director;
    private int date;
    private String fg = "";
    private FilmGenre filmGenre;

    /**
     *
     */
    private void start() {
        in = new Scanner(System.in);
        WrtObject writer = new WrtObject();
        RdObject reader = new RdObject();
        Film [] films = new Film[3];

        writer.abrirEscritura();
        for (int i = 0; i < films.length; i++) {
            System.out.println("-------------  Registro " + (i+1) + "  -------------");
            askTitle();
            askDirector();
            askPremireDate();
            v_askGenre();
            films[i] = new Film(title, director, date, filmGenre);
            writer.escribirObjeto(films[i]);
        }
        writer.cerrarEscritura();
        System.out.println("\n");
        reader.abrirLectura();
        reader.leerObjeto();
        reader.cerrarLectura();
    }

    /**
     * Pide al usuario por teclado el titulo deseado de una pelicula
     */
    private void askTitle() {
        System.out.print("Introduce el titulo de la pelicula: ");
        title = validateString();
    }

    /**
     * Pide al usuario por teclado el director deseado de una pelicula
     */
    private void askDirector() {
        boolean matchIs = false;
        System.out.print("Introduce el nombre del director: ");
        director = validateString();
    }

    /**
     * Pide al usuario por teclado el año de estreno de la pelicula deseada
     */
    private void askPremireDate() {
        System.out.print("Introduce el año de estreno de la película: ");
        date = in.nextInt();
        in.nextLine();
    }

    private String validateString(){
        boolean validate = false;
        String tmp = "";
        while(!validate) {
            tmp = in.nextLine();
            if(!tmp.equals("")) {
                validate = true;
            }else {
                System.err.print("ERROR: valor invalido. Intentelo de nuevo: ");
            }
        }
        return tmp;
    }

    /**
     * Pide al usuario por teclado el genero deseado de una pelicula. Si no coincide con los generos disponibles, se
     * producira una excepcion. Este metodo tambien valida que la entrada del usuario coincida con con uno de los generos
     */
    private void v_askGenre() {
        boolean validate = false;
        while(!validate){
            try{
                System.out.print("Introduce el genero de la pelicula (ACCION/ AUTOR/ CIFI/ COMEDIA/ DRAMA/ POLICIACA/ TERROR): ");
                fg = in.nextLine();
                filmGenre = FilmGenre.valueOf(fg.toUpperCase());
                validate = true;
            } catch (IllegalArgumentException iaEx){
                System.err.print("ERROR: El genero no coincide. Intentalo de nuevo: ");
            }
        }
    }

    /**Metodo main del programa. Manda el hilo de ejecucion al metodo start()
     * @param args
     */
    public static void main(String[] args){
        new Ex2().start();
    }
}
