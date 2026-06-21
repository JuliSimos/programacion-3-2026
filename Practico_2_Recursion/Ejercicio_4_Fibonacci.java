package Practico_2_Recursion;

import java.util.Arrays;

public class Ejercicio_4_Fibonacci {
    public static void main(String[] args) {
        fiboRecursivo(10);
    }

    public static void fibonacci(int n){
        //0 1 1 2 3 5 8 13 21 34
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void fibonacci_2(int n){
        int a = 0;
        int b = 1;
        int suma;

        if(n == 0) {
            return;
        }else if(n == 1) {
            System.out.print(a);
        }else{
            System.out.print(a + " - " + b + " - ");
        }
        for (int i = 2; i < n; i++) {
            suma = a + b;
            System.out.print(suma + " - " );
            a = b;
            b = suma;
        }
    }
public static void fiboRecursivo(int n){
        // Cantidad de números a mostrar
    for (int i = 0; i < n; i++) {
        // ¿Qué deberíamos imprimir aquí usando tu función fibonacciRecursivo(i)?
        System.out.print(fibonacciRecursivo(i) + " - ");
    }
}
    /*
    Formula de Fibonacci: Fib(n) = Fib(n-1) + Fib(n-2)
     */
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) { //si el num es 1 o 0 retorno directamente el numero
            return n; // Casos base: F(0) = 0 y F(1) = 1
        } else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2); // Llamada recursiva
        }
    }

}
