public class Productor extends Thread{
    int id;
    Buffer bu;
    Productor(int id, Buffer bu){
        this.id=id;
        this.bu=bu;
    }

    public void run() {
        while (true) {
            try {
                if (bu.maxTamanyo == bu.lista.size()) {
                    Thread.sleep((int) ((Math.random() * 2000) + 3000));//Duermo entre 3 y 5 segundos.
                } else {
                    bu.Almacenar(id);
                    Thread.sleep((int) ((Math.random() * 2000) + 2000));//Duermo entre 2 y 4 segundos.
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
