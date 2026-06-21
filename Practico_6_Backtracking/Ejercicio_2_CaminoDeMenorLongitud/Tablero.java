package Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tablero {

    private Casilla[][] tablero;
    private int tamaño;

    public Tablero(int tamaño) {

        this.tamaño = tamaño;
        this.tablero = new Casilla[tamaño][tamaño];

        inicializarCasillas();
        conectarTodo();
        generarParedesAleatorias();
    }

    private void inicializarCasillas() {

        Random random = new Random();

        for(int i = 0; i < tamaño; i++) {

            for(int j = 0; j < tamaño; j++) {

                int valor = random.nextInt(9) + 1;
                tablero[i][j] = new Casilla(valor);
            }
        }
    }

    private void conectarTodo() {

        for(int i = 0; i < tamaño; i++) {

            for(int j = 0; j < tamaño; j++) {

                if(i > 0)
                    tablero[i][j].setNorte(true);

                if(i < tamaño - 1)
                    tablero[i][j].setSur(true);

                if(j > 0)
                    tablero[i][j].setOeste(true);

                if(j < tamaño - 1)
                    tablero[i][j].setEste(true);
            }
        }
    }

    private void generarParedesAleatorias() {

        Random random = new Random();

        for(int i = 0; i < tamaño; i++) {

            for(int j = 0; j < tamaño; j++) {

                // derecha
                if(j < tamaño - 1) {

                    if(random.nextBoolean()) {

                        tablero[i][j].setEste(false);
                        tablero[i][j + 1].setOeste(false);
                    }
                }

                // abajo
                if(i < tamaño - 1) {

                    if(random.nextBoolean()) {

                        tablero[i][j].setSur(false);
                        tablero[i + 1][j].setNorte(false);
                    }
                }
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean posicionValida(int fila, int columna) {

        return fila >= 0 &&
                fila < tamaño &&
                columna >= 0 &&
                columna < tamaño;
    }

    public int getTamaño() {
        return tamaño;
    }
    public void imprimirTablero() {

        for(int i = 0; i < tamaño; i++) {

            // linea superior
            for(int j = 0; j < tamaño; j++) {

                System.out.print("+");

                if(tablero[i][j].isNorte())
                    System.out.print("   ");
                else
                    System.out.print("---");
            }

            System.out.println("+");

            // contenido de casillas
            for(int j = 0; j < tamaño; j++) {

                if(tablero[i][j].isOeste())
                    System.out.print(" ");
                else
                    System.out.print("|");

                System.out.printf("%2d ", tablero[i][j].getValor());
            }

            System.out.println("|");
        }

        // borde inferior
        for(int j = 0; j < tamaño; j++) {
            System.out.print("+---");
        }

        System.out.println("+");
    }
    public List<Posicion> obtenerVecinos(Posicion actual){
        List<Posicion> vecinos = new ArrayList<>();
        if(!this.posicionValida(actual.getFila(), actual.getColumna()))
            return vecinos;
        Casilla casilla = this.getCasilla(actual.getFila(), actual.getColumna());
        if(casilla.isNorte())
            vecinos.add(new Posicion(actual.getFila() - 1, actual.getColumna()));

        if(casilla.isEste())
            vecinos.add(new Posicion(actual.getFila(), actual.getColumna() + 1));

        if (casilla.isSur())
            vecinos.add(new Posicion(actual.getFila() + 1, actual.getColumna()));

        if (casilla.isOeste())
            vecinos.add(new Posicion(actual.getFila(), actual.getColumna() - 1));

        return vecinos;
    }

    public Iterator<Posicion> getVecinos(Posicion actual) {
        return this.obtenerVecinos(actual).iterator();
    }
}

