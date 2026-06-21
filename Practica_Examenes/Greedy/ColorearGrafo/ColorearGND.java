package Practica_Examenes.Greedy.ColorearGrafo;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ColorearGND {
    private GrafoNoDirigido<Integer> grafo;
    private HashMap<Integer, Integer> verticesColoreados;

    public ColorearGND(GrafoNoDirigido<Integer> grafo){
        this.grafo = grafo;
        this.verticesColoreados = new HashMap<>();
    }

    public HashMap<Integer, Integer> colorear(){
        this.verticesColoreados.clear();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            ArrayList<Integer> colorVecinos = new ArrayList<>();
            Iterator<Integer> adyacentes =  grafo.obtenerAdyacentes(v);
            while (adyacentes.hasNext()) {
                Integer ady = adyacentes.next();
                if(verticesColoreados.containsKey(ady)){
                    colorVecinos.add(verticesColoreados.get(ady));
                }
            }
            for(int color = 1; color <= grafo.cantidadVertices(); color++){
                if(!colorVecinos.contains(color)){
                    verticesColoreados.put(v, color);
                    break;
                }
            }
        }
        return verticesColoreados;
    }


}
