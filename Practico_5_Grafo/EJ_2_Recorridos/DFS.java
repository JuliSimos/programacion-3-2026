package Practico_5_Grafo.EJ_2_Recorridos;


import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS<T, G extends Grafo<T>>{
    private G grafo;
    private static final int BLANCO = 0; //no visitado
    private static final int AMARILLO = 1; //visitado en el recorrido
    private static final int NEGRO = 2; //visitado completamente
    private final HashMap<Integer, Integer> TDESCUBRIMIENTO;
    private final HashMap<Integer, Integer> DISTANCIAS;
    private ArrayList<Integer> recorrido_dfs;
    int tiempo;

    public DFS(G g) {
        this.grafo = g;
        this.DISTANCIAS = new HashMap<Integer, Integer>();
        this.TDESCUBRIMIENTO = new HashMap<Integer, Integer>();
    }


    public ArrayList<Integer> DFS() {
        // Inicializo los mapas para la nueva ejecución de DFS.
        this.TDESCUBRIMIENTO.clear();
        this.DISTANCIAS.clear();
        this.recorrido_dfs = new ArrayList<>();
        //inicializo todo en blanco = 0
        HashMap<Integer, Integer> color = new HashMap<>();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()) {
            color.put(vertices.next(), BLANCO);
        }
        this.tiempo = 0;
        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()) {
            Integer v = vertices.next();
            if(color.get(v) == BLANCO) {
                //llamo al otro metodo
                DFS_Visit(v,color);
            }
        }
        return this.recorrido_dfs;
    }
    public void DFS_Visit(Integer vertice, HashMap<Integer,Integer> color) {
        color.put(vertice, AMARILLO);
        this.tiempo++;
        this.TDESCUBRIMIENTO.put(vertice, tiempo);
        this.recorrido_dfs.add(vertice);

        Iterator<Integer> verticesAdyacentes = this.grafo.obtenerAdyacentes(vertice);

        if(verticesAdyacentes != null) {
            while(verticesAdyacentes.hasNext()) {
                Integer vecino = verticesAdyacentes.next();
                Integer colorVecino = color.get(vecino);
                if(colorVecino == BLANCO) {
                    DFS_Visit(vecino, color);
                }if(colorVecino == AMARILLO)
                    System.out.println("Existe un arco back");
            }}
        color.put(vertice, NEGRO);
        this.tiempo++;
        DISTANCIAS.put(vertice, tiempo);
    }

}
