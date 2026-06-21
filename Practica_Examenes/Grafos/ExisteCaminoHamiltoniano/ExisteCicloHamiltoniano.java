package Practica_Examenes.Grafos.ExisteCaminoHamiltoniano;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.*;

public class ExisteCicloHamiltoniano {
    private static final int NO_VISITADO = 0;
    private static final int VISITADO = 1;
    private GrafoDirigido<Integer> grafo;
    private List<Integer> recorrido;
    private List<Integer> verticesGrafo;
    private HashMap<Integer,Integer> visitados;

    public ExisteCicloHamiltoniano(GrafoDirigido g) {
        this.grafo = g;
        this.recorrido = new ArrayList<>();
        this.verticesGrafo = new ArrayList<>();
        this.visitados = new HashMap<>();
    }

    public List<Integer> existeCiclo(){
        this.recorrido.clear();
        this.visitados.clear();
        this.verticesGrafo.clear();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v = vertices.next();
            this.verticesGrafo.add(v);
            visitados.put(v,NO_VISITADO);
        }

        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v =  vertices.next();
            if(visitados.get(v) == NO_VISITADO){
                List<Integer> caminoParcial = new ArrayList<>();
                caminoParcial.add(v);
                visitados.put(v, VISITADO);

                encontrarCiclo(v, caminoParcial);
                visitados.put(v, NO_VISITADO);
            }
        }
        return this.recorrido;
    }

    public void encontrarCiclo(Integer actual,List<Integer> caminoParcial) {
        if(caminoParcial.size() == verticesGrafo.size()){
                if(grafo.existeArco(actual, caminoParcial.get(0))){
                    caminoParcial.add(caminoParcial.get(0));
                    recorrido.clear();
                    recorrido = new ArrayList<>(caminoParcial);
                    return;
                }

        }
        Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
        while(ady.hasNext()){
            Integer v = ady.next();
            if(visitados.get(v) == NO_VISITADO){
                caminoParcial.add(v);
                visitados.put(v,VISITADO);

                encontrarCiclo(v,caminoParcial);

                caminoParcial.remove(caminoParcial.size()-1);
                visitados.put(v,NO_VISITADO);
            }
        }
    }
}
