import java.util.*;

public class Main {
    
    static boolean check;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        dfs(a, b, 0);
        
        System.out.print(check ? answer + 1 : -1);
    }
    
    public static void dfs(int a, int b, int cnt) {
        
        if (b < a) {
            return;
        }
        
        if (a == b) {
            check = true;
            answer = Math.min(cnt, answer);
            return;
        }
        
        if (b % 10 == 1) {
            dfs(a, b / 10, cnt + 1);
        } else if (b % 2 == 0) {
            dfs(a, b / 2, cnt + 1);
        }
    }
}