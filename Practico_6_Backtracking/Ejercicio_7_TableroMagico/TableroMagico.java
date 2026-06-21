package Practico_6_Backtracking.Ejercicio_7_TableroMagico;

import java.util.ArrayList;

public class TableroMagico {
    private int[][] tableroMagico;
    private int s; // limite sume para cada fila y columna
    private int k; //limite de candidatos, debe ser mayor a n*n
    private int size;
    private int n;
    private ArrayList<Integer> nrosUsados;

    public TableroMagico(int n, int s, int k){
        this.tableroMagico = new int[n][n];
        this.s = s;
        this.n = n;
        this.size = n*n;
        this.nrosUsados = new ArrayList<>();
        if(k > size) this.k = k; //no manejo si da error
    }
    public int[][] rellenarMatriz(){
        this.tableroMagico = new int[n][n];
        this.nrosUsados.clear();
        int[] sumaF = new int[n];
        int[] sumaC = new int[n];
        int[][] matrizParcial = new int[n][n];
        rellenar(0,0, sumaF, sumaC, matrizParcial);
        return this.tableroMagico;
    }

    private void rellenar(int f, int c, int[] sumaF, int[] sumaC, int[][] matrizParcial){
        if(f == n && c == n){
            if(nrosUsados.size() == size) {
                this.tableroMagico = matrizParcial;
                return;
            }
        }
        if(f < n && c < n){
            for(int opc = 1; opc <= k; opc++){
                //si no supera la suma individual de cada fila que se trabaja, se prueba
                if(((sumaF[f] + opc) < this.s) && ((sumaC[c] + opc) < this.s)){

                    if(!nrosUsados.contains(opc) &&
                            (sumaC[c] + opc < this.s) &&
                            (sumaF[f] + opc < this.s)){

                        if((f == n-1 && c == n-1) && (sumaC[c] + opc != this.s)){
                            //probar otro candidato
                        }
                        if((f == n-1)&& !(sumaF[f] + opc == this.s)){
                            //probar otro candidato
                        }

                        this.nrosUsados.add(opc);
                        matrizParcial[f][c] = opc;
                        sumaF[f] += opc;
                        sumaC[c] += opc;
                        int sigF = f;
                        int sigC = c;

                        if(f < n-1 && c == n-1){
                            sigF = f + 1;
                            sigC = 0;
                        }else{
                            sigC = c + 1;
                        }
                        rellenar(sigF,sigC,sumaF,sumaC,matrizParcial);

                        nrosUsados.remove(opc);
                        sumaF[f] -= opc;
                        sumaC[c] -= opc;
                        matrizParcial[f][c] = 0;

                    }
                }

            }
        }
    }
}
