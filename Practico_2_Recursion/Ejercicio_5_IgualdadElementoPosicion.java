package Practico_2_Recursion;

public class Ejercicio_5_IgualdadElementoPosicion {
    public static void main(String[] args) {
        int[] arr =  {1,0,3,4,6,6,7,9,8};
        System.out.println(CoincidenciaIndice(arr));
        System.out.println(CoincidenciaIndiceValor(arr));
        System.out.println(CoincidenciaRecursivoWrapper(arr));
        System.out.println(AnalizadorDeIndicesWrapper(arr));

    }
    public static boolean CoincidenciaIndice(int[] arr){
        int n = 0;
        while (n < arr.length){
            if (arr[n] == n){
                return true;
            }
            n++;
        }
        return false;
    }
    public static int CoincidenciaIndiceValor(int[] arr){
        int n = 0;
        while (n < arr.length){
            if (arr[n] == n){
                return n;
            }
            n++;
        }
        return -1;
    }
    public static boolean CoincidenciaRecursivoWrapper(int[] arr){
        int n = 0;
        if (arr.length == 0){
            return false;
        }
        return CoincidenciaRecursivo(arr, n);
    }
    public static boolean CoincidenciaRecursivo(int[] arr, int actual){
        if (actual >= arr.length) return false; // Caso base: me pasé del arreglo
        if (arr[actual] == actual) return true; // Caso base: lo encontré
        return CoincidenciaRecursivo(arr, actual + 1); // Paso recursivo
    }
    public static int AnalizadorDeIndicesWrapper(int[] arr){
        int n = 0;
        if (arr.length == 0){
            return -1;
        }
        return AnalizadorDeIndicesRecu(arr, n);
    }
    public static int AnalizadorDeIndicesRecu(int[] arr, int actual){
        if(actual == arr.length-1){
            return arr[actual] == actual ? actual : -1;
        }
        if(arr[actual] == actual){
            return actual;
        }
        return AnalizadorDeIndicesRecu(arr, actual+1);
    }
    //Recursivo con busqueda binaria, dividiendo a la mitad el arreglo en cada llamada
    public static int buscarIndiceValorWrapper(int[] arr){
        if (arr.length == 0) return -1;
        return buscarIndiceValorRecu(arr, 0, arr.length);
    }
    public static int buscarIndiceValorRecu(int[] arr, int inicio, int fin) {
        if (inicio > fin) return -1; // Caso base: no existe

        int mitad = (inicio + fin) / 2;

        if (arr[mitad] == mitad) return mitad; // ¡Lo encontré!

        if (arr[mitad] < mitad) {
            // El valor se quedó atrás del índice, busco solo a la derecha
            return buscarIndiceValorRecu(arr, mitad + 1, fin);
        } else {
            // El valor se adelantó al índice, busco solo a la izquierda
            return buscarIndiceValorRecu(arr, inicio, mitad - 1);
        }
    }

}
