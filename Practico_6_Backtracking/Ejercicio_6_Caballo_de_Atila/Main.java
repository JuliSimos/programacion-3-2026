package Practico_6_Backtracking.Ejercicio_6_Caballo_de_Atila;

import Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud.Posicion;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Corral corral = new Corral(5);

        corral.soltarCaballo();
        corral.imprimirCorral();

        List<Posicion> recorrido = corral.getRecorridoDelCaballo();

        System.out.println("Recorrido encontrado:");

        for (Posicion pos : recorrido) {
            System.out.print(pos);
        }
    }
}
