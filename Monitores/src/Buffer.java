import java.io.*;

public class Buffer {
    static final String RUTA="C:/Users/merjan/Desktop/Prueba.txt";

    private boolean ocupado_writer = false;
    private boolean ocupado_reader = false;

    public synchronized void Almacenar(int id) {
        while (!ocupado_writer && !ocupado_reader) {
            ocupado_writer = true;
            try {
                BufferedWriter escribe = new BufferedWriter(new FileWriter(RUTA,true));
                escribe.write("Productor ["+id+"]");
                escribe.newLine();
                escribe.close();
                Thread.sleep(500);
                wait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ocupado_writer = false;
        notifyAll();
    }
    public synchronized void Consumir(int id) {
        while (!ocupado_writer) {
            ocupado_reader = true;
            try {
                BufferedReader br = new BufferedReader(new FileReader(RUTA));
                String linea;
                while((linea=br.readLine())!=null) {
                    System.out.println("Consumidor ["+id+"]"+" lee: "+linea);
                }
                Thread.sleep(500);
                br.close();
                wait();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ocupado_reader = false;
        notifyAll();
    }
}