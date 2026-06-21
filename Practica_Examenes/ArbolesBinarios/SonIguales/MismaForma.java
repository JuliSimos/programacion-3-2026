package Practica_Examenes.ArbolesBinarios.SonIguales;

import Practico_3_ArbolBinario.TreeNode;

public class MismaForma {
    TreeNode raiz;
    boolean mismaForma(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        return mismaForma(a.getLeft(), b.getLeft()) &&
                mismaForma(a.getRight(), b.getRight());
    }
}
