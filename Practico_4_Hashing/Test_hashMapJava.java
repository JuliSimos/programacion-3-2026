package Practico_4_Hashing;

import java.util.HashMap;

public class Test_hashMapJava {
    public static void main(String[] args) {
        HashMapJava mapaHash = new HashMapJava();
        mapaHash.add("Mesa", 5);
        mapaHash.add("Silla", 4);
        mapaHash.add("Alacena", 1);
        mapaHash.getMap();
        HashMap<String, Integer> palabras = mapaHash.getMapPalabras("hola hola chau hola chau mundo");
//        for(String k: palabras.keySet()){
//            System.out.println(k + ": " + palabras.get(k));
//        }
        System.out.println(mapaHash.getWordMoreRepit("hola hola chau hola chau mundo"));

    }
}
