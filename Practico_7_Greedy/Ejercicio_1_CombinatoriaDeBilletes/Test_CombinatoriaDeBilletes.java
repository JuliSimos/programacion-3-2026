package Practico_7_Greedy.Ejercicio_1_CombinatoriaDeBilletes;

import java.util.ArrayList;
import java.util.List;

public class Test_CombinatoriaDeBilletes {
    public static void main(String[] args) {
        List<Integer> billetes = new ArrayList<>();
        billetes.add(1);
        billetes.add(5);
        billetes.add(10);
        billetes.add(25);
        billetes.add(100);

        GenerarVuelto caja = new GenerarVuelto(billetes, 289);
        System.out.println(caja.getSolucion());
    }
}

