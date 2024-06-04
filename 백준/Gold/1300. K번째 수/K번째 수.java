import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 0;
        long end = K;
        long answer = 0;
        
        while (start <= end) {
            
            long middle = (start + end) / 2;
            long cnt = 0;
            
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }
            
            if (cnt < K) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }
        
        System.out.print(answer);
    }
}