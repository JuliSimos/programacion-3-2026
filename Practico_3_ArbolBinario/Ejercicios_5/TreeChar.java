package Practico_3_ArbolBinario.Ejercicios_5;

public class TreeChar {

    private char value;
    private TreeChar left;
    private TreeChar right;

    public TreeChar(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeChar getLeft() {
        return left;
    }

    public void setLeft(TreeChar left) {
        this.left = left;
    }

    public TreeChar getRight() {
        return right;
    }

    public void setRight(TreeChar right) {
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value){
        this.value = value;
    }

}
