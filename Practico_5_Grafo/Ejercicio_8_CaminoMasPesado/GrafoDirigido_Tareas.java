package Practico_5_Grafo.Ejercicio_8_CaminoMasPesado;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Arco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido_Tareas {
    private HashMap<Tarea, ArrayList<ArcoT>> tareas;


    public GrafoDirigido_Tareas() {
        tareas = new HashMap<>();
    }

    public void addTarea(Tarea t){
        /*
            Me fijo si ya existe?
            o directamente lo agrego y piso el valor si esta repetido
            Me resulta extraño que sea tan simple el metodo
            Como utilizo HashMap, agregar un elemento a la estructura tiene un costo promedio de O(1)
            lo agrego si no existe
         */
        if(!tareas.containsKey(t)){
            tareas.put(t, new ArrayList<>());
        }
    }

    public void borrarVertice(Tarea t) {
        if (!tareas.containsKey(t)) return;            //recorrer todas las listas de arcos y eliminar si es el destino
            for(List<ArcoT> list: tareas.values()){
                Iterator<ArcoT> iterator = list.iterator();
                while(iterator.hasNext()){
                    ArcoT arco = iterator.next();
                    if(arco.getTareaSiguiente().equals(t)){
                        iterator.remove();
                    }
                }
            }
            tareas.remove(t);
    }

    public void agregarArco(Tarea t1, Tarea t2, int demora) {
        if (!tareas.containsKey(t1) || !tareas.containsKey(t2)) return;
        if (existeArco(t1, t2)) return;

        tareas.get(t1).add(new ArcoT<>(t1, t2, demora));
    }

    public void borrarArco(Tarea t1, Tarea t2) {
        if(tareas.containsKey(t1) && tareas.containsKey(t2)) {
            /*
            List<T> ady = vertices.get(v1);
            Iterator<Arco<T>> it = ady.iterator();
             */
            Iterator<ArcoT> iterator = obtenerArcos(t1);
            while (iterator.hasNext()) {
                ArcoT arco = iterator.next();
                if (arco.getTareaSiguiente().equals(t2)) {
                    iterator.remove();
                    break; // solo puede haber un arco, una vez que lo encontrás → terminás
                }
            }
        }
    }

    public boolean contieneVertice(Tarea t) {
        return tareas.containsKey(t);
    }

    public boolean existeArco(Tarea t1, Tarea t2) {
        //lo simplifico, o recorro los adyacentes de vertice1
        return obtenerArco(t1, t2) != null;
    }

    public ArcoT obtenerArco(Tarea t1, Tarea t2) {
        Iterator<ArcoT> ady = obtenerArcos(t1);
        while (ady.hasNext()) {
            ArcoT arco = ady.next();
            if(arco.getTareaSiguiente().equals(t2)) {
                return arco;
            }
        }
        return null;
    }

    public int cantidadVertices() {
        return tareas.size();
    }

    public int cantidadArcos() {
        int suma = 0;
        for(List<ArcoT> lista : tareas.values()){
            suma += lista.size();
        }
        return suma;
    }

    public Iterator<Tarea> obtenerVertices() {
        // de esta forma expongo directamente la estructura interna, mejor es hacer una copia e iterar sobre ella
        return tareas.keySet().iterator();
    }


    public Iterator<Tarea> obtenerAdyacentes(Tarea t) {
        ArrayList<Tarea> adyacentes = new ArrayList<>();
        Iterator<ArcoT> iter = obtenerArcos(t);
        while (iter.hasNext()) {
            adyacentes.add(iter.next().getTareaSiguiente());
        }
        return adyacentes.iterator();
    }

    public Iterator<ArcoT> obtenerArcos() {
        ArrayList<ArcoT> arcos = new ArrayList<>();
        for(List<ArcoT> lista : tareas.values()){
            arcos.addAll(lista);
        }
        return arcos.iterator();
    }

    public Iterator<ArcoT> obtenerArcos(Tarea t) {
        if (tareas.containsKey(t)) {
            return tareas.get(t).iterator();
        }
        return new ArrayList<ArcoT>().iterator();//retorno un iterador vacio si no existe el vertice
    }
    public int getGradoSalida(Tarea t){
        //cuantos arcos salen de el
        return this.tareas.get(t).size();
    }
    public int getGradoEntrada(Tarea t){
        int grado = 0;
        for(List<ArcoT> list : this.tareas.values()){
            for(ArcoT arco : list){
                Tarea destino  = arco.getTareaSiguiente();
                if(destino.equals(t)){
                    grado++;
                }
            }
        }
        return grado;
    }
    public int getGradoVertice(Tarea t){

    return this.getGradoEntrada(t) + this.getGradoSalida(t);
    }
}
