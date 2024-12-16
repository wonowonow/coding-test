import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        
        for (int i = 0; i <= x; i++) {
            sum += arr[i];
        }
        
        int max = sum;
        int cnt = 1;
        int l = 0;
        
        for (int r = x + 1; r < n; r++) {
            
            sum -= arr[l];
            sum += arr[r];
            
            if (max == sum) {
                cnt++;
            } else if (max < sum) {
                max = sum;
                cnt = 1;
            }
            
            l++;
        }
        
        if (max == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(max);
            System.out.print(cnt);
        }
        
    }
}