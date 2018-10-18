import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buffer {

    int maxTamanyo;
    public Semaphore estado = new Semaphore(1);

    ArrayList<String> lista = new ArrayList<>();

    Buffer(int maxTamanyo) {
        this.maxTamanyo = maxTamanyo;
    }

    public synchronized void Almacenar (int id){ //SIN ESTA PUTA MIERDA NADA VALE EN LA VIDA
        try {
            if (maxTamanyo == this.lista.size()) {
                System.out.println("Productor [" + id + "] esta esperando porque esta llena.");
                return;
            } else {
                estado.acquire();
                System.out.println("Productor [" + id + "] esta depositando.");
                Thread.sleep(1000);
                lista.add("Peras");
                System.out.println("Productor [" + id + "] ha terminado.");
                estado.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void Consumir (int id){ // GG WELL PLAYED MIGUEL!!!
        try {
            if (lista.isEmpty()){
                System.out.println("Consumidor [" + id + "] esta esperando porque esta vacia.");
                return;
            }else {
                estado.acquire();
                System.out.println("Consumidor [" + id + "] esta consumiendo.");
                Thread.sleep(500);
                lista.remove("Peras");
                System.out.println("Consumidor [" + id + "] ha terminado.");
                estado.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

