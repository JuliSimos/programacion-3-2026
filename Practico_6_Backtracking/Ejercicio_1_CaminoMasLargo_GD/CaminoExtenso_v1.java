package Practico_6_Backtracking.Ejercicio_1_CaminoMasLargo_GD;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaminoExtenso_v1 {
    GrafoDirigido<?> grafo;
    List<Integer> mejorSolucion;

    public CaminoExtenso_v1(GrafoDirigido<?> grafo){
        this.grafo = grafo;
        this.mejorSolucion = new ArrayList<>();
    }
    public List<Integer> getCaminoMasExtenso(Integer entrada, Integer salida) {
        this.mejorSolucion.clear();
        List<Integer> caminoParcial = new ArrayList<>();
        if(!grafo.contieneVertice(entrada) || !grafo.contieneVertice(salida)) {
            return caminoParcial;
        }
        caminoParcial.add(entrada);
        buscarCaminoExtenso(entrada, salida, caminoParcial);
        return this.mejorSolucion;
    }
    private void buscarCaminoExtenso(Integer actual, Integer salida, List<Integer> caminoParcial) {
        if(actual.equals(salida)) {
            if(caminoParcial.size() > this.mejorSolucion.size()) {
                mejorSolucion.clear();
                this.mejorSolucion.addAll(caminoParcial);
            }
        }else{
            Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
            while(ady.hasNext()) {
                Integer vecino = ady.next();
                if(!caminoParcial.contains(vecino)) {
                    caminoParcial.add(vecino);
                    buscarCaminoExtenso(vecino, salida, caminoParcial);
                    caminoParcial.remove(caminoParcial.size()-1);
                }
            }
        }
    }
}