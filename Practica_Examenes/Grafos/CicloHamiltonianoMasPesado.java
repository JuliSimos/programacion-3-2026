package Practica_Examenes.Grafos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Arco;
import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CicloHamiltonianoMasPesado {
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, Integer> visitados;
    private static final int NO_VISITADO = 0;
    private static final int VISITADO = 1;
    private List<Integer> solucion;
    private int mejorPeso;
    private int cantVertices;

    public CicloHamiltonianoMasPesado(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
        this.solucion = new ArrayList<>();
    }
    public List<Integer> getCiclo(){
        this.visitados.clear();
        this.solucion.clear();
        this.cantVertices = 0;
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            cantVertices++;
            visitados.put(vertices.next(),NO_VISITADO);
        }
        this.mejorPeso = Integer.MIN_VALUE;
        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v =  vertices.next();
            if (visitados.get(v) == NO_VISITADO) {
                List<Integer> camino = new ArrayList<>();
                camino.add(v);
                visitados.put(v,VISITADO);
                buscarCiclo(v, camino, 0);
                visitados.put(v,NO_VISITADO);
            }
        }
        return solucion;
    }
    private void buscarCiclo(Integer v, List<Integer> camino, int suma){
        if(camino.size() == this.cantVertices){
            Integer origen = camino.get(0);
            if(grafo.existeArco(v, origen)){
                Arco<Integer> arco = grafo.obtenerArco(v, origen);
                suma += arco.getEtiqueta();
                if(suma > mejorPeso){
                    solucion.clear();
                    solucion.addAll(new ArrayList<>(camino));
                    solucion.add(origen);
                    mejorPeso = suma;
                }
            }
            return;
        }
        Iterator<Integer> vecinos = grafo.obtenerAdyacentes(v);
        while(vecinos.hasNext()){
            Integer ady = vecinos.next();
            if (visitados.get(ady) == NO_VISITADO) {
                camino.add(ady);
                visitados.put(ady, VISITADO);
                Arco<Integer> arco = grafo.obtenerArco(v, ady);
                suma += arco.getEtiqueta();

                buscarCiclo(ady, camino, suma);

                camino.remove(camino.size()-1);
                visitados.put(ady, NO_VISITADO);
                suma -= arco.getEtiqueta();
            }
        }
    }
}
