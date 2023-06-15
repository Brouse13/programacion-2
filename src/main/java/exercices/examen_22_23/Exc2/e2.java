package exercices.examen_22_23.Exc2;

import exercices.examen_22_23.Exc2.AuxiliarTest.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class e2 {

    public static class playerNotFound extends Exception{
        public playerNotFound(String s){
            super(s);
        }
    }

    public static class Jugador{

        private static final String pathtoDataFile = "src/Examen/Exc2/AuxiliarTest/cosa.dat";

        private static final int NAME_SIZE = 30;
        private static final int TEAM_SIZE = 30;


        private String name,team;
        private int score;

        public Jugador(String name, String team, int score){
            this.name = name;
            this.team = team;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getTeam() {
            return team;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Jugador{" +
                    "name='" + name + '\'' +
                    ", team='" + team + '\'' +
                    ", score=" + score +
                    '}';
        }

        public static void updateScore(String name, int newScore, String pathToFile){
            boolean changed = false;
            try{
                RandomAccessFile raf = new RandomAccessFile(pathToFile,"rw");
                while (raf.getFilePointer() < raf.length()){
                    String readName = readString(raf,NAME_SIZE);
                    if (readName.equals(name)){
                        raf.skipBytes(Character.BYTES*TEAM_SIZE);
                        raf.writeInt(newScore); // Corrected this line
                        changed = true;
                    } else {
                        raf.skipBytes(Character.BYTES * TEAM_SIZE + Integer.BYTES);
                    }
                }
                raf.close();
                if (!changed){
                    throw new playerNotFound("No se ha encontrado ningun jugador con ese nombre en el archivo!");
                }
            }catch (playerNotFound | IOException e){
                e.printStackTrace();
            }
        }

        private static String readString(RandomAccessFile raf,int size) throws IOException {
            char[] chars = new char[size];
            for (int i = 0; i < size; i++) {
                chars[i]=raf.readChar();
            }

            return new String(chars).replace('\0',' ').trim();
        }


        public static void main(String[] args) throws IOException {

            test();

        }

        public static void test() throws IOException {
            PlayerFileWriter w = new PlayerFileWriter(pathtoDataFile);
            w.writePlayer(new Jugador("Jorge","Los Macarras",34));
            w.writePlayer(new Jugador("Dylan","Los Flacos",20));
            w.writePlayer(new Jugador("Biel","Los Tres Rangers",26));
            w.writePlayer(new Jugador("Joan","Triple Tres",2));
            w.writePlayer(new Jugador("ZZZ","YYY",999));
            PlayerFileReader r = new PlayerFileReader(pathtoDataFile);
            List<Jugador> allPlayers = r.readAllPlayers();
            for (Jugador jugador : allPlayers) {
                System.out.println(jugador);
            }
            updateScore("Dylan", 200,pathtoDataFile);
            updateScore("Joan", 30,pathtoDataFile);
            updateScore("Biel",50,pathtoDataFile);
            allPlayers = r.readAllPlayers();
            for (Jugador jugador : allPlayers) {
                System.out.println(jugador);
            }
        }



    }


}
