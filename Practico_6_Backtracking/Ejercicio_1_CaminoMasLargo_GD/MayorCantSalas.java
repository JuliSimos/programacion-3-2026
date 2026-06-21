package Practico_6_Backtracking.Ejercicio_1_CaminoMasLargo_GD;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MayorCantSalas {
    private GrafoDirigido<?> salas;
    private List<Integer> solucion;

    public MayorCantSalas(GrafoDirigido<?> g) {
        this.salas = g;
        this.solucion = new ArrayList<>();
    }

    public List<Integer> caminoMasLargo(Integer origen, Integer destino){
        this.solucion.clear();
        List<Integer> caminoParcial = new ArrayList<>();
        if(!this.salas.contieneVertice(origen) ||  !this.salas.contieneVertice(destino))
            return caminoParcial;
        caminoParcial.add(origen);
        buscarCaminoMasLargo(origen, destino, caminoParcial);

        return this.solucion;
    }
    private void buscarCaminoMasLargo(Integer actual, Integer destino, List<Integer> caminoParcial) {
        if(actual.equals(destino)){
            if(caminoParcial.size() > this.solucion.size()){
                this.solucion.clear();
                this.solucion.addAll(new ArrayList<>(caminoParcial));
            }
        }else{
            Iterator<Integer> ady = this.salas.obtenerAdyacentes(actual);
            while (ady.hasNext()){
                Integer vecino = ady.next();
                if(!caminoParcial.contains(vecino)){
                    caminoParcial.add(vecino);
                    buscarCaminoMasLargo(vecino, destino,caminoParcial);

                    caminoParcial.remove(caminoParcial.size()-1);
                }

            }
        }
    }
}
