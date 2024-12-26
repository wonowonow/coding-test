import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();

        int unit = B % 10;
        int tens = (B / 10) % 10;
        int hundreds = B / 100;

        System.out.println(A * unit);
        System.out.println(A * tens);
        System.out.println(A * hundreds);
        System.out.println(A * B);
    }
}