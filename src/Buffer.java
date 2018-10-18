public class Buffer<Almacen> {
    private final Almacen[] datos;
    private int datosAlmacen;
    public Buffer(int size) {
        datos = (Almacen[]) new Object[size];
        datosAlmacen = 0;
    }
    public void put(Almacen x) {
        datos[datosAlmacen++] = x;
    }
    public Almacen take() {
        Almacen x = datos[0];
        datosAlmacen--;
        System.arraycopy(datos, 1, datos, 0, datosAlmacen);
        datos[datosAlmacen] = null;
        return x;
    }
}
