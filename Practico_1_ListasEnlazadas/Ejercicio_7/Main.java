package Practico_1_ListasEnlazadas.Ejercicio_7;

public class Main {
    public static void main(String[] args) {
        ListaVinculada<Integer> list = new ListaVinculada<>();
        list.insertFront(5);
        list.insertFront(2);
        list.insertFront(1);
        System.out.println(list);
        list.insert(2,3);
        //list.analizarNodos();
        System.out.println(list);
        list.insert(3,15);
        System.out.println(list);
        list.insert(0,39);
        System.out.println(list);
        System.out.println("Que hay en la posicion 4: " + list.get(4));
        System.out.println("ex primero: " + list.extractFirst());
        System.out.println(list);
        System.out.println(list.extractLast());
        System.out.println(list);

        System.out.println(list.indexOf(2));

        list.extractAtIndex(2);
        System.out.println(list);
        System.out.println("indice donde se encuentra el 2: " + list.indexOf(2));
        System.out.println("indice donde se encuentra el 15: " + list.indexOf(15));
        System.out.println(list);
        list.analizarNodos();




    }
}
