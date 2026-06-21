package Practico_1_ListasEnlazadas.Ejercicio_1;

import java.util.Iterator;

// implementa a la interfaz interator de Java
/*
    La interfaz tiene 2 metodos principales
    - hasNext() -> cuando hay un nodo siguiente para poder recorrer
    - next() -> devolver el valor de ese nodo

 */
public class MyIterator<T> implements Iterator<T> {
    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        // recibimos el primer nodo de la lista
        this.cursor = cursor;
    }
    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }
    public T valor(){
        return  this.cursor.getInfo();
    }
}
