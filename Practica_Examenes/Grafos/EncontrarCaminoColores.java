package Practica_Examenes.Grafos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.*;

public class EncontrarCaminoColores {
    private GrafoDirigido<Integer> grafo;
    private List<Integer> solucion;
    private HashMap<Integer,Integer> verticesColoreados;
    //private List<Integer> visitados;

    public EncontrarCaminoColores(GrafoDirigido<Integer> g, HashMap<Integer,Integer> verticesColoreados){
        this.grafo = g;
        this.solucion = new ArrayList<>();
        this.verticesColoreados = verticesColoreados;
        //this.visitados = new ArrayList<>();

    }
    public List<Integer> getCamino(Integer v, Integer w){
        this.solucion.clear();
        //this.visitados.clear();

        if(!grafo.contieneVertice(v) || !grafo.contieneVertice(w)) return new ArrayList<>();

        List<Integer> camino = new ArrayList<>();
        camino.add(v);
        //visitados.add(v);
        encontrarCamino(v,w,camino);
        return solucion;
    }
    private boolean encontrarCamino(Integer actual, Integer w, List<Integer> camino){
        if(actual.equals(w)){
            solucion.clear();
            solucion.addAll(new ArrayList<>(camino));
            return true;
        }
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while(adyacentes.hasNext()){
            Integer ady =  adyacentes.next();
            Integer colorAdy = verticesColoreados.get(ady);
            Integer colorActual =  verticesColoreados.get(actual);
            //if(!visitados.contains(ady)){
                if(!colorActual.equals(colorAdy)){
                    //visitados.add(ady);
                    camino.add(ady);

                    if(encontrarCamino(ady,w,camino)){
                        return true;
                    }
                    //visitados.remove(visitados.size()-1);
                    camino.remove(camino.size()-1);
                }
            }
       //}
        return false;
    }

}
