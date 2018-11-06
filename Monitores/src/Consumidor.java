public class Consumidor extends Thread{
    int id;
    Buffer bu;
    Consumidor(int id, Buffer bu){
        this.id=id;
        this.bu=bu;
    }

    public void run(){
        while (true){
            bu.Consumir(id);
        }
    }
}
