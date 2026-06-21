package Practico_6_Backtracking.Ejercicio_6_Caballo_de_Atila;

import Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud.Posicion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corral {
    private boolean[][] corral;
    private List<Posicion> caminoFinal;
    private boolean[][] visitados;
    private int tamanio;
    private int cantPisadas;

    public Corral(int tamañoTablero) {
        this.caminoFinal = new ArrayList<>();
        this.visitados = new boolean[tamañoTablero][tamañoTablero];
        this.corral = new boolean[tamañoTablero][tamañoTablero];
        this.tamanio = tamañoTablero;
    }
    public void imprimirCorral() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {

                if (corral[i][j]) { // hay pasto
                    System.out.print(". ");
                } else { // pasó el caballo
                    System.out.print("X ");
                }

            }
            System.out.println();
        }
    }
    public void soltarCaballo() {
        // primero todo tiene pasto
        for(int i = 0; i < tamanio; i++){
            for(int j = 0; j < tamanio; j++){
                corral[i][j] = true;
            }
        }

        // fila superior
        for(int j = 0; j < tamanio; j++){
            corral[0][j] = false;
        }

        // columna derecha
        for(int i = 1; i < tamanio; i++){
            corral[i][tamanio - 1] = false;
        }

        // fila inferior
        for(int j = tamanio - 2; j >= 0; j--){
            corral[tamanio - 1][j] = false;
        }

        // columna izquierda
        for(int i = tamanio - 2; i > 0; i--){
            corral[i][0] = false;
        }
    }

    public List<Posicion> getVecinos(Posicion pos) {
        int fila = pos.getFila();
        int columna = pos.getColumna();
        List<Posicion> vecinos = new ArrayList<>();
        if (fila > 0) //Si fila es mayor a 0 puede ir arriba
            vecinos.add(new Posicion(fila - 1, columna));
        if (fila != tamanio - 1) //Si fila es distinto a la ultima fila puede ir abajo
            vecinos.add(new Posicion(fila + 1, columna));
        if (columna > 0)
            vecinos.add(new Posicion(fila, columna - 1));
        if (columna != tamanio - 1)
            vecinos.add(new Posicion(fila, columna + 1));

        return vecinos;
    }

    public boolean sonVecinos(Posicion pos1, Posicion pos2) {
        //son vecinos su sus valores, de fila y columna no sobrepasan de uno
        int dfila = pos1.getFila() - pos2.getFila();
        int dcolumna = pos1.getColumna() - pos2.getColumna();

        return Math.abs(dfila) + Math.abs(dcolumna) == 1;
    }

    public int getCantPisadas() {
        int suma = 0;
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (!corral[i][j]) {//si es true sumo una, porque el caballo paso por ahi
                    suma++;
                }
            }
        }
        return suma;
    }

    /*
       @return: true si el caballo no paso por ahi, false si lo hizo, dejo de crecer pasto
     */
    public boolean hayPasto(Posicion pos) {
        return corral[pos.getFila()][pos.getColumna()];
    }

    public boolean fueVisitada(Posicion pos) {
        return visitados[pos.getFila()][pos.getColumna()];
    }

    public void marcarVisitado(Posicion pos) {
        visitados[pos.getFila()][pos.getColumna()] = true;
    }

    public void desmarcarVisitado(Posicion pos) {
        visitados[pos.getFila()][pos.getColumna()] = false;
    }

    public List<Posicion> getBordes() {
            List<Posicion> bordes = new ArrayList<>();

            // fila superior
            for(int j = 0; j < tamanio; j++) {
                bordes.add(new Posicion(0, j));
            }

            // fila inferior
            for(int j = 0; j < tamanio; j++) {
                bordes.add(new Posicion(tamanio - 1, j));
            }

            // columna izquierda sin esquinas
            for(int i = 1; i < tamanio - 1; i++) {
                bordes.add(new Posicion(i, 0));
            }

            // columna derecha sin esquinas
            for(int i = 1; i < tamanio - 1; i++) {
                bordes.add(new Posicion(i, tamanio - 1));
            }

            return bordes;
        }


    public List<Posicion> getRecorridoDelCaballo() {
        this.cantPisadas = this.getCantPisadas();
        this.caminoFinal.clear();
        List<Posicion> bordes = this.getBordes();
        for(Posicion pos : bordes) {
            Posicion origen = pos;
            this.visitados = new boolean[tamanio][tamanio];
            if (!hayPasto(origen)) {
                List<Posicion> caminoParcial = new ArrayList<>();
                caminoParcial.add(origen);
                marcarVisitado(origen);
                //visitados[origen.getFila()][origen.getColumna()] = true;
                if (recorrido(origen, origen, caminoParcial))
                    return this.caminoFinal;
            }
        }
        return caminoFinal;
    }

    public boolean recorrido(Posicion actual,Posicion origen, List<Posicion> caminoParcial) {
        if(this.cantPisadas ==  caminoParcial.size()){
            if(sonVecinos(actual,origen)){
                caminoFinal.addAll(new ArrayList<>(caminoParcial));
                caminoFinal.add(origen); //solucion más limpia
                return true;
            }
        }else{
            List<Posicion> vecinos =  this.getVecinos(actual);
            for(Posicion vecino : vecinos){
                //!this.visitados[vecino.getFila()][vecino.getColumna()] = fueVisitada(vecino)
                if(!this.hayPasto(vecino) && !fueVisitada(vecino)){
                    caminoParcial.add(vecino);
                    marcarVisitado(vecino);
                    //visitados[vecino.getFila()][vecino.getColumna()] = true;
                    if(recorrido(vecino,origen,caminoParcial))
                        return true; //propaga la solucion, ya encontro una

                    caminoParcial.remove(caminoParcial.size()-1);
                    desmarcarVisitado(vecino);
                    //visitados[vecino.getFila()][vecino.getColumna()] = false;
                }
            }
        }
        return false;
    }

}