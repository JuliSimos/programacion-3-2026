package Practico_6_Backtracking.Ejercicio_2_CaminoDeMenorLongitud;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaminoConLongitudMinima {
    private Tablero laberinto;
    private List<Posicion> solucion;
    private int mejorPeso;

    public CaminoConLongitudMinima(Tablero tablero) {
        this.laberinto = tablero;
        this.solucion = new ArrayList<Posicion>();
        this.mejorPeso = 0;
    }
    public List<Posicion> getCamino(int fila1, int colm1, int fila2, int colm2) {
        this.solucion.clear();
        this.mejorPeso = Integer.MAX_VALUE;
        Posicion origen = new Posicion(fila1, colm1);
        Posicion destino = new Posicion(fila2, colm2);
        if (!laberinto.posicionValida(fila1, colm1) || !laberinto.posicionValida(fila2, colm2)) {
            return solucion;
        }
        List<Posicion> caminoParcial = new ArrayList<>();
        int pesoParcial = laberinto.getCasilla(origen.getFila(),origen.getColumna()).getValor();
        caminoParcial.add(origen);
        buscarMejorCamino(origen, destino, caminoParcial, pesoParcial);

        return this.solucion;
    }
    public void buscarMejorCamino(Posicion actual, Posicion destino, List<Posicion> caminoParcial, int pesoParcial) {
        if(actual.equals(destino)) {
            if(pesoParcial < mejorPeso){
                this.solucion.clear();
                this.solucion.addAll(new ArrayList<>(caminoParcial));
                this.mejorPeso = pesoParcial;
            }

        }else{
            if(pesoParcial > mejorPeso) return;
            //como genero los candidatos para recorrerlos?
            Iterator<Posicion> vecinos = laberinto.getVecinos(actual);
            while (vecinos.hasNext()) {
                Posicion vecino = vecinos.next();
                if(!caminoParcial.contains(vecino)) {
                    Casilla casillaVecina = laberinto.getCasilla(vecino.getFila(),vecino.getColumna());
                    pesoParcial = pesoParcial + casillaVecina.getValor();
                    caminoParcial.add(vecino);

                    buscarMejorCamino(vecino, destino, caminoParcial, pesoParcial);

                    pesoParcial = pesoParcial - casillaVecina.getValor();
                    caminoParcial.remove(caminoParcial.size() -1);
                }
            }
        }
    }
}
