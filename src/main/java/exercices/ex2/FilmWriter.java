package exercices.ex2;

import java.io.*;

public class FilmWriter implements Closeable {
    private final ObjectOutputStream out;

    public FilmWriter(String file) throws IOException {
        this.out = new ObjectOutputStream(new FileOutputStream(file));
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
    public void close() throws IOException {
        ensureOpen();
        out.close();
    }
}
