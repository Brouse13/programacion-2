package exercices.ex3;

import java.io.*;

public class FilmWriter implements Closeable {
    private final ObjectOutputStream out;
    private final String fileName;

    public FilmWriter(String fileName) throws IOException {
        this.fileName = fileName;
        this.out = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    /**
     * Write a new serialized object into the file.
     *
     * @param object object to serialize
     * @return if the object aws stored
     */
    public boolean write(Object object) {
     ensureOpen();

    try {
        out.writeObject(object);
    } catch (IOException e) {
        return false;
    }
    return true;
    }

    /**
     * Throw an exception if the file is closed.
     */
    public void ensureOpen() {
        if (out == null) {
            throw new RuntimeException("Out stream closed");
        }
    }

    @Override
    public void close() {
        ensureOpen();
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Unable to close file" + fileName);
        }
    }
}
