import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Long A = sc.nextLong();
        Long B = sc.nextLong();
        
        System.out.print((A+B) * (A-B));
    }
}

// (A+B)×(A-B)