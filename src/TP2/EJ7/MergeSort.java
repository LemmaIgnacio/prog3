package TP2.EJ7;

public class MergeSort {
    /*
    Divide el array en dos mitades, cada mitad se ordena con recursion
    Se combinan en un unico array ordenado
    Utiliza un array auxiliar para ordenar
    COMPLEJIDAD: O(n log n)
    CASO PROMEDIO: O(n log n):
    El array se divide en mitades en cada llamada -> log de n
    Cada nivel se recorre todos los elementos -> n
    No depende del orden inicial del Array
    Requiere memoria auxiliar
    Prinicipio de divie&conquer
     */
    private int[] numbers;
    private int[] helper;
    private int size;

    public void sort(int[] values) {
        this.numbers = values;
        this.size = values.length;
        this.helper = new int[size];
        mergesort(0, size - 1);
    }

    private void mergesort(int low, int high) {
        // si low es menor que high, continua el ordenamiento
        // si no, es el caso base: un solo elemento
        if (low < high) {
            int middle = (low + high) / 2;

            // ordenar la mitad izquierda
            mergesort(low, middle);

            // ordenar la mitad derecha
            mergesort(middle + 1, high);

            // combinar ambas mitades ordenadas
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // copiar ambas partes al arreglo auxiliar
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // copiar de manera ordenada al arreglo original
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // copiar los elementos restantes de la mitad izquierda
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

        // copiar los elementos restantes de la mitad derecha
        while (j <= high) {
            numbers[k] = helper[j];
            k++;
            j++;
        }
    }
}
