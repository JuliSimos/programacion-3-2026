package Practico_5_Grafo.Ejercicio_5_ExisteCamino;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.*;

/*
Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
con todos los vértices a partir de los cuales exista un camino en G que termine en v.

 */
public class CaminosPosibles{
    private Grafo<?> grafo;
    private List<Integer> solucion;

    public CaminosPosibles(Grafo<?> grafo){
        this.grafo = grafo;
    }

    public List<Integer> getCaminosPosibles(Integer destino){
        //Limpio la lista que guarda la solucion y me fijo que el destino exista en el grafo
        this.solucion.clear();
        if(!grafo.contieneVertice(destino)) return solucion;

        //Recorro todos los vertices del grafo
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            //Para cada vertice, genero una lista vacia
            Integer actual = vertices.next();
            Set<Integer> visitados = new HashSet<>();
            //Utilizo un metodo auxiliar para saber si existe un camino de Actual a destino
            if(existeCamino(actual, destino, visitados)){
                //si existe, lo agrego a la solucion
                solucion.add(actual);
            }
        }
        return solucion;
    }
    public boolean existeCamino(Integer origen, Integer destino, Set<Integer> visitados){
        if(origen.equals(destino)) return true;

        visitados.add(origen);

        Iterator<Integer> ady = grafo.obtenerAdyacentes(origen);
        while(ady.hasNext()){
            Integer vecino = ady.next();
            if(!visitados.contains(vecino)){
                if(existeCamino(vecino, destino, visitados))
                    return true;
            }
        }
        return false;
    }
}
