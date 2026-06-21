package Practico_5_Grafo.Ejercicio_6_CaminoMasCorto;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.*;

public class CaminoMasCorto {
    private Grafo<?> grafo;
    private static final int NO_VISITADO = 0;
    private static final int VISITADO = 1;
    Queue<Integer> fila;
    HashMap<Integer, Integer> visitados;
    HashMap<Integer, Integer> padres;


    public CaminoMasCorto(Grafo<?> grafo){
        this.grafo = grafo;
        this.fila = new LinkedList<Integer>();
        this.visitados = new HashMap<>();
        this.padres = new HashMap<>();
    }

    /*
        Crear un camino con menor longitud de vertices
     */
    public ArrayList<Integer> getAtajo(Integer origen, Integer destino){
        this.visitados.clear();
        this.padres.clear();
        this.fila.clear();
        ArrayList<Integer> solucion = new ArrayList<>();
        if((!this.grafo.contieneVertice(origen)) ||  (!this.grafo.contieneVertice(destino))){
            return solucion;
        }
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            this.visitados.put(vertices.next(), NO_VISITADO);
        }
        getMejorAtajo(origen, destino);

// chequeo
        if(!padres.containsKey(destino)){
            return solucion;
        }

// reconstrucción
        Integer actual = destino;
        while(actual != null){
            solucion.add(actual);
            actual = padres.get(actual);
        }

        Collections.reverse(solucion);
        return solucion;
    }

    public void getMejorAtajo(Integer origen, Integer destino) {
        fila.add(origen);
        visitados.put(origen, VISITADO);
        padres.put(origen, null);

        while (!fila.isEmpty()) {
            Integer vertice = fila.poll();

            if (vertice.equals(destino)) break;

            Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice);
            while (ady.hasNext()) {
                Integer vecino = ady.next();
                if (visitados.get(vecino) == NO_VISITADO) {
                    visitados.put(vecino, VISITADO);
                    padres.put(vecino, vertice);
                    fila.add(vecino);
                }
            }
        }
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
