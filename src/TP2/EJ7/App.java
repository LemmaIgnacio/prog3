package TP2.EJ7;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr2 = {6, 5, 3, 1, 8, 7, 2, 4};


        System.out.println("MERGESORT:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        MergeSort ms = new MergeSort();
        ms.sort(arr);
        System.out.println(" ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println(" ");
        System.out.println("QUICKSORT:");
        for (int j : arr2) {
            System.out.print(j + " ");
        }
        Quicksort qs = new Quicksort();
        qs.sort(arr2);
        System.out.println(" ");
        for (int j : arr2) {
            System.out.print(j + " ");
        }
    }
}
