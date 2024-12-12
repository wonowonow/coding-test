import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();
        if (score.equals("F")) {
            System.out.print("0.0");
        } else {
            float answer = 0.0f;
            for (char c : score.toCharArray()) {
                
                if (c == 'A') {
                    answer = 4.0f;
                } else if (c == 'B') {
                    answer = 3.0f;
                } else if (c == 'C') {
                    answer = 2.0f;
                } else if (c == 'D') {
                    answer = 1.0f;
                }
                
                if (c == '+') {
                    answer += 0.3f;
                } else if (c == '-') {
                    answer -= 0.3f;
                }
            }
            
            System.out.print(answer);
            
        }
    }
}