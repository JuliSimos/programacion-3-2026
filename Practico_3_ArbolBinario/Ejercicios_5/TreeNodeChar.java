package Practico_3_ArbolBinario.Ejercicios_5;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeChar {
    private TreeChar root;

    public TreeNodeChar(){
        this.root = null;
    }
    public List buscarPalabras(int vocales){
        return this.buscarPalabras(this.root, vocales, "", new ArrayList<>(), 0);
    }
    private List buscarPalabras(TreeChar actual, int vocalesMax, String palabra, List result, int sumaVocales){
        if(actual == null) return result;

        // 1. Actualizamos los datos del camino para este nodo
        String palabraActualizada = palabra + actual.getValue();
        int vocalesActualizadas = sumaVocales + (isVocal(actual.getValue()) ? 1 : 0);

        // 2. Si es hoja, evaluamos el resultado final de esta rama
        if(actual.getLeft() == null && actual.getRight() == null){
            if(vocalesActualizadas == vocalesMax){
                result.add(palabraActualizada);
            }
            return result; // Importante retornar aquí para no seguir a los hijos (que son null)
        }

        // 3. PASAR LOS DATOS ACTUALIZADOS a los hijos
        buscarPalabras(actual.getLeft(), vocalesMax, palabraActualizada, result, vocalesActualizadas);
        buscarPalabras(actual.getRight(), vocalesMax, palabraActualizada, result, vocalesActualizadas);

        return result;
    }

    public boolean isVocal(char n){
        switch (n){
            case 'a', 'A', 'e', 'E','i', 'I', 'o', 'O', 'u', 'U' -> {
                return true;
            }default -> {
                return false;
            }
        }
    }

}
