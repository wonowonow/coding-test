import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt() * 60 + sc.nextInt() + sc.nextInt();
        
        int[] ans = mToHr(m);
        
        System.out.print(ans[0] + " " + ans[1]);
    }
    
    public static int[] mToHr(int m) {
        
        if (m >= 1440) {
            m -= 1440;
        }
        
        return new int[]{m / 60, m % 60};
    }
}