package TP2.EJ5;

public class App {
    public static void main(String[] args) {
        int [] arrOrdenado = {-3, -1, 0, 2, 4, 6, 10};
        int ini = 0;
        int fin = arrOrdenado.length - 1;
        System.out.println("Existe un indice de igual valor que un elemento: " + existeIndiceIgualValor(arrOrdenado, ini, fin));
    }

    public static boolean existeIndiceIgualValor(int[] arr, int ini, int fin){
        int medio;
        if(ini > fin){
            return false;
        }
        medio = (ini + fin)/2;
        if (arr[medio] < medio){
            return existeIndiceIgualValor(arr,medio+1,fin);
        } else if (arr[medio] > medio) {
            return existeIndiceIgualValor(arr,ini,medio-1);
        }else {
            return true;
        }
    }
    /*
    pila:
        existeIndiceIgualValor(arr, 4, 4)
        existeIndiceIgualValor(arr, 4, 6)
        existeIndiceIgualValor(arr, 0, 6)
        main
     */
}
