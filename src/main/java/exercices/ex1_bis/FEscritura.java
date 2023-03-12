package exercices.ex1_bis;


import java.io.FileWriter;
import java.io.IOException;

public class FEscritura {
    private FileWriter fw = null;

    //Metodo que abre el FileWriter y nos permite escribir sobre el fichero
    //deseado
    public void abrirEscritura(String fichero){
        try {
            fw = new FileWriter(fichero, false);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //Metodo cierra el FileWriter
    public void cerrarEscritura() {
        try {
            fw.close();
        }catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    //Metodo para escribir la frase deseada en el fichero
    public void escribir(String frase) {
        try {
            fw.write(frase);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
