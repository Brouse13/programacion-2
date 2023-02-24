package exercices.ex1;

import java.io.*;

public class ObjectSerializer implements Closeable {
    private final BufferedWriter writer;

    public ObjectSerializer(String file) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(file));
    }

    /**
     * Write a new serialized object into the file.
     *
     * @param object object to serialize
     * @return if the object aws stored
     */
    public boolean write(Serialize object) {
     ensureOpen();

    try {
        writer.write(object.serialize());
        writer.write("\n");
    } catch (IOException e) {
        return false;
    }
    return true;
    }

    /**
     * Throw an exception if the file is closed.
     */
    public void ensureOpen() {
        if (writer == null) {
            throw new RuntimeException("Out stream closed");
        }
    }

    @Override
    public void close() throws IOException {
        ensureOpen();
        writer.close();
    }
}
