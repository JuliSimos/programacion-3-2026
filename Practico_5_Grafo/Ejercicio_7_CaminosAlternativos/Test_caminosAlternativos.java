package Practico_5_Grafo.Ejercicio_7_CaminosAlternativos;


import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoNoDirigido;

import java.util.List;

public class Test_caminosAlternativos {
    public static void main(String[] args) {

        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();

        // Agregar vertices (ciudades)
        grafo.agregarVertice(1000); // Buenos Aires
        grafo.agregarVertice(7000); // Tandil
        grafo.agregarVertice(7200); // Las Flores
        grafo.agregarVertice(7203); // Rauch
        grafo.agregarVertice(7300); // Azul
        grafo.agregarVertice(7100); // Dolores
        grafo.agregarVertice(7600); // Mar del Plata

        // Agregar rutas (aristas no dirigidas)
        grafo.agregarArco(1000, 7200, null); // BA → Las Flores
        grafo.agregarArco(7200, 7203, null); // Las Flores → Rauch (PROHIBIDA)
        grafo.agregarArco(7203, 7000, null); // Rauch → Tandil

        grafo.agregarArco(1000, 7100, null); // BA → Dolores
        grafo.agregarArco(7100, 7300, null); // Dolores → Azul
        grafo.agregarArco(7300, 7000, null); // Azul → Tandil

        grafo.agregarArco(1000, 7600, null); // BA → Mar del Plata
        grafo.agregarArco(7600, 7000, null); // Mar del Plata → Tandil

        grafo.agregarArco(7200, 7300, null); // Las Flores → Azul (alternativa)

        // Ejecutar algoritmo
        CaminosAlternativos caminos = new CaminosAlternativos(grafo);

        List<List<Integer>> rutas = caminos.getRutasDisponibles(1000, 7000);

        // Mostrar resultados
        System.out.println("Rutas disponibles (evitando Las Flores - Rauch):");

        for (List<Integer> ruta : rutas) {
            System.out.println(ruta);
        }
    }

}