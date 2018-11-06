public class Productor extends Thread{
    int id;
    Buffer bu;
    Productor(int id,Buffer bu){
        this.id=id;
        this.bu=bu;
    }
    public void run() {
        while (true){
            bu.Almacenar(id);
        }
    }
}
