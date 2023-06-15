package exercices.examen_22_23.Exc2.AuxiliarTest;

import exercices.examen_22_23.Exc2.e2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class PlayerFileReader {
    private static final int NAME_SIZE = 30;
    private static final int TEAM_SIZE = 30;

    private String filePath;

    public PlayerFileReader(String filePath) {
        this.filePath = filePath;
    }

    public e2.Jugador readPlayer(String playerName) throws IOException {
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(this.filePath, "r");

            while (file.getFilePointer() < file.length()) {
                String name = readString(file, NAME_SIZE);
                if (name.equals(playerName)) {
                    String team = readString(file, TEAM_SIZE);
                    int score = file.readInt();
                    return new e2.Jugador(name, team, score);
                }
                file.skipBytes(Character.BYTES * TEAM_SIZE + Integer.BYTES);
            }

            throw new IllegalArgumentException("Player not found in the file.");
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    public List<e2.Jugador> readAllPlayers() throws IOException {
        RandomAccessFile file = null;
        List<e2.Jugador> jugadores = new ArrayList<>();

        try {
            file = new RandomAccessFile(this.filePath, "r");

            while (file.getFilePointer() < file.length()) {
                String name = readString(file, NAME_SIZE);
                String team = readString(file, TEAM_SIZE);
                int score = file.readInt();
                jugadores.add(new e2.Jugador(name, team, score));
            }

        } finally {
            if (file != null) {
                file.close();
            }
        }

        return jugadores;
    }

    private static String readString(RandomAccessFile file, int size) throws IOException {
        char[] chars = new char[size];

        for (int i = 0; i < size; i++) {
            chars[i] = file.readChar();
        }

        return new String(chars).replace('\0', ' ').trim();
    }
}
