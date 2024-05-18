import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Number> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Number(i, priorities[i]));
        }
        
        boolean check = false;
        
        while (!check) {
            int max = 0;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Number number = q.poll();
                if (number.num > max) {
                    max = number.num;
                }
                q.add(number);
            }
            
            for (int i = 0; i < q.size(); i++) {
                Number number = q.poll();
                if (max == number.num) {
                    answer++;
                    if (number.idx == location) {
                        check = true;
                        break;
                    }
                    break;
                } else {
                    q.add(number);
                }
            }
        }
        
        return answer;
    }
    
    class Number {
        int idx;
        int num;
        
        public Number(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}