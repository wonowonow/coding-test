import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        sc.nextLine(); // 공백 제거
        int answer = 0;
        
        for (int i = 0; i < problems; i++) {
            if (logic(sc.nextLine())) {
                answer++;
            }
        }
        
        System.out.print(answer);
    }
    
    public static boolean logic(String word) {
        
        if (word.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : word.toCharArray()) {
            
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.empty() ? true : false;
    }
}