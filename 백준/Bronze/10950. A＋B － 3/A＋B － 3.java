import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        
        for (int i = 0; i < s; i++) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
}