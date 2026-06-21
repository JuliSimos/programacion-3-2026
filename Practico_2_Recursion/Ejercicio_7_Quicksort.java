package Practico_2_Recursion;

public class Ejercicio_7_Quicksort {
    //Algoritmo Quick-Sort

        public void sort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return; // Un arreglo vacío o de un solo elemento ya está ordenado
            }
            quicksort(arr, 0, arr.length - 1);
        }

        private void quicksort(int[] arr, int low, int high) {
            if (low < high) {
                // 1. Elegir un pivote
                int pivotIndex = partition(arr, low, high);

                // 2. Ordenar recursivamente las sub-arreglos a la izquierda y a la derecha del pivote
                quicksort(arr, low, pivotIndex - 1);
                quicksort(arr, pivotIndex + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            // Elegir el pivote (aquí elegimos el último elemento como pivote)
            int pivot = arr[high];
            int i = low - 1; // Índice del elemento más pequeño

            for (int j = low; j < high; j++) {
                // Si el elemento actual es menor o igual al pivote
                if (arr[j] <= pivot) {
                    i++;

                    // Intercambiar arr[i] y arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Intercambiar el pivote (arr[high]) con el elemento en la posición correcta (arr[i + 1])
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            // Devolver el índice del pivote
            return i + 1;
        }

        public static void main(String[] args) {
            Ejercicio_7_Quicksort sorter = new Ejercicio_7_Quicksort();
            int[] arr = {10, 7, 8, 9, 1, 5};
            sorter.sort(arr);
            System.out.println("Arreglo ordenado:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            // Salida: Arreglo ordenado: 1 5 7 8 9 10
        }
    }

