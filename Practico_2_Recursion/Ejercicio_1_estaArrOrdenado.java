package Practico_2_Recursion;

//Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado
/*
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
    - Complejidad O(N):
    El peor caso es que tenga que recorrer todo el arreglo para saber si esta ordenado
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    - El metodo recursivo funciona, aunque seria mas rapido con un while o for, iterar es mas rapido que generar una respuesta con un metodo recursivo
    Extra: Aunque ambos sean O(N) en tiempo, la recursión tiene un "costo oculto" en la memoria (el Stack). Cada llamada recursiva es una cajita nueva que se guarda en la memoria. Si el arreglo es gigante, podrías tener un StackOverflowError. Un simple for o while usa siempre la misma cantidad de memoria O(1) en espacio
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
    - Tiene mas sentido hacer este metodo para arreglos, aunque haya otra forma mas eficiente (iterando), ya que tienen acceso aleatorio O(1).
    Al conocer el índice, la computadora va directo al dato. En cambio, en una lista enlazada, acceder a un índice específico requiere recorrer la lista desde el principio O(N).
    Como la recursión ya recorre la lista una vez, usar un acceso indirecto dentro de cada paso elevaría la complejidad a O(N^2), haciendo que el proceso sea mucho más lento a medida que crece la lista.
 */
public class Ejercicio_1_estaArrOrdenado {
public static void main(String[] args) {
    int[] arr =  {1,2,3,4,6,6,7,9,9};

    //System.out.println(isOrdenado(arr));
    System.out.println(isOrderRecu(arr));

}



//primero hago el metodo iterativo
    public static boolean isOrdenado(int[] arr){
        //necesito un indice para recorrer todo el arreglo
        int pos = 0;
        //si un elemento no cumple con la condicion, el arreglo no esta ordenado
        while(pos < arr.length-1){
            if(arr[pos] > arr[pos+1]){
                return false;
            }
            pos++;
        }
        return pos == arr.length-1;
    }

    public static boolean isOrderRecu(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return true;
        }
        return isOrdenadoRecu(arr, 0);
    }

    /*
    Consideraciones: Confirma si un arreglo esta ordenado de forma ascendente y considera validos los iguales
     */
    public static boolean isOrdenadoRecu(int[] arr, int actual){
        //Si llego al final del arreglo retorno true
        if(actual == arr.length-1) {
            return true;
        }
        if(arr[actual] > arr[actual+1]){
                return false;
        }
        return isOrdenadoRecu(arr, actual+1);
    }
}
