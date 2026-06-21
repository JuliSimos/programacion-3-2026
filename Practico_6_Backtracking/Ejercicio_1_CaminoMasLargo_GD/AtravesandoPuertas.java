package Practico_6_Backtracking.Ejercicio_1_CaminoMasLargo_GD;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtravesandoPuertas {
    GrafoDirigido<?> grafo;
    private List<Integer> mejorSolucion;

    public AtravesandoPuertas(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Integer> getCaminoMasLargo(){
        this.mejorSolucion.clear();
        Iterator<Integer> salas = grafo.obtenerVertices();
        while( salas.hasNext() ){
            List<Integer> caminoParcial = new ArrayList<>();
            Integer sala = salas.next(); caminoParcial.add(sala);
            System.out.println("Entro a la sala: " + sala);
            buscarCaminoYComparar(sala, caminoParcial); }
        return this.mejorSolucion;
    }

    private void buscarCaminoYComparar(Integer actual, List<Integer> caminoParcial){
        Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
        if(!ady.hasNext()){
            System.out.println("Camino encontrado");
            if((caminoParcial.size()) > (this.mejorSolucion.size())){
                this.mejorSolucion.clear();
                this.mejorSolucion.addAll(caminoParcial);
            }
        }else{
            while(ady.hasNext()){
                Integer vecino = ady.next();
                if(!caminoParcial.contains(vecino)){
                    caminoParcial.add(vecino);
                    buscarCaminoYComparar(vecino, caminoParcial);
                    caminoParcial.remove(caminoParcial.size()-1);
                }
            }
        }
    }
}
