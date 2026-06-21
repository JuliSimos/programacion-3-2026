package Practica_Examenes.Grafos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoNoDirigido;

import java.sql.Array;
import java.util.*;

public class ExtraerComponentesConectados {
    private GrafoNoDirigido<Integer> grafo;
    private List<List<Integer>> solucion;
    private Set<Integer> visitados;

    public ExtraerComponentesConectados(GrafoNoDirigido<Integer> grafo){
        this.grafo = grafo;
        solucion = new ArrayList<>();
        visitados = new HashSet<>();
    }
    public List<List<Integer>> getConexiones(){
        this.solucion.clear();
        this.visitados.clear();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v =  vertices.next();
            if(!visitados.contains(v)){
                List<Integer> componente = new ArrayList<>();
                encontrarConexiones(v, componente);
                this.solucion.add(componente);

            }
        }
        return solucion;
    }
    private void encontrarConexiones(Integer v, List<Integer> caminoParcial){
        this.visitados.add(v);
        caminoParcial.add(v);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
        while(adyacentes.hasNext()){
            Integer ady =  adyacentes.next();
            if(!visitados.contains(ady)){
                encontrarConexiones(ady, caminoParcial);
            }
        }
    }
}
