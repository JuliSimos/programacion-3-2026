package Practico_5_Grafo.EJ_2_Recorridos;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;
import Practico_5_Grafo.Ejercicio_1_Implementacion.GrafoDirigido;

import java.util.ArrayList;

public class dfs_test {
    public static void main(String[] args) {
        // Crear grafo dirigido
        Grafo grafo = new GrafoDirigido();

        // Agregar vertices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar arcos (dirigidos)
        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 3, null);
        grafo.agregarArco(2, 4, null);
        grafo.agregarArco(3, 4, null);
        grafo.agregarArco(4, 5, null);

        // Este arco genera un ciclo (back edge)
        grafo.agregarArco(5, 2, null);

        // Ejecutar DFS
        DFS_Simple dfs = new DFS_Simple(grafo);
        ArrayList<Integer> recorrido = dfs.dfs();

        // Mostrar resultado
        System.out.println("Recorrido DFS:");
        for (Integer v : recorrido) {
            System.out.print(v + " ");

        }
    }
}
