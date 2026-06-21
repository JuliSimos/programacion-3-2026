package Practico_7_Greedy.Ejercicio_4_Dijsktra;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Arco;
import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.*;

public class Dijsktra {
    private static final int VISITADO = 1;
    private static final int NO_VISITADO = 0;
    private Grafo<Integer> grafo;
    private HashMap<Integer, Integer> visitados;
    private HashMap<Integer, Integer> distancias;
    private HashMap<Integer, Integer> padres;
    private HashMap<Integer, Integer> distanciasActuales;
    private List<Integer> caminoMasCorto;

}

