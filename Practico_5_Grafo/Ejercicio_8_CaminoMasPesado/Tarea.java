package Practico_5_Grafo.Ejercicio_8_CaminoMasPesado;

public class Tarea {
    private int id;
    private String descripcion;
    private int duracion; //en hs

    public Tarea(int id, String descripcion, int duracion) {
        this.id = id;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String toString(){
        return Integer.toString(this.id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea t = (Tarea) o;
        return this.id == t.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
