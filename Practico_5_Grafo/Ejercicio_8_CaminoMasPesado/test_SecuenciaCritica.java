package Practico_5_Grafo.Ejercicio_8_CaminoMasPesado;

import java.util.List;

public class test_SecuenciaCritica {
    public static void main(String[] args) {

        GrafoDirigido_Tareas grafo = new GrafoDirigido_Tareas();

        // Crear tareas (id, descripcion, duracion)
        Tarea t0 = new Tarea(0, "Inicio", 5);
        Tarea t1 = new Tarea(1, "Analisis", 10);
        Tarea t2 = new Tarea(2, "Diseño", 18);
        Tarea t3 = new Tarea(3, "Implementacion", 12);
        Tarea t4 = new Tarea(4, "Testing", 6);
        Tarea t5 = new Tarea(5, "Deploy", 4);

        // Agregar tareas al grafo
        grafo.addTarea(t0);
        grafo.addTarea(t1);
        grafo.addTarea(t2);
        grafo.addTarea(t3);
        grafo.addTarea(t4);
        grafo.addTarea(t5);

        // Agregar dependencias (origen, destino, demora)
        grafo.agregarArco(t0, t1, 2);
        grafo.agregarArco(t0, t2, 3);
        grafo.agregarArco(t1, t3, 4);
        grafo.agregarArco(t2, t3, 1);
        grafo.agregarArco(t3, t4, 2);
        grafo.agregarArco(t4, t5, 1);

        // Ejecutar algoritmo
        SecuenciaTareas secuencia = new SecuenciaTareas(grafo);

        List<Tarea> resultado = secuencia.getSecuenciaCritica();

        // Mostrar resultado
        System.out.println("Camino crítico:");
        for (Tarea t : resultado) {
            System.out.print(t.getId() + " ");
        }

        System.out.println("\n");

        // Opcional: mostrar con más info
        System.out.println("Detalle:");
        for (Tarea t : resultado) {
            System.out.println("Tarea " + t.getId() + " (" + t.getDescripcion() +
                    ") duración: " + t.getDuracion());
        }
    }
}