package Practico_5_Grafo.Ejercicio_6_CaminoMasCorto;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;
import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

public class Test_CaminoMasCorto {
    public static void main(String[] args) {
        Grafo<?> grafito = new GrafoDirigido<>();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(7);

        grafito.agregarArco(1, 2, null);
        grafito.agregarArco(1, 3, null);
        grafito.agregarArco(1, 6, null);
        grafito.agregarArco(2, 4, null);
        grafito.agregarArco(6, 7,null);
        grafito.agregarArco(7, 5, null);
        grafito.agregarArco(3, 5, null);

        CaminoMasCorto atajo = new CaminoMasCorto(grafito);
        System.out.println("Camino Mas corto: "+ atajo.getAtajo(1,5));
    }
}
