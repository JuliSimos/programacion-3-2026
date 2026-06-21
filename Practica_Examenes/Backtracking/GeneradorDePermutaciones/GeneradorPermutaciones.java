package Practica_Examenes.Backtracking.GeneradorDePermutaciones;

import java.util.ArrayList;
import java.util.List;

public class GeneradorPermutaciones {
    private ArrayList<Integer> nrosCandidatos;
    private List<List<Integer>> permutaciones;

    public GeneradorPermutaciones(ArrayList<Integer> nros){
        this.nrosCandidatos = nros;
        this.permutaciones = new ArrayList<>();
    }
    public List<List<Integer>> getPermutaciones(){
        this.permutaciones.clear();
            permutar(new ArrayList<>());

        return this.permutaciones;
    }
    private void permutar(List<Integer> listaParcial){
        if(listaParcial.size() == this.nrosCandidatos.size()){
            this.permutaciones.add(new ArrayList<>(listaParcial));
            return;
        }
        for(int i = 0; i < this.nrosCandidatos.size(); i++){
            Integer opc = this.nrosCandidatos.get(i);
            if(!listaParcial.contains(opc)){
                listaParcial.add(opc);

                permutar(listaParcial);

                listaParcial.remove(listaParcial.size()-1);
            }
        }
    }
}
