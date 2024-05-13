import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        
        for (int i = 1; i < arr.length; i++) {
            
            arr[i] = sc.nextInt();
        }
        
        int arrCnt = 1;
        
        for (int i = 1; i < arr.length; i++) {
            
            stack.push(i);
            sb.append("+\n");
            
            while(!stack.isEmpty() && stack.peek() == arr[arrCnt]) {
                stack.pop();
                arrCnt++;
                sb.append("-\n");
            }
        }
        
        if (stack.size() != 0) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }
    }
}