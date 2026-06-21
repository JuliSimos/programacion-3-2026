package Practico_7_Greedy.Ejercicio_2_MochilaFraccionaria;

import java.util.ArrayList;
import java.util.List;

public class Test_MochilaFraccionaria {
    public static void main(String[] args) {
        List<Objeto> objs = new ArrayList<>();

        objs.add(new Objeto(0,20,10));
        objs.add(new Objeto(1, 30,20));
        objs.add(new Objeto(2, 66,30));
        objs.add(new Objeto(3, 40,40));
        objs.add(new Objeto(4, 60,50));

        MochilaFraccionaria mochi = new MochilaFraccionaria(objs, 100);
        System.out.println(mochi.getSolucion());
    }
}
