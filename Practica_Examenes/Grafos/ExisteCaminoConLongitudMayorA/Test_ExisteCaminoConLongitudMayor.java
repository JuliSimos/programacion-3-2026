package Practica_Examenes.Grafos.ExisteCaminoConLongitudMayorA;

import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

public class Test_ExisteCaminoConLongitudMayor {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1,2,10);
        grafo.agregarArco(1,3,60);

        grafo.agregarArco(2,4,20);
        grafo.agregarArco(2,3,50);

        grafo.agregarArco(3,4,40);

        grafo.agregarArco(4,1,30);

        ExisteCaminoConLongitudMayor detectorDeLongitud =  new ExisteCaminoConLongitudMayor(grafo);
        System.out.println(detectorDeLongitud.existeCamino(50,1,4));
    }

}
