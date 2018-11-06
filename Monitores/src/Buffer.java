import java.util.ArrayList;

public class Buffer {
 int maxTamanyo;
 private boolean lleno = false;
    ArrayList<String> lista = new ArrayList<>();
    Buffer(int maxTamanyo) {
        this.maxTamanyo = maxTamanyo;
    }

    public synchronized void Almacenar(int id) {
        while (lleno) {
            try
            {
                if (maxTamanyo == this.lista.size()) {
                    System.out.println("Productor [" + id + "] esta esperando porque esta llena.");
                    wait();
                    return;
                } else {
                    System.out.println("Productor [" + id + "] esta depositando.");
                    Thread.sleep(1000);
                    lista.add("Peras");
                    System.out.println("Productor [" + id + "] ha terminado.");
                    wait();
                }
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
        }
        lleno = Boolean.TRUE;
        notifyAll();
    }
    public synchronized void Consumir(int id) {
        while (!lleno) {
            try
            {
                if (lista.isEmpty()){
                    System.out.println("Consumidor [" + id + "] esta esperando porque esta vacia.");
                    return;
                }else {
                    System.out.println("Consumidor [" + id + "] esta consumiendo.");
                    Thread.sleep(500);
                    lista.remove("Peras");
                    System.out.println("Consumidor [" + id + "] ha terminado.");
                }
            } catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
        }
        lleno = Boolean.FALSE;
        notifyAll();
    }
}
