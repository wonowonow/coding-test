import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        for (int i = 0; i < size; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.println(a * b / gcb(a, b));
        }
        
    }
    
    public static int gcb(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcb(b, a % b);
        }
    }
}