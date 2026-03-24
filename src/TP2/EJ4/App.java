package TP2.EJ4;

public class App {
    public static void main(String[] args) {
        secFibonacci(15,0,1);
        System.out.println(" ");
        System.out.println(" --- ");
        for (int i = 0; i < 15; i++){
            System.out.print(fibonacchi(i) + " " );
        }
    }
    //O(n)
    public static void secFibonacci(int ite,int ant1, int ant2){
        if (ite == 0) {
            return;
        }
        System.out.print(ant1 + " ");
        secFibonacci(ite - 1, ant2, ant1+ant2);
    }
    //complejidad computacional O(2^n)
    public static int fibonacchi(int n){
        if (n < 2){
            return n;
        }
        return fibonacchi(n-1) + fibonacchi(n-2);
    }
}
