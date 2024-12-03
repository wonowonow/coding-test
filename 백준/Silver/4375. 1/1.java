import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            int answer = 1;
            double one = 1;
            
            while (one % num != 0) {
                one = one * 10 + 1;
                one %= num;
                answer++;
            }
            
            System.out.println(answer);
        }
    }
}