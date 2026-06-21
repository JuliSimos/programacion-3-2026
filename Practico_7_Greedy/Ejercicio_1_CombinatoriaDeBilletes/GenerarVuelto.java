package Practico_7_Greedy.Ejercicio_1_CombinatoriaDeBilletes;

import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenerarVuelto {
    //solucion, candidatos, sumaTotal
    private List<Integer> solucion;
    private List<Integer> candidatos;
    private int M; //suma total

    public GenerarVuelto(List<Integer> C, int vuelto){
        this.solucion = new ArrayList<Integer>();
        this.candidatos = new ArrayList<>(C);
        this.M = vuelto;
    }
    public List<Integer> getSolucion(){
        this.solucion.clear();
        int sumaParcial = 0;
        int indiceC = 0;
        Collections.reverse(candidatos); //estrategia greedy

        while(sumaParcial < M || indiceC < this.candidatos.size()){
            int x = candidatos.get(indiceC);
            if(sumaParcial + x <= M){
                this.solucion.add(x);
                sumaParcial += x;
            }else{
                indiceC = indiceC + 1;
            }
        }
        return this.solucion;
    }

}
