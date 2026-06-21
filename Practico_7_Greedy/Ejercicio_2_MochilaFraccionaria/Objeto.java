package Practico_7_Greedy.Ejercicio_2_MochilaFraccionaria;

public class Objeto implements Comparable<Objeto>{
    private int indiceOriginal;
    private double peso;
    private double valor;

    public Objeto(int indice, double valor, double peso) {
        this.indiceOriginal = indice;
        this.valor = valor;
        this.peso = peso;
    }
    public int getIndice() {
        return indiceOriginal;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor() {
        return valor;
    }
    public double getValorPorPeso() {
        return valor / peso;
    }
    @Override
    public int compareTo(Objeto o) {
        return Double.compare(o.getValorPorPeso(), this.getValorPorPeso());
    }
}
