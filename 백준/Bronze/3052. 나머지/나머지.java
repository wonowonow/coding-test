import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> remainders = new HashSet<>();
        
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            remainders.add(num % 42);
        }
        
        System.out.println(remainders.size());
    }
}