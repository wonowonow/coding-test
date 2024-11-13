import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int arrSize = sc.nextInt();
        int size = sc.nextInt();
        
        int r = size;
        int l = 0;
        int sum = 0;
        int[] arr = new int[arrSize];
        
        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        
        int answer = sum;
        
        for (int i = r; i < arrSize; i++) {
            
            sum -= arr[l++];
            sum += arr[i];
            
            answer = Math.max(answer, sum);
        }
        
        System.out.print(answer);
    }
}