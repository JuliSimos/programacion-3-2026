package Practico_1_ListasEnlazadas.Ejercicio_7;


public class ListaVinculada<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    public ListaVinculada(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.first == null;
    }
    public int size(){
        return this.size;
    }
/*
Ejercicio 1
 * Implemente los métodos indicados del esqueleto:
 * void insertFront(T), x
 * T extractFront(),    x
 * boolean isEmpty(),   x
 * int size(),          x
 * String toString).    x
 * Agregar también el metodo: T get(index).
 */
    public void insertFront(T data){
        Node<T> nuevoNode = new Node<>(data);
        if(this.isEmpty()){
            this.first = nuevoNode;
            this.last = nuevoNode;
        }else{
            nuevoNode.setNext(this.first);
            this.first.setPrevious(nuevoNode);
            this.first = nuevoNode;
        }
        this.size++;
    }
    public T extractFront(){
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return info;
    }
    public T extractFirst(){
        if(this.isEmpty()){
            return null;
        }
        T info = this.first.getInfo();
        if(this.size == 1){
            this.first = null;
            this.last = null;
        }else{
            this.first = this.first.getNext();
            this.first.setPrevious(null);
        }
        this.size--;
        return info;
    }
    public T extractLast(){
        if(this.isEmpty()){
            return null;
        }
        T info =  this.last.getInfo();
        if(size == 1){
            this.last = null;
            this.first = null;
        }else{
            this.last = this.last.getPrevious();
            this.last.setNext(null);
        }
        this.size--;
        return info;
    }
    public int indexOf(T data){
        if(!this.isEmpty()){
            int i = 0;
            Node<T> tmp = this.first;
            while(tmp != null){
                if(tmp.getInfo().equals(data)){
                    return i;
                }
                tmp = tmp.getNext();
                i++;
            }
        }
        return -1;
    }
    /** Esta mal implementado indexOf
    public int indexOf(T info){
        int pos = -1;
        if(this.isEmpty()){
            return pos;
        }
        if(this.first.getInfo().equals(info)){
            return pos+1;
        }else{
            Node<T> tmp = this.first;
            while(tmp != null){
                if(tmp.getInfo().equals(info)){
                    return pos;
                }
                tmp = tmp.getNext();
                pos++;
            }
        }
        return pos+1;
    }
     */
    @Override
    public String toString() {
        String rta = "";
        Node<T> tmp = this.first;
        while (tmp != null) {
            rta += tmp.getInfo();
            tmp = tmp.getNext();
            if (tmp != null) {
                rta += ", ";
            }
        }
        return rta;
    }
    public void insertLast(T data){
        Node<T> nuevoNode = new Node<>(data);
        if(this.isEmpty()){
            this.first = nuevoNode;
            this.last = nuevoNode;
        }else{
            this.last.setNext(nuevoNode);
            nuevoNode.setPrevious(this.last);
            this.last = nuevoNode;
        }
        size++;
    }
    public void insert(int index, T data){
        Node<T> nuevo = new Node<>(data);
        if(index >= 0 && index <= this.size){
            if(index == 0){
                insertFront(data);
                return;
            }else if(index == this.size-1) {
                System.out.println("Tamaño de la lista" + this.size);
                Node<T> aux = this.last.getPrevious();
                aux.setNext(nuevo);
                nuevo.setPrevious(aux);
                nuevo.setNext(this.last);
                this.last.setPrevious(nuevo);
            }else{
                Node<T> temp = this.first;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                }
                System.out.println(temp.getInfo());
                Node<T> anterior = temp;
                Node<T> posterior = temp.getNext();

                nuevo.setPrevious(anterior);
                nuevo.setNext(posterior);

                anterior.setNext(nuevo);
                posterior.setPrevious(nuevo);
            }
        }
        size++;
    }
    //optimizar get
    public T get(int index){
        Node<T> tmp = this.first;
        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }
    public T getData(int index) {
        // 1. Validar rango: el índice máximo permitido es size - 1
        if (index < 0 || index >= this.size || this.isEmpty()) {
            return null;
        }

        // 2. Casos directos
        if (index == 0) return this.first.getInfo();
        if (index == this.size - 1) return this.last.getInfo();

        Node<T> aux;

        // 3. Búsqueda optimizada
        if (index < this.size / 2) {
            aux = this.first;
            // Queremos llegar al nodo 'index', así que saltamos 'index' veces
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        } else {
            aux = this.last;
            // Queremos retroceder desde el final (size-1) hasta el index
            for (int i = this.size - 1; i > index; i--) {
                aux = aux.getPrevious();
            }
        }

        return aux.getInfo();
    }
    public T getInfo(int index){
        T data = null;
        if(index >= 0 && index < this.size){
            if(!this.isEmpty()) {
                if (index == 0) {
                    return this.first.getInfo();
                }if (index == this.size-1) {
                    return this.last.getInfo();
                }
                if (index < this.size / 2) {
                    Node<T> tmp = this.first;
                    for (int i = 0; i <= index; i++) {
                        tmp = tmp.getNext();
                        System.out.println("iterando: " + tmp.getInfo());
                        System.out.println("indice: " + i);


                    }
                    data = tmp.getInfo();
                    System.out.println(data);
                } else {
                    Node<T> point = this.last;
                    for (int i = this.size - 1; i >= index; i--) {
                        point = point.getPrevious();
                    }
                    data = point.getInfo();
                }
            }
        }
        return data;
    }

    public void extractAtIndex(int index){
        //Extrae un elemento dada una posicion, seria el eleminar
        if(index >= 0 && index < this.size){
            if(!this.isEmpty()){
                if(index == 0){
                    this.extractFirst();
                }else if(index == this.size-1){
                    this.extractLast();
                }else{
                    Node<T> tmp = this.first;
                    for(int i = 0; i < index; i++){
                        tmp = tmp.getNext();
                    }
                    Node<T> anterior = tmp.getPrevious();
                    Node<T> posterior = tmp.getNext();
                    anterior.setNext(posterior);
                    posterior.setPrevious(anterior);
                }
            }
        }
    }


    public void analizarNodos() {
        Node<T> point = this.first;
        StringBuilder rta = new StringBuilder("[ "); // StringBuilder es más eficiente para esto

        while (point != null) {
            // Obtenemos los valores de forma segura (manejando los nulls)
            String prevVal = (point.getPrevious() != null) ? point.getPrevious().getInfo().toString() : "null";
            String nextVal = (point.getNext() != null) ? point.getNext().getInfo().toString() : "null";
            String actualVal = point.getInfo().toString();

            rta.append(String.format("(Prev: %s | Info: %s | Next: %s) ", prevVal, actualVal, nextVal));

            if (point.getNext() != null) {
                rta.append(" <-> ");
            }

            point = point.getNext(); // ¡Ahora sí dentro del bucle!
        }

        rta.append(" ]");
        System.out.println(rta.toString());
    }

}
