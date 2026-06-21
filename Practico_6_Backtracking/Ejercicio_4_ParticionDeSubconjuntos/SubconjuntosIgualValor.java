package Practico_6_Backtracking.Ejercicio_4_ParticionDeSubconjuntos;

import java.util.ArrayList;
import java.util.List;

public class SubconjuntosIgualValor {
    private List<Integer> nros;
    //no se si esta solucion esta bien
    /* sino podria
       - devolver una sola solución
       - devolver todas agrupadas mejor
       - crear una clase Particion
     */
    private List<List<Integer>> subconjuntos;
    private int sumaTotal;

    public SubconjuntosIgualValor(List<Integer> nros) {
        this.nros = nros;
        this.subconjuntos = new ArrayList<>();
        this.sumaTotal = this.sumar();
    }

    public List<List<Integer>> getSubConjuntosIgualSuma(){
        this.subconjuntos.clear();
        //la poda mas grande, si la suma total del subconjunto es impar, no habra solucion posible
        if(!this.isPar(sumaTotal)) return this.subconjuntos;
        this.buscarSubConjuntos(new ArrayList<>(), new ArrayList<>(), 0,0,0);
        return this.subconjuntos;
    }
    public void buscarSubConjuntos(ArrayList<Integer> teamA, ArrayList<Integer> teamB, int sumaA, int sumaB, int index){
        if(sumaA > sumaTotal/2) return;
        if(sumaB > sumaTotal/2) return;

        if(index == this.nros.size()){
            if(sumaA == sumaB){
                this.subconjuntos.add(new ArrayList<>(teamA));
                this.subconjuntos.add(new ArrayList<>(teamB));
                return;
            }
        }else{
            //lo agrego a la teamA
            teamA.add(this.nros.get(index));
            sumaA += this.nros.get(index);
            buscarSubConjuntos(teamA, teamB, sumaA, sumaB, index+1);
            //deshago lo que hice
            teamA.remove(teamA.size()-1);
            sumaA -= this.nros.get(index);



            teamB.add(this.nros.get(index));
            sumaB += this.nros.get(index);
            buscarSubConjuntos(teamA, teamB, sumaA, sumaB, index+1);
            //deshago lo que hice
            teamB.remove(teamB.size() -1);
            sumaB -= this.nros.get(index);
        }
    }

    public int sumar(){
        int suma = 0;
        for (Integer n: nros){
            suma += n;
        }
        return suma;
    }
    public boolean isPar(int nro){
        return nro % 2 == 0;
    }


}
