import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{

private final int id;
private final int palilloIz;
private final int palilloDe;
private final Semaphore[] palillos_usados;
private final int[][] palillos_filosofo;

    /**
     * El constructor debe contener el estado de uso de los palillos, los que le pertenecen, su identificador
     * @param id
     * @param palillos_usados
     * @param palillos_filosofo
     */
    public Filosofo(int id, Semaphore[] palillos_usados, int[][] palillos_filosofo) {
        this.id = id;
        this.palilloIz=palillos_filosofo[id][0];
        this.palilloDe=palillos_filosofo[id][1];
        this.palillos_usados = palillos_usados;
        this.palillos_filosofo=palillos_filosofo;
    }

    /**
     * Intentamos adquirir los palillos tanto izquierdo como derecho, solo en el caso de que
     * los dos palillos esten libres el filosofo comerá.
     * Tanto si palillo izq como dcho estan ocupados
     */

    public void comer(){
        if (palillos_usados[palilloIz].tryAcquire()){
            if (palillos_usados[palilloDe].tryAcquire()){
                System.out.println("Filosofo ["+id+"] comiendo.");
            }else {
                System.out.println("Palillo DCHO ocupado, el filosofo ["+id+"] no puede comer.");
            }
            try{
                sleep((int) ((Math.random()*2000)+2000)); //Duermen entre 2 y 4 segundos.
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Filosofo ["+id+"] ha terminado de comer.");
            palillos_usados[palilloDe].release();
            palillos_usados[palilloIz].release();
        } else{
            System.out.println("Palillo IZQ ocupado, el filosofo ["+id+"] no puede comer.");
        }
    }

    /**
     * Con este metodo solo enviamos a nuestro filosofo a pensar entre 2 y 4 segundos.
     */
    public void pensar(){
        System.out.println("Filosofo ["+id+"] pensando.");
        try {
            Filosofo.sleep((int) ((Math.random()*2000)+2000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        while (true){
            comer();
            pensar();
        }
    }

}
