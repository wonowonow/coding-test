import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < size; i++) {
            int weight = arr[i] * (size - i);
            answer = Math.max(answer, weight);
        }
        System.out.print(answer);
    }
}