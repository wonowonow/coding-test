import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[10000001];
        
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i = 2; i < arr.length; i++) {
            
            if (arr[i] == 0) {
                continue;
            }
            
            for (int j = i + i; j < arr.length; j = j + i) {
                
                arr[j] = 0;
            }
        }
        
        for (int i = N; i < arr.length; i++) {
            
            if (arr[i] != 0) {
                
                String a = String.valueOf(arr[i]);
                StringBuilder b = new StringBuilder(a);
                
                if (a.equals(b.reverse().toString())) {
                    System.out.print(a);
                    break;
                }
            }
        }
    }
}