package Practico_3_ArbolBinario;

import Practico_3_ArbolBinario.Ejercicios_5.TreeNodeChar;

public class Main {
    public static void main(String[] args) {
        Tree arbol = new Tree();
        arbol.add(10);
        arbol.add(8);
        arbol.add(13);
        arbol.add(4);
        arbol.add(3);
        arbol.add(7);
        arbol.add(11);
        arbol.add(9);
        arbol.add(18);
        arbol.add(22);
        arbol.add(12);
//        System.out.println(arbol.hasElem(8));
//        System.out.println(arbol.getMaxElem());
//        System.out.println(arbol.getFrontera());
//        System.out.println(arbol.getHeight());
//        System.out.println(arbol.getElemAtLevel(0));
//        System.out.println(arbol.sumatoriaNodos());
//        System.out.println(arbol.getLongestBranch());
//        System.out.println(arbol.hojasmayores(8));
        //arbol.imprimirPreOrden();
//        arbol.acomodarValores();
        System.out.println("PreOrden: ");
        arbol.imprimirPreOrden();
        System.out.println("\n PostOrden: ");
        arbol.imprimirPosOrden();
        System.out.println("\n EnOrden: ");
        arbol.imprimirEnOrden();
        System.out.println("\n Altura: ");

        System.out.println(arbol.getHeight());
        System.out.println(arbol.getRango(1,2));
        //TreeNodeChar arbolChar = new TreeNodeChar();




    }
}
