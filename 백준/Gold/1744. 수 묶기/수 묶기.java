import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        int size = sc.nextInt();
        int answer = 0;
        
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else if (num < 0) {
                minus.add(num);
            } else if (num > 1) {
                plus.add(num);
            }
        }
        
        while (plus.size() > 1) {
            int a = plus.poll();
            int b = plus.poll();
            answer += a * b;
        }
        
        if (!plus.isEmpty()) {
            answer += plus.poll();
        }
        
        while (minus.size() > 1) {
            int a = minus.poll();
            int b = minus.poll();
            answer += a * b;
        }
        
        if (!minus.isEmpty() && zero == 0) {
            answer += minus.poll();
        }
        
        answer += one;
        
        System.out.print(answer);
    }
}