package TP2.EJ7;

public class Quicksort {
    /*
    Mediante un pivote reordena el array, de manera que todo los elementos
    menores quedan a la izquierda y los mayores a la derecha
    Aplica esto recursivamente
    COMPLEJIDAD: O(n^2)
    CASO PROMEDIO: O(n log n)
    Si el pivote divide el array en  partes iguales, hay log n
    y cada nivel recorre n elementos
    Si el array es impar se generan desiguales y empeora a O(n^2)
    No requiere memoria auxiliar
    Depende de un pivote
    Implementa divide&conquer
     */
    private int[] arr;
    private int size;

    public void sort(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        quicksort(0, size - 1);
    }

    private void quicksort(int left, int right) {
        int i = left;
        int j = right;
        int p = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            quicksort(left, j);
        }
        if (i < right) {
            quicksort(i, right);
        }
    }

    private void exchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
