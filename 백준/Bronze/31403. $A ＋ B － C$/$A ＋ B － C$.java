import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int c = sc.nextInt();
        System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - c);
        System.out.print(Integer.parseInt(a + b) - c);
    }
}