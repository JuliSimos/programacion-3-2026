package Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud;

public class Posicion {
    private int fila;
    private int columna;

    public  Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    @Override
    public boolean equals(Object obj) {

        Posicion pos = (Posicion) obj;

        return pos.fila == this.fila &&
                pos.columna == this.columna;
    }
    public String toString(){
        return "[" +  this.fila + ",e" + this.columna + "]";
    }
}
