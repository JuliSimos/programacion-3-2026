package Practico_2_Recursion;

public class Ejercicio_6_OrdenamientosBasicosArreglo {
        public static int MAX = 10;
        public static final int MAXVALOR = 10;
        public static final int MINVALOR = 1;
        public static void main(String[] args) {
            int [] arrint;
            arrint = new int[MAX];

        }
    //Seleccion
    //Complejidad Big O (n^2), el trabajo se multiplica
    public static void ordenar_arreglo_seleccion(int[]arr) {
        int pos_menor, tmp;
        for (int i = 0; i < MAX; i++) {
            pos_menor = i;
            for (int j = i + 1; j < MAX; j++){
                //En cada iteracion busca el menor del arreglo
                if (arr[j] < arr[pos_menor]) {
                    pos_menor = j;
                }
            }
            if (pos_menor != i){
                tmp = arr[i];
                arr[i] = arr[pos_menor];
                arr[pos_menor] = tmp;
            }
        }
    }
    //Burbujeo
    //Complejidad Big O (n^2), el trabajo se multiplica
    public static void ordenar_arreglo_burbujeo(int[] arr){
        int temp;
        for(int i = 1;i < MAX;i++){
            for (int j = 0 ; j < MAX - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //Aunque se puede optimizar para que no genere tantas iteraciones
    public static void burbujeo_optimizado(int[] arr) {
        int n = arr.length;
        boolean huboIntercambio;

        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio (swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break;
            }
        }
    }

}
