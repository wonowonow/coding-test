import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        while (num > 0) {
            num /= 5;
            cnt += num;
        }
        
        System.out.print(cnt);
    }
}