package exercices.examen_22_23.Exc4;

import java.util.Arrays;

public class e4 {
    public static void main(String[] args){
        Paraula[] paraules = new Paraula[10];
        String[] pal = {"Coche","Casa","Burro","Zapato","Melodia","Tiburon","Jorge","Vinagre","Garcia","Macarron"};

        for (int i = 0; i < paraules.length; i++) {
            paraules[i]=new Paraula(pal[i]);
        }

        RegistreFrequencies[] rf = new RegistreFrequencies[10];
        for (int i = 0; i < 10; i++) {
            rf[i] = new RegistreFrequencies(paraules[i]);
        }

        // Bubble Sort
        for (int i = 0; i < rf.length - 1; i++) {
            for (int j = 0; j < rf.length - 1 - i; j++) {
                if (rf[j].getParaula().isHigherAlphabetically(rf[j + 1].getParaula())) {
                    RegistreFrequencies temp = rf[j];
                    rf[j] = rf[j + 1];
                    rf[j + 1] = temp;
                }
            }
        }



        for (RegistreFrequencies rfs : rf) {
            System.out.println(rfs);
        }
    }


    public static class Paraula{

        private char[] lletres;
        private int longitud;
        private final int MAX = 20;

        public Paraula(){
            lletres = new char[MAX];
            longitud = 0;
        }

        public Paraula (String paraula){
            lletres = paraula.toCharArray();
            longitud=paraula.length();
        }

        public void add(char c){
            if(longitud==MAX){
                char[] aux = new char[lletres.length+1];
                for (int i = 0; i < lletres.length; i++) {
                    aux[i]=lletres[i];
                }
                lletres=aux;
            }
            lletres[longitud++]=c;
        }

        public boolean isNull(){
            return longitud==0;
        }

        public int length(){
            return longitud;
        }

        public boolean isHigherAlphabetically(Paraula p) {
            int minLength = Math.min(this.longitud, p.longitud);

            for (int i = 0; i < minLength; i++) {
                if (this.lletres[i] < p.lletres[i]) {
                    return false;
                } else if (this.lletres[i] > p.lletres[i]) {
                    return true;
                }
            }

            return this.longitud > p.longitud;
        }


        @Override
        public String toString() {
            return Arrays.toString(lletres);
        }
    }

    public static class RegistreFrequencies{
        private final Paraula p;
        private int freq;

        public RegistreFrequencies(Paraula p){
            this.p = p;
            this.freq = 0;
        }

        public Paraula getParaula(){
            return p;
        }

        @Override
        public String toString() {
            return "RegistreFrequencies{" +
                    "p=" + p +
                    ", freq=" + freq +
                    '}';
        }
    }



}
