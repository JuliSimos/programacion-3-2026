package Practico_2_Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio_3_notacionBinaria {

    public static void main(String[] args) {
        System.out.print(convertidorBinarioRecursivo(10));
    }

    public static void convertidorBi(int n){
        //dividir hasta que ya no se pueda por 2.
        //me quedo con el resto
        //se lee desde el final al inicio
        ArrayList<Integer> nroBinario = new ArrayList();
        while(n >= 1){
            nroBinario.add(n % 2);
            n = n / 2;
        }
        Collections.reverse(nroBinario);
        System.out.println(nroBinario);
    }
    public static String convertidorBinarioRecursivo(int n){
        if(n <= 1){
            return String.valueOf(n);
        }else{
            return convertidorBinarioRecursivo(n / 2) + (n % 2);
        }
    }
    /*
    Orden Correcto: Recursión + Resto
    Construye de izquierda a derecha (1010).
    Orden Inverso: Resto + Recursión
    Construye de derecha a izquierda (0101)
     */
}
