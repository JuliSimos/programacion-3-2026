package Practico_6_Backtracking.ProblemaAgenteViajero.Ejercicio_3_CombinacionesPosibles;

import java.util.ArrayList;
import java.util.List;

public class HallarCominaciones {
    private List<List<Integer>> allCombinaciones;
    private ArrayList<Integer> candidatos;
    private int M;

    /*
    Tengo que encontrare el subconjunto del conjunto nro que tenga el valor M
    Caso base: Si me quede sin nros
     */
    public List<List<Integer>> HallarCombinaciones(ArrayList<Integer> candidatos, int meta) {
        this.candidatos = candidatos;
        this.M = meta;
        this.allCombinaciones = new ArrayList<>();
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        buscarCombinaciones(0,0,  caminoParcial);
        return allCombinaciones;
    }
    private void buscarCombinaciones(int index, int sumaParcial ,List<Integer> caminoParcial) {
        if(sumaParcial == M){
            allCombinaciones.add(new ArrayList<>(caminoParcial));
            return;
        }else{
            if(index == candidatos.size()) return;
            buscarCombinaciones(index + 1,sumaParcial, caminoParcial);
            int suma = sumaParcial + candidatos.get(index);
            caminoParcial.add(candidatos.get(index));
            buscarCombinaciones(index + 1, suma, caminoParcial);
            caminoParcial.remove(caminoParcial.size() - 1);
        }
    }

}
