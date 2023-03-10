package exercices.ex3;

import java.io.*;

public class FilmReader implements Closeable {
    private final ObjectInputStream in;
    private Object lastObject;
    private final String fileName;

    public FilmReader(String fileName) throws IOException {
        this.fileName = fileName;
        this.in = new ObjectInputStream(new FileInputStream(fileName));
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
            if (lastObject.equals(Film.SENTINEL)) return false;
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
    public void close() {
        ensureOpen();
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Unable to close file" + fileName);
        }
    }
}
