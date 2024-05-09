import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] fibonacciZero = new int[50];
            int[] fibonacciOne = new int[50];
            fibonacciZero[0] = 1;
            fibonacciZero[1] = 0;
            fibonacciOne[0] = 0;
            fibonacciOne[1] = 1;
            
            for (int j = 2; j <= n; j++) {
                fibonacciZero[j] = fibonacciZero[j - 1] + fibonacciZero[j - 2];
                fibonacciOne[j] = fibonacciOne[j - 1] + fibonacciOne[j - 2];
            }
            
            System.out.println(fibonacciZero[n] + " " + fibonacciOne[n]);
        }
        
    }
}