import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        for (int i = 0; i < size; i++) {
            int a = sc.nextInt();
            if (target > a) {
                System.out.println(a);
            }
        }
    }
}