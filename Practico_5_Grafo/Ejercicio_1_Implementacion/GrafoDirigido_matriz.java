package Practico_5_Grafo.Ejercicio_1_Implementacion;

import java.util.Iterator;

public class GrafoDirigido_matriz<T> implements Grafo<T> {
    private T[][] grafoDirigido;
    private int[] mapeoV;
    private int index = 0;


    @Override
    public void agregarVertice(int verticeId) {
        mapeoV[index] = verticeId;
        index++;
    }

    @Override
    public void borrarVertice(int verticeId) {

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return false;
    }

    @Override                      //fila           columna
    public boolean existeArco(int verticeId1, int verticeId2) {
        //Requiere mayor complejidad computacional, requiere mas calculos
        int indexVId1;// = Busca en el mapeo el verticeId1
        int indexVId2;// = Busca en el mapeo el verticeId2
        return grafoDirigido[verticeId1][verticeId2] != null;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        return null;
    }

    @Override
    public int cantidadVertices() {
        return 0;
    }

    @Override
    public int cantidadArcos() {
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }
}
