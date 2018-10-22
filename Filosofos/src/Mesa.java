/**
 * Los filosofos: Resolución del uso de palillos regulado por semaforos.
 * Autor: Germán Belda Molina
 * Version: 2
 */

import java.util.concurrent.Semaphore;

public class Mesa {
    final static int numFilosofos=5;
    final static int[][] palillos_filosofo =
            {{1,0},{2,1},{3,2},{4,3},{0,4}}; //Relacion de palillos para cada filosofo
    final static Semaphore[] palillos_control = new Semaphore[numFilosofos];

    public static void main(String[] args){

        for (int i=0; i<numFilosofos;i++){
            palillos_control[i] = new Semaphore(1);//No debo permitir que coman y piensen a la vez.
        }
        for (int id=0;id<numFilosofos;id++){
           Filosofo hilo = new Filosofo(id,palillos_control,palillos_filosofo);
           hilo.start(); //Creo e inicio un nuevo filosofo con los palillos que le corresponden
        }
    }
}
