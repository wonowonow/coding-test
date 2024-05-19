import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int[] arr = new int[size];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            
            arr[i] = arr[i - 1] + arr[i];
            answer += arr[i];
        }
        
        System.out.print(answer);
    }
}