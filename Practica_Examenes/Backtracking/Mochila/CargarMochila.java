package Practica_Examenes.Backtracking.Mochila;

import java.util.ArrayList;

public class CargarMochila {
    private int K;
    private ArrayList<Integer> pesoP;
    private ArrayList<Integer> valorP;
    private ArrayList<Integer> mejorSolucion;
    private int mejorValor;

    public CargarMochila(int K, ArrayList<Integer> p, ArrayList<Integer> v) {
        this.K = K;
        this.pesoP = new ArrayList<>(p);
        this.valorP =  new ArrayList<>(v);
        this.mejorSolucion = new ArrayList<>();
    }
    public ArrayList<Integer> cargarMochi() {
        this.mejorSolucion.clear();
        this.mejorValor = Integer.MIN_VALUE;

        if(pesoP.isEmpty() ||  valorP.isEmpty()) return new ArrayList<>();
        ArrayList<Integer> solucionParcial = new ArrayList<>();
        for(int i = 0; i < pesoP.size(); i++){
            solucionParcial.add(i, 0);
        }
        ElegirProductos(0,0,0, solucionParcial);

        return mejorSolucion;
    }
    private void ElegirProductos(int indiceP, int pesoActual, int valorActual, ArrayList<Integer> solucionParcial){
         if(indiceP == pesoP.size()) {
             if (valorActual > mejorValor) {
                 mejorSolucion.clear();
                 mejorSolucion.addAll(new ArrayList<>(solucionParcial));
                 mejorValor = valorActual;
             }
             return;
         }
         if((pesoActual + pesoP.get(indiceP)) <= K){
             solucionParcial.set(indiceP, 1);
             pesoActual += pesoP.get(indiceP);
             valorActual += valorP.get(indiceP);

             ElegirProductos(indiceP + 1,pesoActual,valorActual, solucionParcial);

             solucionParcial.set(indiceP, 0);
             pesoActual -= pesoP.get(indiceP);
             valorActual -= valorP.get(indiceP);
         }
         ElegirProductos(indiceP + 1, pesoActual,valorActual, solucionParcial);
    }
}
