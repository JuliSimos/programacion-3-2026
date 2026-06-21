package Practico_2_Recursion;

import java.util.Arrays;

public class Ejercicio_7_Mergesort {
        private int[ ] numbers;
        private int[ ] helper;
        private int size;

        public void sort(int[ ] values) {
            this.numbers = values;
            size = values.length;
            this.helper = new int[size];
            mergesort(0, size - 1);
        }
        private void mergesort(int low, int high) {
            // si low es menor que high continua el ordenamiento
            // si low no es menor que high entonces el array está ordenado
            // ya que es el caso base donde el array tiene un solo elemento.
            System.out.println("("+ low +" < "+ high + ")" + (low < high));
            if (low < high) {
                // obtener el indice del elemento que se encuentra en la mitad
                // al ser int redondea el resultado al entero menor
                int middle = (low + high) / 2;
                System.out.println("middle = ("+low +" + "+ high + ")" + "/ 2 :" + middle);
                // ordenar la mitad izquierda del array – llamada recursiva
                System.out.println("Entra por izquierda: mergesort(" + low + "," + middle +")");
                mergesort(low, middle);
                // ordenar la mitad derecha del array – llamada recursiva
                System.out.println("Entra por derecha: mergesort(" + (middle + 1) + "," + high +")");

                mergesort(middle + 1, high);
                // combinar ambas mitades ordenadas
                System.out.println("merge " + low + "-" + middle + "-" + high);
                merge(low, middle, high);
                System.out.println(Arrays.toString(numbers));
            }
        }

    private void merge(int low, int middle, int high) {
            // copiar ambas partes al array helper
            for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            // copiar de manera ordenada al array original los valores de la
            // mitad izquierda o de la derecha
            while (i <= middle && j <= high) {
                if (helper[ i ] <= helper[ j ]) {
                    numbers[ k ] = helper[ i ];
                    i++;
                } else {
                    numbers[ k ] = helper[ j ];
                    j++;
                }
                k++;
            }
            // si quedaron elementos copiarlos al array original
            while (i <= middle) {
                numbers[ k ] = helper[ i ];
                k++;
                i++;
            }
            while (j <= high) {
                numbers[ k ] = helper[ j ];
                k++;
                j++;
            }
        }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
                ///{5,9,2,1,3,4,7,6,8};
        Ejercicio_7_Mergesort m = new Ejercicio_7_Mergesort();
        System.out.println(Arrays.toString(arr));
        m.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    }

