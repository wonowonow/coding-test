import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int num = 1;
        int cnt = 1;
        while (num < target) {
            num += 6 * cnt;
            cnt++;
        }
        System.out.print(cnt);
    }
}