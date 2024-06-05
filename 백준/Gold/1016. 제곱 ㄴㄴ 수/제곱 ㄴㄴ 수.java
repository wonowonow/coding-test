import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] arr = new boolean[(int) (max - min + 1)];
        
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min / pow;
            
            if (min % pow != 0) {
                start++;
            }
            
            for (long j = start; pow * j <= max; j++) {
                arr[(int)((j * pow) - min)] = true;
            }
        }
        
        int cnt = 0;
        
        for (int i = 0; i <= max - min; i++) {
            if (!arr[i]) {
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }
}