import java.util.*;

public class Main {
    
    static int max;
    static List<Integer> list;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        list = new ArrayList<>();
        
        max = sc.nextInt();
        
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        
        
        for (int num : list) {
            sb.append(num + "\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static void dfs(int now, int jarisu) {
        
        if (jarisu == max) {
            list.add(now);
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            int next = now * 10 + i;
            if (next % 2 == 0) {
                continue;
            } else if (isSosu(next)) {
                dfs(next, jarisu + 1);
            }
        }
    }
    
    public static boolean isSosu(int number) {
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}