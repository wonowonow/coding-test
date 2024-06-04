import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            start = Math.max(start, arr[i]);
            end += arr[i];
        }
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cnt = 0;
            int sum = 0;
            
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            
            if (sum != 0) { // 탐색 후 합이 0이 아닐시 블루레이가 한개 더 필요하다.
                cnt++;
            }
            
            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.print(start);
    }
}