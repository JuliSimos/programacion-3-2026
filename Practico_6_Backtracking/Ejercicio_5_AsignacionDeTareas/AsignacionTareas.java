package Practico_6_Backtracking.Ejercicio_5_AsignacionDeTareas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsignacionTareas {
    private List<Tarea> tareas;
    private List<Integer> procesadores;
    private List<List<Tarea>> asignacionTareasFinal;
    private int mejorTiempo;

public AsignacionTareas(List<Tarea> tareas, List<Integer> procesadores) {
    this.tareas = tareas;
    this.procesadores = procesadores;
    this.asignacionTareasFinal = new ArrayList<>();
}

    public List<List<Tarea>> getAsignacionTareasFinal() {
        this.asignacionTareasFinal.clear();
        if(procesadores.isEmpty() || tareas.isEmpty()) return this.asignacionTareasFinal;
        int indexTarea = 0;
        mejorTiempo = Integer.MAX_VALUE;
        List<Integer> cargas = new ArrayList<>();
        List<List<Tarea>> solucionParcial = new ArrayList<>();
        for(Integer p: procesadores){
            solucionParcial.add(new ArrayList<>());
            cargas.add(0);
        }
        asignarTareasEquitativamente(indexTarea, cargas, solucionParcial);
        return this.asignacionTareasFinal;
    }
    private void asignarTareasEquitativamente(int tarea, List<Integer> cargas, List<List<Tarea>> solucionParcial) {
        if(tarea >= tareas.size()){
            int tiempoMax = Collections.max(cargas);
            if(tiempoMax < this.mejorTiempo){
                this.asignacionTareasFinal.clear();

                for(int p = 0; p < procesadores.size(); p++){
                    asignacionTareasFinal.add(new ArrayList<>(solucionParcial.get(p)));
                }
                this.mejorTiempo = tiempoMax;
            }
        }else{
            for(int p = 0; p < procesadores.size(); p++) {
                Tarea t = tareas.get(tarea);
                solucionParcial.get(p).add(t);
                int cargaActual = cargas.get(p);
                cargaActual += t.getTiempo();
                cargas.set(p, cargaActual);
                if(cargaActual < this.mejorTiempo)
                asignarTareasEquitativamente(tarea + 1, cargas, solucionParcial);

                solucionParcial.get(p).remove(t);
                cargaActual -= t.getTiempo();
                cargas.set(p, cargaActual);
            }

        }
        //pruebo todos los procesadores para la tarea
    }
}
