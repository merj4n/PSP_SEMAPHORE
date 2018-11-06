import java.io.*;

public class Buffer {
    static final String RUTA="C:/Users/merjan/Desktop/Prueba.txt";
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    private boolean ocupado = false;

    public synchronized void Almacenar(int id) {
        while (!ocupado) {
            ocupado = true;
            FileWriter fichero = null;
            try {
                fichero = new FileWriter(RUTA, true);
                BufferedWriter escribe = new BufferedWriter(fichero);
                escribe.write("Productor ["+id+"]");
                escribe.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ocupado = false;
        notifyAll();
    }
    public synchronized void Consumir(int id) {
        while (!ocupado) {
            ocupado = true;
            archivo = new File(RUTA);
            try {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null) {
                    System.out.println(linea);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ocupado = false;
        notifyAll();
    }
}