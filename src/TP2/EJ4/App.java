package TP2.EJ4;

public class App {
    public static void main(String[] args) {
        secFibonacci(15,0,1);
    }

    public static void secFibonacci(int ite,int ant1, int ant2){
        if (ite == 0) {
            return;
        }
        System.out.print(ant1 + " ");
        secFibonacci(ite - 1, ant2, ant1+ant2);
    }
}
