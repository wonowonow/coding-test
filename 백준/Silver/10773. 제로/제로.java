import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < size; i++) {
            int a = sc.nextInt();
            
            if (a == 0) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }
        
        int sum = 0;
        
        for (int i : stack) {
            sum += i;
        }
        
        System.out.print(sum);
    }
}