package Practica_Examenes.Backtracking.Mochila;

import java.util.ArrayList;

public class Test_CargarMochila {
    public static void main(String[] args) {
        ArrayList<Integer> productosPeso =  new ArrayList<>();
        ArrayList<Integer> productosValor =  new ArrayList<>();

        productosPeso.add(0,20);
        productosPeso.add(1,5);
        productosPeso.add(2,2);
        productosPeso.add(3,18);

        productosValor.add(0,5);
        productosValor.add(1,15);
        productosValor.add(2, 100);
        productosValor.add(3, 10);

        CargarMochila organizador = new CargarMochila(22, productosPeso, productosValor);
        System.out.println(organizador.cargarMochi());

    }
}
