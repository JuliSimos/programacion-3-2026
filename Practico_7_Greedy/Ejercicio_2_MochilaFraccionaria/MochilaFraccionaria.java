package Practico_7_Greedy.Ejercicio_2_MochilaFraccionaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MochilaFraccionaria {
    private List<Double> s;
    private List<Objeto> objetos;
    private int capacidadMax;

    public MochilaFraccionaria(List<Objeto> objs, int capacidadMax){
        this.s = new ArrayList<>(objs.size());
        this.objetos = new ArrayList<>(objs);
        this.capacidadMax = capacidadMax;
    }

    public List<Double> getSolucion(){
        this.s.clear();

        List<Objeto> candidatosGreedy = new ArrayList<>(objetos.size());

        for(Objeto obj : this.objetos){
            this.s.add(0.0);

            candidatosGreedy.add(obj);
        }

        Collections.sort(candidatosGreedy);
        double pesoActual = 0;

        int indice = 0;
        while(pesoActual < capacidadMax && indice < candidatosGreedy.size()){
            Objeto x = candidatosGreedy.get(indice);
            if(pesoActual + x.getPeso() <= capacidadMax){
                s.set(x.getIndice(), 1.0);
                pesoActual += x.getPeso();
            }else{
                double f = (capacidadMax - pesoActual) / x.getPeso();
                s.set(x.getIndice(), f);
                pesoActual = capacidadMax;
            }
            indice++;
        }
        return s;
    }

}
