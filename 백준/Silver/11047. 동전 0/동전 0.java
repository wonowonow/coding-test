import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) {
                break;
            }
            
            if (K - coins[i] >= 0) {
                answer = answer + K / coins[i];
                K %= coins[i];
            }
        }
        
        System.out.print(answer);
    }
}