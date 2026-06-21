package Practico_5_Grafo.Ejercicio_4_CaminoMasLargo;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.*;

public class Enfoque_1_RecorridoSimple {
    private Grafo<?> grafo;
    private Set<Integer> visitados;


    public Enfoque_1_RecorridoSimple(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<Integer>();
    }
//Primer enfoque: construyo el camino cuando retrocedo, no cuando avanzo
    //Es un DFS modificado
    //si solo me hace falta saber si no hay un ciclo, es poner un visitado o no visitado
    public List<Integer> caminoMasLargo(Integer origen, Integer destino){
        List<Integer> caminoMasLargo = new ArrayList();
        visitados.add(origen);
        //cual seria el caso de corte: cuando llegue a destino
        if(origen.equals(destino)){
            caminoMasLargo.add(destino);
        }else {
            Iterator<Integer> ady = grafo.obtenerAdyacentes(origen);
            while(ady.hasNext()){
                Integer vecino = ady.next();
                if(!visitados.contains(vecino)){
                    //busco el camino mas largo desde ese adyacente/vecino
                    List<Integer> caminoAdy = caminoMasLargo(vecino, destino);
                    //una vez con la respuesta, puedo ver si vino algo o no
                    //si se encontro el destino o no
                    //le sumamos uno al camino incluyendo al origen que se agrega a lo ultimo
                    if(caminoAdy.size() +1 > caminoMasLargo.size()){
                        //si el camino que me devolvio mi adyacente, tiene un tamaño mayor o igual al mejor camino que tenia guardado
                        //Entonces remplazamos el camino
                        caminoMasLargo.clear(); //el camino viejo ya no me sirve
                        caminoMasLargo.add(origen);
                        caminoMasLargo.addAll(caminoAdy);
                    }
                }
            }
        }
        //para poder volver a considerar el vertice que no se uso, lo removemos de la lista
        visitados.remove(origen);
        return caminoMasLargo;
    }
}
