package Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud;

import java.util.List;

public class Test_Tablero {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(5);

        tablero.imprimirTablero();

        CaminoConLongitudMinima buscador =
                new CaminoConLongitudMinima(tablero);

        List<Posicion> camino =
                buscador.getCamino(0,0,4,4);

        System.out.println("\nCAMINO ENCONTRADO:");

        for(Posicion p : camino) {

            System.out.println(
                    "(" + p.getFila() +
                            "," +
                            p.getColumna() + ")"
            );
        }
    }
}
