package Practico_3_ArbolBinario;

import java.util.ArrayList;
import java.util.List;

/*
Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(),
void add(Integer), boolean delete(Integer), int getHeight(),
void printPosOrder(), void printPreOrder(), void printInOrder(),
List getLongestBranch(), List getFrontera(), Integer getMaxElem(),
List getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?
 */
public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public Integer getRoot() {
        return this.root.getValue();
    }

    public boolean hasElem(Integer value) {
        return hasElem(this.root, value);
    }

    private boolean hasElem(TreeNode actual, Integer value) {
        if (actual == null) return false;
        if (actual.getValue().equals(value)) return true;
        if (actual.getValue() > value) {
            return hasElem(actual.getLeft(), value);
        } else if (actual.getValue() < value) {
            return hasElem(actual.getRight(), value);
        }
        return false;
    }

    public void imprimirPreOrden() {
        this.imprimirPreOrden(this.root);
    }

    private void imprimirPreOrden(TreeNode nodo) {
        if (nodo == null)
            return;
        System.out.print(nodo.getValue() + " ");
        imprimirPreOrden(nodo.getLeft());
        imprimirPreOrden(nodo.getRight());
    }

    public void imprimirEnOrden() {
        this.imprimirEnOrden(this.root);
    }

    private void imprimirEnOrden(TreeNode nodo) {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        imprimirEnOrden(nodo.getRight());
    }

    public void imprimirPosOrden() {
        this.imprimirPosOrden(this.root);
    }

    private void imprimirPosOrden(TreeNode nodo) {
        if (nodo == null)
            return;
        imprimirPosOrden(nodo.getLeft());
        imprimirPosOrden(nodo.getRight());
        System.out.print(nodo.getValue() + " ");
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    private int getHeight(TreeNode actual) {
        /** primer intento
         if(actual == null) return 0;
         int alturaizq = 1 + getHeight(actual.getLeft());
         int alturader = 1 + getHeight(actual.getRight());
         if(alturaizq > alturader){
         return alturaizq;
         }else {
         return alturader;
         }
         **/
        //(El -1 compensa el primer +1 de la raíz, dejando la raíz en 0)
        //Esto para que el nivel coincida con la altura
        if (actual == null) return -1;
        return 1 + Math.max(getHeight(actual.getLeft()), getHeight(actual.getRight()));
    }

    public int getCantNodos() {
        return this.cantNodos(this.root);
    }

    private int cantNodos(TreeNode actual) {
        return (actual == null) ? 0 : 1 + cantNodos(actual.getLeft()) + cantNodos(actual.getRight());
        /**
         * return 1 + cantNodos(actual.getLeft()) + cantNodos(actual.getRight())
         */
    }

    public Integer getMaxElem() {
        //tengo que considerar si la lista esta vacia
        return (this.root == null) ? -1 : getMaxElem(this.root);
    }
    //el elemento máximo es el que está más a la derecha de todo
    //No necesito comparar contra un max en cada paso

    /**
     * private Integer getMaxElem(TreeNode actual, int max){
     * if(actual == null) return max;
     * if(actual.getValue() > max){
     * max = actual.getValue();
     * }
     * return getMaxElem(actual.getRight(), max);
     * }
     **/
    private Integer getMaxElem(TreeNode actual) {
        if (actual.getRight() == null) return actual.getValue();
        return getMaxElem(actual.getRight()); // Seguí buscando a la derecha
    }

    public List<Integer> getFrontera() {
        List<Integer> list = new ArrayList<>();
        return getFrontera(this.root, list);
    }

    private List<Integer> getFrontera(TreeNode actual, List<Integer> list) {
        if (actual == null) return list;
        if (actual.getLeft() == null && actual.getRight() == null)
            list.add(actual.getValue());

        getFrontera(actual.getLeft(), list);
        getFrontera(actual.getRight(), list);
        return list;
    }

    public List getElemAtLevel( int k) {
        if(k > getHeight()) return new ArrayList();
        return getElemAtLevelRecu(this.root, k);
    }

    private List<Integer> getElemAtLevelRecu(TreeNode actual, int k) {
        if(actual == null || k < 0) return new  ArrayList();

        if(k == 0){
            List<Integer> list = new ArrayList<>();
            list.add(actual.getValue());
            return list;
        }
        List<Integer>  solucion = getElemAtLevelRecu(actual.getRight(), k - 1);
        solucion.addAll(getElemAtLevelRecu(actual.getLeft(), k -1));

        return solucion;
    }
    public boolean existeCamino(int D){
        if(this.root == null) return false;
        return existeCaminoRecu(this.root, 0, D);

    }
    private boolean existeCaminoRecu(TreeNode actual, int suma, int D){
        if(actual == null) return false;
        if(actual.getLeft() == null && actual.getRight() == null){
            return suma + actual.getValue() == D;
        }
        return existeCaminoRecu(actual.getLeft(), suma + actual.getValue(), D) ||
        existeCaminoRecu(actual.getRight(), suma + actual.getValue(), D);
    }

    public List<Integer> getLongestBranch() {
        return getLongestBranch(this.root);
    }

    private List<Integer> getLongestBranch(TreeNode actual) {
        if (actual == null) return new ArrayList<>();

        List<Integer> left = getLongestBranch(actual.getLeft());
        List<Integer> right = getLongestBranch(actual.getRight());

        if (left.size() > right.size()) {
            left.addFirst(actual.getValue());
            return left;
        } else {
            right.addFirst(actual.getValue());
            return right;
        }
    }

    /* METODOS IMPORTANTES PARA AGREGAR:
    borrar(p_raíz, x). Remueve el nodo que tiene clave x
     */
    public void delete(Integer valor) {
        this.delete(this.root, valor);
    }

    private TreeNode delete(TreeNode actual, Integer valor) {
        if (actual == null) return null;
        //primero lo tengo que buscar
        //los elementos estan ordenados
        if (actual.getValue() > valor) {
            actual.setLeft(delete(actual.getLeft(), valor));
        } else if (actual.getValue() < valor) {
            actual.setRight(delete(actual.getRight(), valor));
            //busco por derecha
        }else{
            //encontre el nodo
            if (actual.getLeft() == null) return actual.getRight();
            if (actual.getRight() == null) return actual.getLeft();
            //o si es padre de dos hijos
            Integer NMISD = this.getMinValue(actual.getRight());
            actual.setValue(NMISD);
            actual.setRight(delete(actual.getRight(), NMISD));
        }
        return actual;


    }
    private Integer getMinValue(TreeNode actual){
        if(actual.getLeft() == null) return actual.getValue();
        return getMinValue(actual.getLeft());
    }
    private Integer getMaxValue(TreeNode actual){
        if(actual.getRight() == null) return actual.getValue();
        return getMaxValue(actual.getRight());
    }

    /* Ejercicio 3
    Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
que retorne la suma de todos los nodos internos del árbol.

     */
    public int sumatoriaNodos(){
        return sumatoria(this.root);
    }
    private int sumatoria(TreeNode actual){
        if(actual == null) return 0;
        // recien me di cuenta que el enunciado pide nodos internos. Asi que voy a tener que escluir las hojas
        if(actual.getLeft() == null && actual.getRight() == null) return 0;
        return actual.getValue() + sumatoria(actual.getLeft()) + sumatoria(actual.getRight());
    }
    /*
    Dado un árbol binario de búsqueda que almacena números
enteros y un valor de entrada K, implementar un algoritmo
que permita obtener un listado con los valores de todas las
hojas cuyo valor supere K. Por ejemplo, para el árbol de la
derecha, con un valor K = 8, el resultado debería ser [9, 11].
     */
    public List<Integer> hojasmayores(Integer valor) {

        return hojasMayoresA(this.root, valor);
    }
    public List<Integer> hojasMayoresA(TreeNode actual, Integer K){
        //en realidad no tengo que buscar numero, tengo que avanzar hasta encontrar hojas
        if(actual == null) return new ArrayList<>();
        if(actual.getLeft() == null && actual.getRight() == null) {
            if(actual.getValue() > K){
                System.out.println(actual.getValue());
                List<Integer> list = new ArrayList<>();
                list.add(actual.getValue());
                return list;
            }
        }
        List<Integer> list = hojasMayoresA(actual.getLeft(), K);
        list.addAll(hojasMayoresA(actual.getRight(), K));

        return list;
    }
    public void acomodarValores(){
        this.acomodarValores(this.root);
    }
    private Integer acomodarValores(TreeNode actual){
        if(actual == null) return 0;
        if(actual.getLeft() == null && actual.getRight() == null) return actual.getValue();
        actual.setValue( acomodarValores(actual.getRight()) - acomodarValores(actual.getLeft()));
        return actual.getValue();
    }
    public List<Integer> getRango(int L, int R){
        if(L < 0 || R < 0 || L > R) return new ArrayList<>();
        return buscarValoes(this.root, L, R, 0);
    }
    public List<Integer> buscarValoes(TreeNode actual, int L, int R, int nivel){
        if(actual == null || nivel > R) return new ArrayList<>();

        if(nivel >= L && nivel <= R){
            List<Integer> lista = new ArrayList<>();
            lista.add(actual.getValue());
            return lista;
        }
        List<Integer> izq = buscarValoes(actual.getLeft(), L, R, nivel + 1);
        izq.addAll(buscarValoes(actual.getRight(), L, R, nivel + 1));
        return izq;
    }

}

