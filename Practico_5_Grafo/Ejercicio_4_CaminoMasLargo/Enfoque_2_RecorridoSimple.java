package Practico_5_Grafo.Ejercicio_4_CaminoMasLargo;

import Practico_5_Grafo.Ejercicio_1_Implementacion.Grafo;

import java.util.*;

public class Enfoque_2_RecorridoSimple {
    /*
     Llevamos la solucion parcial en cada momento, cuando avanzo
     Enfoque mas similiar a la estructura de Backtracking (tecnica de busqueda de todo el espacio de soluciones)
     - Necesitamos un "estado" (en este caso de camino parcial)
     - Tenemos que realizar acciones para avanzar de estado
     - Tenemos que deshacer las acciones para volver al estado anterior
     La mejor solucio es mas simple llevarla como parametro de clase
     - Generalmente necesitamos un metodo auxiliar (configura estado inicial)
     */
    private Grafo<?> grafo;
    private Set<Integer> visitados;
    private List<Integer> mejorSolucion;

    public Enfoque_2_RecorridoSimple(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<Integer>();
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Integer> caminoMasLargoBack(Integer origen, Integer destino) {
        //inicializo las estructuras que necesito
        this.visitados.clear();
        this.mejorSolucion.clear();

        List<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen); //busca una solucion con el origen siendo ya parte
        visitados.add(origen);

        caminoMasLargoBack(origen, destino, caminoParcial);

        return mejorSolucion;

    }

    public void caminoMasLargoBack(Integer origen, Integer destino, List<Integer> caminoParcial) {
        //condicion de corte, cuando llegue a un estado final
        if(origen.equals(destino)){
            if(caminoParcial.size() > this.mejorSolucion.size()){
                mejorSolucion.clear();
                mejorSolucion.addAll(caminoParcial);
            }
        }else{
            //generar candidatos a partir del estado actual
            //los candidatos serian los adyacentes de origen
            Iterator<Integer> ady = grafo.obtenerAdyacentes(origen);
            while (ady.hasNext()) {
                Integer vecino = ady.next();
                if(!visitados.contains(vecino)) {
                    //genero el nuevo estado /(aplico estado, candidato)
                    caminoParcial.add(vecino);
                    visitados.add(vecino);
                    //llamada recursiva con el estado actualziado (camino parcial)
                    caminoMasLargoBack(vecino, destino, caminoParcial);
                    //volvemos al estado anterior (deshacer)
                    caminoParcial.remove(vecino);
                    visitados.remove(vecino);
                }
            }
        }
    }
}
