package TP2.EJ1;

public class App {
    final static int MAX = 10;
    public static void main(String[] args) {
        int [] arrOrdenado = new int[MAX];
        int [] arrDesordenado = new int[MAX];
        cargarArrOrdenado(arrOrdenado);
        cargarArrDesordenado(arrDesordenado);
        System.out.println("El array 1 esta ordenado: " + estaOrdeanado(arrOrdenado));
        System.out.println("El array 2 esta ordenado: " + estaOrdeanado(arrDesordenado));
        System.out.println(" ");
        System.out.println("Forma recursiva: ");
        System.out.println("El array 1 esta ordenado: " + estaOrdeanadoRec(arrOrdenado, 0));
        System.out.println("El array 2 esta ordenado: " + estaOrdeanadoRec(arrDesordenado, 0));
    }

    public static boolean estaOrdeanadoRec(int[] arr, int i) {
        if (i >= MAX - 1){
            mostrarArray(arr);
            return true;
        }else if (arr[i] > arr[i+1]){
            mostrarArray(arr);
            return false;
        }else{
            return estaOrdeanadoRec(arr, i+1);
        }
    }

    //forma iterativa
    public static boolean estaOrdeanado(int [] arr){
        mostrarArray(arr);
        int i = 0;
        while (i < MAX - 1){
            if (arr[i] > arr[i+1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static void mostrarArray(int[] arr) {
        for (int i = 0; i < MAX; i++){
            System.out.print("[" + arr[i] + "], ");
        }
    }

    public static void cargarArrOrdenado(int[] arr){
        for (int i = 0; i < MAX; i++){
            arr[i] = i+1;
        }
    }
    public static void cargarArrDesordenado(int[] arr){
        for (int i = 0; i < MAX; i++){
            arr[i] = (int) (Math.random() * 99) + 1;
        }
    }


}
