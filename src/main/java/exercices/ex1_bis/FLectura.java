package exercices.ex1_bis;

import java.io.FileReader;
import java.io.IOException;

public class FLectura {
    private FileReader fr = null;
    private int c;

    //Metodo que abre el FileReader para que pueda leer del fichero deseado
    public void abrirLectura(String fichero) {
        try {
            fr = new FileReader(fichero);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //Metodo que cierra el FileReader
    public void cerrarLectura() {
        try {
            fr.close();
        } catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try{
                fr.close();
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    //Metodo que lee el contenido del fichero, lo guarda en un String y 
    //posteriormente, lo imprime. De esta manera, el usuario puede visualizar el
    //contenido del fichero
    public void leer() {
        String lectura = "";
        try {
            c = fr.read();
            //Bucle que lee el fichero hasta que llega al final
            while (c != -1) {
                lectura = lectura + ((char)c);
                c = fr.read();
            }
            System.out.println(lectura);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
