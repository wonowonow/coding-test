import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < size; i++) {
            
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int now = stack.pop();
                answer[now] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int now = stack.pop();
            answer[now] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.print(sb.toString());
    }
}