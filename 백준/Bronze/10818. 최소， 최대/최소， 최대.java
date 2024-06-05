import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        System.out.print(min + " " + max);
    }
}