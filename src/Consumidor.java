public class Consumidor extends Thread {

    Buffer bu;
    int id;
    Consumidor(int id, Buffer bu){
    this.id=id;
    this.bu=bu;
    }

    public void run(){
        while (true) {
            try {
                if (bu.lista.isEmpty()) {
                    Thread.sleep((int) ((Math.random() * 2000) + 3000));//Duermo entre 3 y 5 segundos.
                } else {
                    bu.Consumir(id);
                    Thread.sleep((int) ((Math.random() * 2000) + 2000));//Duermo entre 2 y 4 segundos.
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
