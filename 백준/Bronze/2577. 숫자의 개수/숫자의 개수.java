import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int result = A * B * C;
        int[] count = new int[10];
        
        while (result > 0) {
            count[result % 10]++;
            result /= 10;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
        
        sc.close();
    }
}