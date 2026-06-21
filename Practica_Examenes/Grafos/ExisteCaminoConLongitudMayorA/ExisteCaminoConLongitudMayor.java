package Practica_Examenes.Grafos.ExisteCaminoConLongitudMayorA;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Arco;
import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExisteCaminoConLongitudMayor {
    private GrafoDirigido<Integer> grafo;
    private List<Integer> visitados;

    private int D;

    public ExisteCaminoConLongitudMayor(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
    }
    public boolean existeCamino(int D, Integer origen, Integer destino){
        this.visitados.clear();
        this.D = D;
        visitados.add(origen);
        int longitudActual = 0;
        return existeCaminoRecu(origen, destino, longitudActual);
    }
    public boolean existeCaminoRecu(Integer actual, Integer destino, int longitudActual){
        if(actual.equals(destino) && longitudActual > D){
            return true;
        }
        Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
        while (ady.hasNext()) {
            Integer v = ady.next();
            if(!visitados.contains(v)){
                visitados.add(v);
                Arco<Integer> arco = grafo.obtenerArco(actual,v);
                longitudActual += arco.getEtiqueta();

                if(existeCaminoRecu(v, destino, longitudActual)){
                    return true;
                }
                longitudActual -= arco.getEtiqueta();
                visitados.remove(visitados.size()-1);

            }
        }
        return false;
    }



}
