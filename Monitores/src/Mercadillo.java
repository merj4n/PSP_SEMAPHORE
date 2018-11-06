public class Mercadillo {
    public static void main(String[] args) {
        Buffer bu= new Buffer();
        for(int i=0;i<10;i++) {
            Productor p = new Productor(i,bu);
            Consumidor c = new Consumidor(i,bu);
            p.start();
            c.start();
        }
    }
}
