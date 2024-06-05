import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            int score = 0, sum = 0;
            
            for (char c : input.toCharArray()) {
                if (c == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }
            
            System.out.println(sum);
        }
    }
}