package exercices.ex2;

import java.io.*;

public class FilmReader implements Closeable {
    private final ObjectInputStream in;
    private Object lastObject;

    public FilmReader(String file) throws IOException {
        this.in = new ObjectInputStream(new FileInputStream(file));
    }

    /**
     * Move the pointer to the next index and store the
     * pointer.
     * This pointer can be retrieved by using {@link #getObject()}.
     *
     * @return if there's a line to read
     */
    public boolean hasNext() {
        ensureOpen();

        try {
            lastObject = in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            return false;
        }

        return lastObject != null;
    }

    /**
     * Get the next object to read.
     *
     * @return the next line read
     */
    public Object getObject() {
        return lastObject;
    }

    /**
     * Throw an exception if the file is closed.
     */
    public void ensureOpen() {
        if (in == null) {
            throw new RuntimeException("Out stream closed");
        }
    }

    @Override
    public void close() throws IOException {
        ensureOpen();
        in.close();
    }
}
