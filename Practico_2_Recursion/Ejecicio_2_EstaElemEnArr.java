package Practico_2_Recursion;
/*
Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente
 */
public class Ejecicio_2_EstaElemEnArr {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,6,6,7,9,9};

        //System.out.println(buscar(arr,3,0,arr.length-1));
        System.out.println(buscarElem(arr, 1));

    }
    //primero lo hago iterativo

    public static int buscarElem(int[] arr, int x) {
        if (arr.length == 0) {
            return -1;
        }
        int ini = 0, fin = arr.length - 1;
        while (ini <= fin) {

            int medio = (ini + fin) / 2;

            if(x == arr[medio]) {
                return medio;
            }

            if (x > arr[medio]) {
                ini = medio+1;
            } else {
                fin = medio-1;
            }
        }
        return -1;
    }
    public static int buscarElemRecu(int[] arr, int x) {
        if (arr.length == 0) {
            return -1;
        }
        return buscar(arr, x, 0, arr.length-1);
    }
    public static int buscar(int[] arr, int x, int ini, int fin) {
        int medio;
        if (ini > fin) {
            return -1;
        } else {
            medio = (ini + fin) / 2;
            if (x > arr[medio]) {
                return buscar(arr, x, medio + 1, fin);
            } else if (x < arr[medio]) {
                return buscar(arr, x, ini, medio - 1);
            } else {
                return medio;
            }
        }
    }

}

