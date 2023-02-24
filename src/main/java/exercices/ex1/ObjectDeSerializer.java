package exercices.ex1;

import java.io.*;

public class ObjectDeSerializer implements Closeable {
    private final BufferedReader reader;
    private String lastLine;

    public ObjectDeSerializer(String file) throws IOException {
        this.reader = new BufferedReader(new FileReader(file));
    }

    /**
     * Move the pointer to the next index and store the
     * pointer.
     * This pointer can be retrieved by using {@link #getLine()}.
     *
     * @return if there's a line to read
     */
    public boolean hasNext() {
        ensureOpen();

        try {
            lastLine = reader.readLine();
        } catch (IOException e) {
            return false;
        }

        return lastLine != null;
    }

    /**
     * Get the next line to read.
     *
     * @return the next line read
     */
    public String getLine() {
        return lastLine;
    }

    /**
     * Throw an exception if the file is closed.
     */
    public void ensureOpen() {
        if (reader == null) {
            throw new RuntimeException("Out stream closed");
        }
    }

    @Override
    public void close() throws IOException {
        ensureOpen();
        reader.close();
    }
}
