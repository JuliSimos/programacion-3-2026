package Practica_Examenes.ArbolesBinarios;

import Practico_3_ArbolBinario.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class getNivel {

    public List<Integer> getNivel(TreeNode n, int k){
        if(n == null || k < 0){
            return new ArrayList<>();
        }
        if(k == 0){
            List<Integer> lista = new ArrayList<>();
            lista.add(n.getValue());
        }
        List<Integer> der = getNivel(n.getRight(), k-1);
        der.addAll(getNivel(n.getLeft(), k-1));

        return der;
    }
}
