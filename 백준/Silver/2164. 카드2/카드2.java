import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        int n = new Scanner(System.in).nextInt();
        Queue<Integer> q = new LinkedList<>();
        
        
        for (int i = 1; i <= n; i++) {
            
            q.add(i);
        }
        int last = 0;
        while(!q.isEmpty()) {
            
            if (q.size() == 1) {
                last = q.poll();
                break;
            }
            q.poll();
            q.add(q.poll());
        }
        
        System.out.print(last);
    }
}