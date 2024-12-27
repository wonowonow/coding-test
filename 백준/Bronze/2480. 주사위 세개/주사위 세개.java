import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result;

        if (a == b && b == c) {
            result = 10000 + a * 1000;
        } else if (a == b || a == c) {
            result = 1000 + a * 100;
        } else if (b == c) {
            result = 1000 + b * 100;
        } else {
            int maxValue = Math.max(a, Math.max(b, c));
            result = maxValue * 100;
        }

        System.out.println(result);
    }
}