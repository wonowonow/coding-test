import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][2];
        int answer = 0;
        
        for (int i = 0; i < size; i++) {
            
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        Arrays.sort(arr, ((a, b) -> {
            
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            
            return a[1] - b[1];
        }));
        
        int end = -1;
        
        for (int[] time : arr) {
            
            if (time[0] >= end) {
                end = time[1];
                answer++;
            }
        }
        
        System.out.print(answer);
    }
}