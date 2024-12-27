import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int size = sc.nextInt();
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            int price = sc.nextInt();
            int cnt = sc.nextInt();
            tmp += price * cnt;
        }
        
        System.out.print(target == tmp ? "Yes" : "No");
    }
}