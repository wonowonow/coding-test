import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int target = sc.nextInt();
        
        for (int i = 1; i < target; i++) {
            
            String str = String.valueOf(i);
            int sum = i;
            int num = i;
            while (num > 0) {
                
                sum += num % 10;
                num /= 10;
            }
            
            if (sum == target) {
                answer = i;
                break;
            }
        }
        
        System.out.print(answer);
    }
}