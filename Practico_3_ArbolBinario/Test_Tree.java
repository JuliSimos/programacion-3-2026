package Practico_3_ArbolBinario;

public class Test_Tree {
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


        System.out.print(arbol.getElemAtLevel(0));
        System.out.println("");
        arbol.imprimirPreOrden();
        System.out.println("");
        arbol.imprimirPosOrden();
        System.out.println("");
        arbol.imprimirEnOrden();
        System.out.println("");
        System.out.println(arbol.existeCamino(29));
        System.out.println(arbol.getHeight());
    }
}
