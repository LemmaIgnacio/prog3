package TP2.EJ3;

public class App {
    public static void main(String[] args) {
        transDecimalBinario(26); //hardcode
    }

    public static void transDecimalBinario(int n){//26
        if(n < 1) return;
        transDecimalBinario(n / 2);
        System.out.print(n % 2);
    }
}
