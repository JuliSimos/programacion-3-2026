package Practico_5_Grafo.Ejercicio_1_Implementacion;


public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
    @Override
    public String toString() {
        return "["+ this.verticeOrigen + " , " + this.verticeDestino + " , " + this.etiqueta + " ]";
    }

}