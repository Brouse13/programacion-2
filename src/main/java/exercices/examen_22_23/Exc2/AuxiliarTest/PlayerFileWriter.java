package exercices.examen_22_23.Exc2.AuxiliarTest;

import exercices.examen_22_23.Exc2.e2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PlayerFileWriter {
    private static final int NAME_SIZE = 30;
    private static final int TEAM_SIZE = 30;

    private String filePath;

    public PlayerFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writePlayer(e2.Jugador player) throws IOException {
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(this.filePath, "rw");

            file.seek(file.length()); // go to the end of the file

            writeString(file, player.getName(), NAME_SIZE);
            writeString(file, player.getTeam(), TEAM_SIZE);
            file.writeInt(player.getScore());

        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    private static void writeString(RandomAccessFile file, String str, int size) throws IOException {
        StringBuffer buffer = null;
        if (str != null) {
            buffer = new StringBuffer(str);
        } else {
            buffer = new StringBuffer(size);
        }

        buffer.setLength(size);
        file.writeChars(buffer.toString());
    }
}

