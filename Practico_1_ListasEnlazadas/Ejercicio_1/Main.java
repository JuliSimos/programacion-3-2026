package Practico_1_ListasEnlazadas.Ejercicio_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SimpleList<Integer> lista1 = new SimpleList<>();
        lista1.insertFront(5);
        lista1.insertFront(4);
        lista1.insertFront(3);
        lista1.insertFront(2);
        lista1.insertFront(1);

        //tampoco estoy pensando en ordenar elementos que no sean integer, mmm
        SimpleList<Integer> lista2 = new SimpleList<>();
        lista2.insertFront(13);
        lista2.insertFront(12);
        lista2.insertFront(5);
        lista2.insertFront(4);
        lista2.insertFront(1);

        System.out.println(lista1);
        System.out.println(lista2);

//        ArrayList<Integer> arr = lista1.filtrarComunes(lista1,lista2);
//        System.out.println(arr);
        ArrayList<Integer> arr2 = lista2.getRestantes(lista1,lista2);
        System.out.println(arr2);
        //creamos un nuevo iterador y le pedimos el iterador de la lista1
//        Iterator<Integer> it = lista1.iterator();
//        while (it.hasNext()) {
//            Integer i = it.next();
//            System.out.println(i);
//        }
//
//        for(int i: lista1){
//            System.out.println(i);
//        }

//        System.out.println(lista1);
//        lista1.delete(2);
//        System.out.println(lista1);
//        lista1.delete(3);
//        System.out.println(lista1);
//        lista1.delete(0);
//        System.out.println(lista1);
//        lista1.insertEnd(5);
//        System.out.println(lista1);
//        lista1.insertFront(1);
//        System.out.println(lista1);
//        lista1.insert(3,2);
//        System.out.println(lista1);
//        System.out.println(lista1.indexOf(3));
    }

}
