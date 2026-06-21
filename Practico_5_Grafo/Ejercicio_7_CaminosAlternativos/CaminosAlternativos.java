package Practico_5_Grafo.Ejercicio_7_CaminosAlternativos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;
import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos Aires
a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito
 */
public class CaminosAlternativos {
    private GrafoNoDirigido<?> grafo;
    private final static int NO_VISITADO = 0;
    private final static int VISITADO = 1;
    private HashMap<Integer,Integer> visitados;
    private List<List<Integer>> rutasDisponibles;

    public CaminosAlternativos(GrafoNoDirigido grafo) {
        this.grafo = grafo;
        this.rutasDisponibles = new ArrayList<>();
        this.visitados = new HashMap<>();
    }

    public List<List<Integer>>  getRutasDisponibles(Integer origen, Integer destino) {
        //limpio las estructuras para comenzar la busquede de 0
        this.visitados.clear();
        this.rutasDisponibles.clear();
        //me fijo si los vertices/ciudades dadas existen en el grafo
        if(!this.grafo.contieneVertice(origen) ||  !this.grafo.contieneVertice(destino)){
            return null;
        }
        //Marco como no visitados a todos los vertices del grafo
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()){
            visitados.put(vertices.next(), NO_VISITADO);
        }
        List<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        visitados.put(origen, VISITADO);
        //paso al padre para no caer en una ruta hacia si el mismo vertice
        buscarRutas(origen, null, destino, caminoParcial);
        return rutasDisponibles;
    }

    public void buscarRutas(Integer actual,Integer padre, Integer destino, List<Integer> caminoParcial){
        if(actual.equals(destino)){
            this.rutasDisponibles.add(new ArrayList<>(caminoParcial));
        }else{
            Iterator<Integer> ady = this.grafo.obtenerAdyacentes(actual);
             while(ady.hasNext()){
                 Integer vecino = ady.next();
                 if(visitados.get(vecino) == NO_VISITADO){
                     //puse el codigo postal porque no se me ocurre otra forma de seleccionar rauch o las flores
                     if(vecino != padre){
                         if(!((actual.equals(7203) && vecino.equals(7200))
                                 || (actual.equals(7200) && vecino.equals(7203)))){
                             visitados.put(vecino, VISITADO);
                             caminoParcial.add(vecino);
                             buscarRutas(vecino, actual, destino, caminoParcial);
                             visitados.put(vecino,NO_VISITADO);
                             caminoParcial.remove(vecino);
                         }
                     }
                 }
             }
        }
    }

}
