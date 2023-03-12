package exercices.ex2_bis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WrtObject {

    FileOutputStream salida = null;
    ObjectOutputStream writer = null;

    public void abrirEscritura() {
        try{
            salida = new FileOutputStream("resources/ex2.bis/films.dat");
            writer = new ObjectOutputStream(salida);
        } catch(FileNotFoundException fnfEx){
            System.err.println("ERROR: no se ha encontrado el fichero. \n" + fnfEx.getMessage());
        }catch (IOException ioEx) {
            System.err.println("ERROR: se ha producido un error al abrir la escritura del fichero. Intentelo de nuevo. " +
                               "\n" + ioEx.getMessage());
        }
    }

    public void cerrarEscritura() {
        try{
            writer.close();
            salida.close();
        } catch (IOException ioEx) {
            System.err.println("ERROR: se ha producido un error al cerrar la escritura del fichero. Intentelo de nuevo. " +
                               "\n" + ioEx.getMessage());
        } finally {
            try {
                writer.close();
                salida.close();
            } catch (IOException ioEx) {
                System.err.println("ERROR: se ha producido un error al cerrar la escritura del fichero. Intentelo de " +
                                   "nuevo. \n" + ioEx.getMessage());
            }
        }
    }

    public void escribirObjeto(Film f) {
        try{
            writer.writeObject(f);
        } catch (IOException ioEx) {
            System.err.println("ERROR: se ha producido un error en la escritura. Intentelo de nuevo. \n" +
                               ioEx.getMessage());
        }
    }
}
