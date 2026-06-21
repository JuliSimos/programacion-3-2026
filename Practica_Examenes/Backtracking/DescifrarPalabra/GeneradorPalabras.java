package Practica_Examenes.Backtracking.DescifrarPalabra;

import java.util.ArrayList;
import java.util.List;

public class GeneradorPalabras {
    private String palabra;
    private List<String> solucion;
    private char[] letras;

    public GeneradorPalabras(String palabra, char[] letras){
        this.palabra = palabra;
        this.letras = letras;
        this.solucion = new ArrayList<>();
    }
    public List<String> getSolucion() {
        this.solucion.clear();

        if(palabra.isEmpty()) return new ArrayList<>();


        char[] palabraParcial = new char[palabra.length()];
        for(int i = 0; i < palabra.length(); i++){
            palabraParcial[i] = palabra.charAt(i);
        }
        generarPalabras(0, palabraParcial);

        return solucion;
    }
    private void generarPalabras(int indiceP, char[] palabraParcial){
        if(indiceP == palabra.length()){
            String pNueva = new String(palabraParcial);
            //if(existeP(palabraParcial)
            solucion.add(pNueva);
            return;
        }

        if(palabraParcial[indiceP] != '_'){
            generarPalabras(indiceP + 1, palabraParcial);
        }else{
            for (char l :  letras) {
                palabraParcial[indiceP] =  l;

                generarPalabras(indiceP + 1, palabraParcial);

                palabraParcial[indiceP] = '_';
            }
        }
    }
}
