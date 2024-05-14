import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = 0;
            int printCnt = 0;
            
            Queue<Num> q = new LinkedList<>();
            
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (max < num) {
                    max = num;
                }
                q.add(new Num(j, num));
            }
            
            boolean search = false;
            
            while(!search) {
                
                if (q.peek().num == max) {
                    
                    printCnt++;
                    Num target = q.poll();
                    max = 0;
                    
                    if (target.idx == M) {
                        search = true;
                        break;
                    }
                    
                    int qSize = q.size();
                    
                    for (int j = 0; j < qSize; j++) {
                        
                        Num num = q.poll();
                        if (num.num > max) {
                            max = num.num;
                        }
                        q.add(num);
                    }
                } else {
                    q.add(q.poll());
                }
            }
            
            System.out.println(printCnt);
        }
    }
    
    static class Num {
        
        int idx;
        int num;
        
        public Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}