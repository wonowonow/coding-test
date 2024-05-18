import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (o1, o2) -> {
                int oneAbs = Math.abs(o1);
                int twoAbs = Math.abs(o2);
                if (oneAbs == twoAbs) {
                    return o1 > o2 ? 1 : -1;
                } else {
                    return oneAbs - twoAbs;
                }
            }
        );
        
        for (int i = 0; i < cnt; i++) {
            
            int request = sc.nextInt();
            if (request == 0) {
                
                if (q.isEmpty()) {
                    System.out.println(request);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.add(request);
            }
        }
        
        
    }
}