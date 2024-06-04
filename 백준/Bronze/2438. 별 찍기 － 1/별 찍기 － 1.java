import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        for (int i = 1; i <= size; i++) {
            System.out.println("*".repeat(i));
        }
    }
}