package Practico_5_Grafo.EJ_2_Recorridos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class DFS_Simple {
    private Grafo grafo;
    private static final int BLANCO = 0;
    private static final int AMARILLO = 1;
    private static final int NEGRO= 2;
    private ArrayList<Integer> recorrido_dfs;

    public DFS_Simple(Grafo grafo) {
        this.grafo = grafo;
        recorrido_dfs = new ArrayList<>();
    }

    public ArrayList<Integer> dfs(){
        this.recorrido_dfs = new ArrayList<>();
        HashMap<Integer,Integer> color = new HashMap<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            color.put(vertices.next(),BLANCO);
        }
        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v =  vertices.next();
            if(color.get(v) == BLANCO)
                DFS_VISIT(v,color);
        }
        Collections.reverse(recorrido_dfs);
        return this.recorrido_dfs;
    }
    private void DFS_VISIT(Integer v, HashMap<Integer,Integer> color){
        color.put(v,AMARILLO);
        this.recorrido_dfs.add(v);

        Iterator<Integer> ady = this.grafo.obtenerAdyacentes(v);

        while(ady.hasNext()){
            Integer vAdy = ady.next();
            Integer colorAdy = color.get(vAdy);
            if(colorAdy == BLANCO)  DFS_VISIT(vAdy,color);
            if(colorAdy == AMARILLO)  System.out.println("Existe un arco back");
        }
        color.put(v, NEGRO);
    }
}
