package exercices.ex1;

public interface Serialize {
    /**
     * Serialize the object into a String to be
     * able to use it in {@link ObjectSerializer}.
     *
     * @return the serialized string
     */
    String serialize();
}
