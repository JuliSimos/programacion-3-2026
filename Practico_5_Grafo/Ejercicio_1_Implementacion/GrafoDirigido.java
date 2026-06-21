package Practico_5_Grafo.Ejercicio_1_Implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
    // ¿Esta bien usar Integer como clave?
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;


    public GrafoDirigido() {
        vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        /*
            Me fijo si ya existe?
            o directamente lo agrego y piso el valor si esta repetido
            Me resulta extraño que sea tan simple el metodo
            Como utilizo HashMap, agregar un elemento a la estructura tiene un costo promedio de O(1)
            lo agrego si no existe
         */
        vertices.computeIfAbsent(verticeId,k -> new ArrayList<Arco<T>>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) return;            //recorrer todas las listas de arcos y eliminar si es el destino
            for(List<Arco<T>> list: vertices.values()){
                Iterator<Arco<T>> iterator = list.iterator();
                while(iterator.hasNext()){
                    Arco<T> arco = iterator.next();
                    if(arco.getVerticeDestino() == verticeId){
                        iterator.remove();
                    }
                }
            }
            vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) return;
        if (existeArco(verticeId1, verticeId2)) return;

        vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
            /*
            List<T> ady = vertices.get(v1);
            Iterator<Arco<T>> it = ady.iterator();
             */
            Iterator<Arco<T>> iterator = obtenerArcos(verticeId1);
            while (iterator.hasNext()) {
                Arco<T> arco = iterator.next();
                if (arco.getVerticeDestino() == verticeId2) {
                    iterator.remove();
                    break; // solo puede haber un arco, una vez que lo encontrás → terminás
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        //lo simplifico, o recorro los adyacentes de vertice1
        return obtenerArco(verticeId1, verticeId2) != null;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> ady = obtenerArcos(verticeId1);
        while (ady.hasNext()) {
            Arco<T> arco = ady.next();
            if(arco.getVerticeDestino() == verticeId2) {
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {

        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int suma = 0;
        for(List<Arco<T>> lista : vertices.values()){
            suma += lista.size();
        }
        return suma;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // de esta forma expongo directamente la estructura interna, mejor es hacer una copia e iterar sobre ella
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        Iterator<Arco<T>> iter = obtenerArcos(verticeId);
        while (iter.hasNext()) {
            adyacentes.add(iter.next().getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for(List<Arco<T>> lista : vertices.values()){
            arcos.addAll(lista);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            return vertices.get(verticeId).iterator();
        }
        return new ArrayList<Arco<T>>().iterator();//retorno un iterador vacio si no existe el vertice
    }
    public int getGradoSalida(Integer v){
        //cuantos arcos salen de el
        return this.vertices.get(v).size();
    }
    public int getGradoEntrada(Integer v){
        int grado = 0;
        for(List<Arco<T>> list : this.vertices.values()){
            for(Arco<T> arco : list){
                Integer destino  = arco.getVerticeDestino();
                if(destino.equals(v)){
                    grado++;
                }
            }
        }
        return grado;
    }
    public int getGradoVertice(Integer v){
        return this.getGradoEntrada(v) + this.getGradoSalida(v);
    }
}
