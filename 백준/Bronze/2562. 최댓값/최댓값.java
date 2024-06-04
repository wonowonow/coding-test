import java.util.*;

public class Main {
    
    public static void main(String[] args) {
           
        Scanner sc = new Scanner(System.in);
        
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for (int i = 1; i <= 9; i++) {
            int a = sc.nextInt();
            if (max < a) {
                max = a;
                index = i;
            }
        }
        
        System.out.print(max + "\n" + index);
    }
}