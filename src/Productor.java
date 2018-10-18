public class Productor extends Thread{

    private final Buffer<Integer> buffer;
    private int cont = 0;
    public Productor(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while (true) {
            cont++;
            System.out.println("Productor: " + cont);
            buffer.put(cont);
            descanso(Mercadillo.P_DELAY);
        }
    }
    private void descanso(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}