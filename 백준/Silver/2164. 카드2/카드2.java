import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        int n = new Scanner(System.in).nextInt();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        
        while(q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        
        System.out.print(q.poll());
    }
}