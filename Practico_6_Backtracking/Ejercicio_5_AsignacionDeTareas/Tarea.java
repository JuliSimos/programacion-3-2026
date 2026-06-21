package Practico_6_Backtracking.Ejercicio_5_AsignacionDeTareas;

public class Tarea {
    private int id;
    private int tiempoEjecucion;

    public Tarea(int id, int tiempoEjecucion) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
    }
    public int getId() {
        return id;
    }
    public int getTiempo() {
        return tiempoEjecucion;
    }
}
