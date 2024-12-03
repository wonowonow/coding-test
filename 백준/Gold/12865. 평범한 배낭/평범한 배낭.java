import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        int max = sc.nextInt();
        
        int[] arr = new int[max + 1];
        
        for (int i = 0; i < cases; i++) {
            
            int weight = sc.nextInt();
            int value = sc.nextInt();
            
            for (int j = max; j >= weight; j--) {
                arr[j] = Math.max(arr[j], arr[j - weight] + value);
            }
        }
        
        System.out.print(arr[max]);
    }
}