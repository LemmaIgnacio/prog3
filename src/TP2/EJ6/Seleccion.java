package TP2.EJ6;

public class Seleccion {
    public static void seleccion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <  n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }
    /*
    COMPLEJIDAD O(n^2)
    Recorre todo el array, busca el elemento minimo de la parte no odernada,
    lo intercambia con el elemento de la pos actual, repitiendo hasta terminar
    Repite aunque el array este ordenado
     */
}
