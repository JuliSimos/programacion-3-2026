package Practica_Examenes.ArbolesBinarios;

import Practico_3_ArbolBinario.Tree;
import Practico_3_ArbolBinario.TreeNode;

public class getSumaNodos {
    Tree arbol = new Tree();
    TreeNode root = new TreeNode(6); //provisional

    public int getSuma(int L, int R) {
        // Validación de rangos lógicos
        if (L < 0 || R < 0 || L > R) return 0;

        return sumarNodos(this.root, L, R, 0);
    }

    private int sumarNodos(TreeNode v, int L, int R, int nivel) {
        // Caso base: si el nodo es nulo o nos pasamos del nivel máximo del rango, paramos
        if (v == null || nivel > R) return 0;

        int sumaActual = 0;
        // Si estamos dentro del rango de niveles, sumamos el valor del nodo actual
        if (nivel >= L && nivel <= R) {
            sumaActual = v.getValue();
        }

        // Sumamos recursivamente lo que devuelva el subárbol izquierdo y el derecho
        int sumaIzquierda = sumarNodos(v.getLeft(), L, R, nivel + 1);
        int sumaDerecha = sumarNodos(v.getRight(), L, R, nivel + 1);

        // Retornamos el total acumulado de esta rama
        return sumaActual + sumaIzquierda + sumaDerecha;
    }
}
