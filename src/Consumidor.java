public class Consumidor extends Thread {

    private final Buffer<Integer> buffer;
    private int esperado = 0;
    public Consumidor(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while (true) {
            esperado++;
            descanso(Mercadillo.C_DELAY);
            int n = buffer.take();
            System.out.println("Consumidor: " + n);
            if (n != esperado)
                System.out.println(
                        "Consumidor: ERROR: esperado " + esperado);
        }
    }
    private void descanso(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
