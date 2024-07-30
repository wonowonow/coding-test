import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = 0;
        int target = sc.nextInt();
        for (int num : arr) {
            if (num == target) {
                answer++;
            }
        }
        
        System.out.print(answer);
    }
}