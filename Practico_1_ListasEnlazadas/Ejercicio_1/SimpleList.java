package Practico_1_ListasEnlazadas.Ejercicio_1;
/*
Ejercicio 1
 * Implemente los métodos indicados del esqueleto:
 * void insertFront(T),
 * T extractFront(),
 * boolean isEmpty(),
 * int size(),
 * String toString).
 * Agregar también el metodo: T get(index).
 */


import java.util.*;

/*
Ejercicio 3
Implementar int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
elemento, o -1 si el elemento no existe en la lista.

 */
public class SimpleList<T extends Comparable<T>> implements  Iterable<T>{
    // Nodo cabecera
    private Node<T> first;
    private int size;

    public SimpleList() {
        //declaro como null al primer nodo
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        this.first = new Node<>(info,this.first);
        this.size++;
    }

    public T extractFront() {
        // Guardar la variable que quiero retornar
        //convertir en front al next
        T tmp = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return tmp;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }
        Node<T> tmp = this.first;
        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> tmp = this.first;
        while (tmp != null) {
            str += tmp.getInfo();
            tmp = tmp.getNext();
            if (tmp != null) {
                str += ", ";
            }
        }
        return str;
    }
    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        // Caso especial: Borrar el primero
        if (index == 0) {
            this.first = this.first.getNext();
        }
        // Caso general: Borrar cualquier otro
        else {
            Node<T> tmp = this.first;
            // Navegamos hasta el ANTERIOR al que queremos borrar
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }

            // El nodo a eliminar es el siguiente de tmp
            Node<T> aBorrar = tmp.getNext();
            // Hacemos el "puente": saltamos el nodo aBorrar
            tmp.setNext(aBorrar.getNext());

            // Opcional: limpiar la referencia del nodo eliminado
            aBorrar.setNext(null);
        }

        this.size--;
    }
    public void insertEnd(T info){
        Node<T> nuevo =  new Node<>(info,null);
        Node <T> tmp = this.first;
        while (tmp.getNext() != null){
            tmp = tmp.getNext();
        }
        tmp.setNext(nuevo);
    }
    public void insert (T info, int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        Node<T> tmp = this.first;
        for(int i = 0; i < index -1; i++){
            tmp = tmp.getNext();
        }
        System.out.println("Hasta aca llego: " + tmp);
        Node<T> nuevo =  new Node<>(info,tmp.getNext());
        tmp.setNext(nuevo);

    }

    public int indexOf(T info){
        Node<T> tmp = this.first;
        int index = 0;
        while (tmp != null){
            if(tmp.getInfo().equals(info)){
                return index;
            }
            tmp = tmp.getNext();
            index++;
        }
        return -1;
    }

    @Override
    //metodo que permite que nuestra lista sera iterable al implementar la interfaz Iterator
    public Iterator<T> iterator() {
        //cuando se llame a este metodo se crea un iterador al que se le pasa el primer nodo de la lista
        return new MyIterator<>(this.first);
    }
    /*
Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
complejidad computacional contra un array en las siguientes operaciones:
1. Insertar al principio
    - Lista Vinculada: O(1)
    - Array: O(1)
2. Buscar un elemento en una posición
    - Lista Vinculada: O(n)
    - Array: O(n)
3. Determinar la cantidad de elementos
    - Lista Vinculada: O(1) -> se agrego una variable "size" para mantener acualizado el tamaño de la lista
    - Array: O(1)
4. Borrar un elemento de una posición determinada
    - Lista Vinculada: O(n)
    - Array: O(n)

     */
    public Node<T> getFirst() {
        return this.first;
        //siento que esta mal, estoy dando mi nodo, me lo pueden modificar
    }
    public boolean contiene(T data){
        Node<T> tmp = this.first;
        while(tmp != null){
            if(tmp.getInfo().equals(data)){
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }
    //con Listas desordenadas
    public ArrayList<T> filtrarComunes(SimpleList<T> lista1, SimpleList<T> lista2){
        ArrayList<T> listUnion = new ArrayList<>();
        Node<T> point = lista1.getFirst();

        while(point != null){
            T data = point.getInfo();
            System.out.println("Lista 2 contiene " + data + " = " + lista2.contiene(data));
            if(lista2.contiene(data)){
                listUnion.add(data);
            }
            point = point.getNext();
        }
        Collections.sort(listUnion);
        return listUnion;
    }
    //con listas ordenadas
    //si estan ordenadas, al comparar el primer elemento con el segundo de la lista,
    //puedo saber si van a haber mas oportunidades de encontrarlo
    //la lista1 viene desordenada y la lista2 viene ordenada
    public ArrayList<T> ordenarComunes(SimpleList<T> lista1, SimpleList<T> lista2){
        MyIterator<T> iter1 = new  MyIterator<>(lista1.getFirst());
        MyIterator<T> iter2 = new  MyIterator<>(lista2.getFirst());

        ArrayList<T> list = new ArrayList<>();
        while(iter1.hasNext()){
             if(iter2.hasNext()){
                 if(iter1.valor().equals(iter2.valor())){
                     list.add(iter1.valor());
                 }

             }
        }
        return list;
    }

    public ArrayList<T> obtenerElemComunes(SimpleList<T> list1, SimpleList<T> list2){
        ArrayList<T> listFinal = new ArrayList<>();
        MyIterator<T> iter1 = new  MyIterator<>(list1.getFirst());
        MyIterator<T> iter2 = new  MyIterator<>(list2.getFirst());
        System.out.println("Negativo: si el objeto actual es menor que el argumento.\n" +
                " Cero: si son iguales.\n" +
                " Positivo: si el objeto actual es mayor que el argumento." );


        while(iter1.hasNext() && iter2.hasNext()){
            T it1 = iter1.valor();
            T it2 = iter2.valor();
            int compare = it1.compareTo(it2);

            System.out.println("iter1: " +  it1);
            System.out.println("iter2: " +  it2);
            System.out.println("rta compare: " +  compare);

            if(compare > 0){
                //it1 es mayor a it2
                iter2.next();
                System.out.println("iter2 avanza 1 = " +  it2);
            }
            if(compare < 0){
                //it1 es menor a it2
                iter1.next();
                System.out.println("iter1 avanza 1 = " +  it1);
            }
            if(compare == 0){
                //it1 es igual a it2
                listFinal.add(it1);
                iter1.next();
                iter2.next();
            }
        }
        return listFinal;
    }
    public ArrayList<T> getRestantes(SimpleList<T> list1,  SimpleList<T> list2){
        ArrayList<T> listFinal = new ArrayList<>();
        MyIterator<T> iter1 = new  MyIterator<>(list1.getFirst());
        MyIterator<T> iter2 = new  MyIterator<>(list2.getFirst());
        System.out.println("Negativo: si el objeto actual es menor que el argumento.\n" +
                " Cero: si son iguales.\n" +
                " Positivo: si el objeto actual es mayor que el argumento." );


        while(iter1.hasNext() && iter2.hasNext()){
            T it1 = iter1.valor();
            T it2 = iter2.valor();
            int compare = it1.compareTo(it2);

//            System.out.println("iter1: " +  it1);
//            System.out.println("iter2: " +  it2);
//            System.out.println("rta compare: " +  compare);

            if(compare > 0){
                //it1 es mayor a it2
                iter2.next();
                //System.out.println("iter2 avanza 1 = " +  it2);
            }
            if(compare < 0){
                //it1 es menor a it2
                //System.out.println("Agregoo : " + it1);
                listFinal.add(it1);
                iter1.next();
                //System.out.println("iter1 avanza 1 = " +  it1);
            }
            if(compare == 0){
                //it1 es igual a it2
                iter1.next();
                iter2.next();
            }
        }
        //System.out.println("iter2.hasNext() = " +  iter2.hasNext());
        //Es al pedo esto, porque el enunciado decia que tenia que retornar:
        // - los elementos que solo esten en la primera lista, los que sean iguales a la segunda o qeu solo pertenezcan a la segunda se pasan por alto
//        while(iter2.hasNext()){
//            //System.out.println("iter2 = " +  iter2.valor());
//            listFinal.add(iter2.valor());
//            iter2.next();
//        }
        return listFinal;
    }
}

