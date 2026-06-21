package Practico_4_Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HashMapJava {
    private HashMap<String, Integer> map;

    public HashMapJava(){
        map = new java.util.HashMap<>();
    }
// metodo para agregar y actualizar valores sin pisarlos
    public void add(String p, Integer nro){
        if(map.containsKey(p)){
            map.put(p, map.get(p)+nro);
        }else
            map.put(p, nro);
    }
    public void getMap(){
        for(String p : map.keySet()){
            System.out.println(p += ": " + map.get(p));
        }
    }
    public void Recorrido(Integer limite){
        // A. Solo las CLAVES (keySet)
        for (String clave : map.keySet()) {
            System.out.println("Clave: " + clave);
        }

        // B. Solo los VALORES (values)
        for (Integer valor : map.values()) {
            System.out.println("Valor: " + valor);
        }

//        // C. CLAVE y VALOR juntos (entrySet) -> El más eficiente
//        for (map.Entry<String, Integer> entrada : map.entrySet()) {
//            System.out.println(entrada.getKey() + " vale " + entrada.getValue());
//        }
    }

    public HashMap<Integer, String> getInvertedMap(){
        HashMap<Integer, String> invertedMap = new HashMap<>();
        for(String p : map.keySet()){
            invertedMap.put(map.get(p), p);
        }
        return invertedMap;
    }
    public void borrarValoresBajos(Integer limite) {
        Iterator<String> it = map.keySet().iterator(); // El iterador recorre las claves

        while (it.hasNext()) {
            String clave = it.next();
            // Usamos map.get(clave) para chequear la condición
            if (map.get(clave) < limite) {
                it.remove(); // El iterador borra la clave y el valor del mapa automáticamente
            }
        }
    }
    public HashMap<String, Integer> getMapPalabras(String txt){
        //genero un arreglo con las palabras
        HashMap<String,Integer> mapP = new HashMap<>();
        String[] palabras = txt.split("\\s+"); //separa por cualquier cantidad de espacios/blancos.
        for(String p: palabras){
            /**
             Si la clave NO existe → inserta value (1)
             Si existe → combina el valor actual con el nuevo
             */
            mapP.merge(p, 1, Integer::sum);
            /*Antes
                if(mapP.containsKey(p)) {
                    mapP.put(p, mapP.get(p) + 1);
                   } else {
                        mapP.put(p, 1);
                }
             */
        }
        mapP.entrySet().removeIf(entry -> entry.getValue() == 1);


        return mapP;
    }
    public String getWordMoreRepit(String txt){
        //isBlank(): Returns true for "" and " ".
        if (txt == null || txt.isBlank()) return null;

        //genero un arreglo con las palabras
        HashMap<String,Integer> mapP = new HashMap<>();
        String[] palabras = txt.split("\\s+"); //separa por cualquier cantidad de espacios/blancos.

        for(String p: palabras){
            mapP.merge(p, 1, Integer::sum);
        }

        int max = 0;
        String repetida = null; // mejor que "", porque semánticamente indica “no hay valor"

        for(Map.Entry<String, Integer> entry: mapP.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                repetida = entry.getKey();
            }
        }
        /*
        return mapP.entrySet() -> tenés (palabra, cantidad)
           .stream() -> lo convertís en “flujo” de datos
           .max(Map.Entry.comparingByValue()) -> Java busca el mayor / comparingByValue() → le decís “compará por la cantidad”
           .map(Map.Entry::getKey) -> te quedás solo con la palabra
           .orElse(null); → por si está vacío
         */
        return repetida;

    }



}
