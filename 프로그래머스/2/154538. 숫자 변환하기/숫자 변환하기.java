import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        Set<Integer> visited = new HashSet<>();
        Queue<Tmp> q = new LinkedList<>();
        
        q.add(new Tmp(x, 0));
        visited.add(x);
        
        boolean check = false;
        int answer = 0;
        while (!q.isEmpty()) {
            Tmp now = q.poll();
            
            int nowV = now.value;
            int nowC = now.cnt;
            
            if (nowV == y) {
                answer = nowC;
                check = true;
                break;
            }
            
            if (nowV * 2 <= y && !visited.contains(nowV * 2)) {
                q.add(new Tmp(nowV * 2, nowC + 1));
                visited.add(nowV * 2);
            }
            
            if (nowV * 3 <= y && !visited.contains(nowV * 3)) {
                q.add(new Tmp(nowV * 3, nowC + 1));
                visited.add(nowV * 3);
            }
            
            if (nowV + n <= y && !visited.contains(nowV + n)) {
                q.add(new Tmp(nowV + n, nowC + 1));
                visited.add(nowV + n);
            }
            
            answer++;
        }
        
        return check ? answer : -1;
    }
    
    public class Tmp {
        int value;
        int cnt;
        
        public Tmp(int val, int c) {
            value = val;
            cnt = c;
        }
    }
}