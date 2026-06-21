package Practica_Examenes.Grafos.ExisteCaminoHamiltoniano;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

public class Test_ExisteCicloHamiltoniano {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1,2,10);
        grafo.agregarArco(1,3,10);

        grafo.agregarArco(2,4,10);
        grafo.agregarArco(2,3,10);

        grafo.agregarArco(3,4,10);
        grafo.agregarArco(3,2,10);


        grafo.agregarArco(4,1,10);

        ExisteCicloHamiltoniano ch = new ExisteCicloHamiltoniano(grafo);
        System.out.println(ch.existeCiclo());
    }
}
