package TP2.EJ2;

public class App {
    public static void main(String[] args) {
        int [] arrOrdenado = new int[15];
        int ini = 0;
        int fin = arrOrdenado.length - 1;
        cargarArrOrdenado(arrOrdenado);
        mostrarArray(arrOrdenado);
        int e = (int) (Math.random()*20) + 1;
        System.out.println(" ");
        System.out.println("Buscando el elemento: " + e);
        System.out.println("El elemento se encuentra en la pos: " + buscarElemento(arrOrdenado, e, ini, fin));
        System.out.println("-1 en caso no encontrado");
    }

    public static int buscarElemento(int[] arr, int e, int ini, int fin){
        int medio;
        if(ini > fin){
            return -1;
        }
        medio = (ini + fin)/2;
        if (e > arr[medio]){
            return buscarElemento(arr,e,medio+1,fin);
        } else if (e < arr[medio]) {
            return buscarElemento(arr,e,ini,medio-1);
        }else {
            return medio;
        }
    }


    public static void cargarArrOrdenado(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
    }
    public static void mostrarArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print("[" + arr[i] + "]");
        }
    }
}
