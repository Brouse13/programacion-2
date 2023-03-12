package exercices.ex2_bis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RdObject {

    FileInputStream entrada = null;
    ObjectInputStream reader = null;

    public void abrirLectura() {

        try {
            entrada = new FileInputStream("resources/ex2.bis/films.dat");
            reader = new ObjectInputStream(entrada);
        } catch (FileNotFoundException fnfEx) {
            System.err.println("ERROR: Fichero no encontrado. \n" + fnfEx.getMessage());
        } catch (IOException ioEx) {
            System.err.println("ERROR: se ha producido un error al abrir la lectura del fichero. Intentelo de nuevo. \n"
                               + ioEx.getMessage());
        }
    }

    public void cerrarLectura() {
        try{
            reader.close();
            entrada.close();
        } catch (IOException ioEx) {
            System.err.println("ERROR: se ha producido un error al cerrar la lectura del fichero. Intentelo de nuevo. \n"
                               + ioEx.getMessage());
        } finally {
            try {
                reader.close();
                entrada.close();
            } catch (IOException ioEx) {
                System.err.println("ERROR: se ha producido un error al cerrar la escritura del fichero. Intentelo de nuevo. \n"
                                   + ioEx.getMessage());
            }
        }
    }

    /**
     * Metodo que sirve para leer todos los objetos escritos en un
     */
    public void leerObjeto() {
        Film pelicula;
        try{
            pelicula = (Film)reader.readObject();
            while (pelicula != null) {
                System.out.println(pelicula);
                pelicula = (Film)reader.readObject();
            }
        }
        catch (ClassNotFoundException cnfEx) {
            System.err.println("ERROR: no se ha encontrado la clase. " + cnfEx.getMessage());
        } catch(IOException ioEx) {
            System.out.println("------- No se han encontrado mas registros -------");
        }
    }
}
