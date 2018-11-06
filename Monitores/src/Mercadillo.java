import java.util.ArrayList;
import java.util.List;

public class Mercadillo {
    public static void main(String[] args) {
        Buffer bu = new Buffer(3);
        List<Productor> lispr = new ArrayList<>();
        List<Consumidor> liscr = new ArrayList<>();
        for(int i=0;i<3;i++) {
            lispr.add( new Productor(i, bu));
            liscr.add(new Consumidor(i, bu));
        }
        for (Productor p:lispr) {
            p.start();
        }
        for (Consumidor c:liscr) {
            c.start();
        }
    }
}
