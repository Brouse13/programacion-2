package exercices.examen_22_23.Exc1;

import java.util.Scanner;

public class e1 {

    public static class maxSize extends Exception {
        public maxSize(String s){super(s);}
    }

    public static class emptyQueue extends Exception{
        public emptyQueue(String s){super(s);}
    }

    public static class Cua{

        private final int maxSize;
        private final int[] array;

        private int front;
        private int end;
        private int currentSize;

        public Cua(int maxSize){
            this.maxSize = maxSize;
            this.array = new int[maxSize];
            this.front = 0;
            this.end = -1;
            this.currentSize = 0;
        }

        /**
         * Encua un valor a la cua.
         * @param i valor a encuar.
         */

        public void encuar(int i){
            try{
                if (currentSize==maxSize){
                    throw new maxSize("La cua esta completa, desencua un valor abans de encuarne! No s'afegit: "+i);
                }
                end = (end+1) % maxSize;
                array[end]=i;
                currentSize++;
            }catch (maxSize e){
                e.printStackTrace();
            }

        }

        /**
         * Desencua un valor de la cua.
         */
        public void desencuar(){
            try{
                if (currentSize==0){
                    throw new emptyQueue("La cua esta buida!");
                }
                int i = array[front];
                front = (front+1)%maxSize;
                currentSize--;
                System.out.println("Has descuat el valor "+i);
            }catch (emptyQueue e){
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            try {
                if (currentSize == 0) {
                    throw new emptyQueue("No hi ha res a imprimir, la cua esta buida!");
                }

                sb.append("Contingut de l'estructura circular:\n");
                int count = 0;
                int index = front;

                while (count < currentSize) {
                    sb.append("[").append(array[index]).append("]\n");
                    index = (index + 1) % maxSize;
                    count++;
                }

            } catch (emptyQueue e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args){
        Cua c = new Cua(4);

        Scanner s = new Scanner(System.in);
        int i;
        while ((i = s.nextInt()) != -1) {

            if (i == 0) {
                System.out.println(c);
            }else if (i == 1) {
                c.desencuar();
            } else {
                c.encuar(i);
            }

        }
    }



}


