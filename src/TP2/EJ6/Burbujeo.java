package TP2.EJ6;

public class Burbujeo {

    public static void burbujeo(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }
    /*
    COMPLEJIDAD O(n^2)
    Recorre el array, compara elementos adyecentes y los intercambia si estan desordenados
    (arr(j) > arr(j+1), al final el mayor queda al final.
    No corta antes anque el array este ordenado
     */

    // /////////////////////////

    public void burbujeoMejorado(int [] arr){
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i=0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
/*
    COMPLEJIDAD: O(n^2)

    MEJORAS: si en una pasada no hay cambios, corta
    mediante un boolean que vuelve true si hubo intercambios,
    en caso de no haberlos, se mantiene false y corta anticipadamente
 */
