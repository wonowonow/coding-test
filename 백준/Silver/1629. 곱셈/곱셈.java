import java.util.*;

public class Main {
    
    static long a, b, c;
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        
        System.out.println(logic(a, b));
    }
    
    public static long logic(long a, long b) {
        
        if (b == 1) {
            return a % c;
        }
        
        long r = logic(a, b / 2);
        
        r = (r * r) % c;
        
        if (b % 2 == 1) {
            r = (r * a) % c;
        }
        
        return r;
    }
}