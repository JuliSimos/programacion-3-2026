package Practico_5_Grafo.EJ_2_Recorridos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS<T, G extends Grafo<T>> {
    private G grafo;
    private static final int NO_VISITADO = 0;
    private static final int VISITADO = 1;
    Queue<Integer> fila;
    private ArrayList<Integer> recorrido_bfs;

    public BFS(G grafo) {
        this.grafo = grafo;
        this.fila = new LinkedList<>();
    }
    /*
     * BFS(Grafo G){
     * 	vaciar la fila F
     * Para cada vertice v de G
     * 	marcar v como no_visitado
     *
     * para cada vertice de G
     * 	Si v es no_visitado
     * 	bfs_visit(G,v)
     * }*/
    public ArrayList<Integer> BFS() {
        HashMap<Integer, Integer> color = new HashMap<>();
        this.recorrido_bfs = new ArrayList<>();
        this.fila.clear();
        Iterator<Integer> vertices = this.grafo.obtenerVertices();

        while(vertices.hasNext()) {
            color.put(vertices.next(),NO_VISITADO);
        }

        vertices = this.grafo.obtenerVertices();
        while(vertices.hasNext()) {
            Integer v = vertices.next();
            if(color.get(v) == NO_VISITADO)
                BFS_VISIT(v,color);
        }
        return recorrido_bfs;

    }
    public void BFS_VISIT(Integer vertice, HashMap<Integer,Integer> color){
        color.put(vertice, VISITADO);
        fila.add(vertice);

        while(!fila.isEmpty()) {
            Integer v = fila.poll();
            this.recorrido_bfs.add(v);

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v);
            while(adyacentes.hasNext()) {
                Integer u = adyacentes.next();
                if(color.get(u) == NO_VISITADO) {
                    color.put(u, VISITADO);
                    this.fila.add(u);
                }
            }
        }
    }
    /*
     *
     * BFS_visit(G, v){
     * 	marcar el vertice v como visitado
     * 	agregar s a la fila F
     * 	mientras la fila F no este vacia
     * 		tomamos vertice x de la fila
     * 		para cada vertice y adyacente a x
     * 		sI Y es no visitado
     * 			marcar el vertice y como visitado
     * 			agregar y a la fila f
     * }
     */
}
