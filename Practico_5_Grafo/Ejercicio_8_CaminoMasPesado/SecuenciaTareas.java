package Practico_5_Grafo.Ejercicio_8_CaminoMasPesado;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecuenciaTareas{
    private GrafoDirigido_Tareas grafo;
    private int pesoSolucion;
    private List<Tarea> solucion;

    public SecuenciaTareas(GrafoDirigido_Tareas grafo) {
        this.grafo = grafo;
        this.solucion = new ArrayList<>();
    }
    public List<Tarea> getSecuenciaCritica(){
        this.solucion.clear();
        this.pesoSolucion = Integer.MIN_VALUE;
        //Busco los nodos con entrada 0
        ArrayList<Tarea> tareasIniciales = new ArrayList<>();

        Iterator<Tarea> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Tarea v =  vertices.next();
            if(grafo.getGradoEntrada(v) == 0){
                tareasIniciales.add(v);
            }
        }
        List<Tarea> caminoParcial = new ArrayList<>();
        for(Tarea t: tareasIniciales){
            buscarSecuenciaCritica(t, caminoParcial, 0);
        }
        return this.solucion;

    }
    public void buscarSecuenciaCritica(Tarea actual, List<Tarea> caminoParcial, int peso){
        caminoParcial.add(actual);
        Iterator<Tarea> ady =  this.grafo.obtenerAdyacentes(actual);
        if(!ady.hasNext()){
            int pesoFinal = peso + actual.getDuracion();
            if(pesoFinal > pesoSolucion){
                this.solucion.clear();
                this.solucion.addAll(caminoParcial);
                this.pesoSolucion = pesoFinal;
            }
        }else{
            while(ady.hasNext()){
                Tarea vecino =  ady.next();
                //peso = peso acumulado + duración(actual) + demora(actual → vecino)
                ArcoT arco = grafo.obtenerArco(actual, vecino);
                if(arco != null) {
                    int nuevoPeso = peso + actual.getDuracion() + arco.getDemora();
                    buscarSecuenciaCritica(vecino, caminoParcial, nuevoPeso);
                }
            }
        }
        caminoParcial.remove(caminoParcial.size() - 1);
    }


}
