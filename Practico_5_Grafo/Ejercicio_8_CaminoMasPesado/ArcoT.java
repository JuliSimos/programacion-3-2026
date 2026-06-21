package Practico_5_Grafo.Ejercicio_8_CaminoMasPesado;


public class ArcoT<Integer> {

    private Tarea tareaAnterior;
    private Tarea tareaSiguiente;
    private int demora;

    public ArcoT(Tarea verticeOrigen, Tarea verticeDestino, int demora) {
        this.tareaAnterior = verticeOrigen;
        this.tareaSiguiente = verticeDestino;
        this.demora = demora;
    }

    public Tarea getTareaAnterior() {
        return tareaAnterior;
    }

    public Tarea getTareaSiguiente() {
        return tareaSiguiente;
    }

    public int getDemora() {
        return demora;
    }
    @Override
    public String toString() {
        return "["+ this.tareaAnterior + " , " + this.tareaSiguiente + " , " + this.demora + " ]";
    }

}