public class Mercadillo{

    public static final int P_DELAY = 1000;
    public static final int C_DELAY = 500;

    public static void main(String[] args) {
        Buffer<Integer> buffer = new Buffer<>(3);
        Productor P1 = new Productor(buffer);
        Consumidor C1 = new Consumidor(buffer);
        P1.start();
        C1.start();
    }
}
