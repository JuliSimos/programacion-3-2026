package Practica_Examenes.Backtracking.GeneradorDePermutaciones;

import java.util.ArrayList;

public class Test_GeneradorPermutaciones {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        GeneradorPermutaciones g = new GeneradorPermutaciones(lista);
        System.out.println(g.getPermutaciones());
    }
}
