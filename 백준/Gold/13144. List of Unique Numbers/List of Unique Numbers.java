import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        int l = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> map = new HashMap<>(); // Key = 숫자 / Value = 마지막 인덱스
        long answer = 0;
        
        for (int r = 0; r < size; r++) {
            
            if (map.containsKey(arr[r]) && map.get(arr[r]) >= l) {
                l = map.get(arr[r]) + 1;
            }
            
            map.put(arr[r], r);
            
            answer += (r - l + 1);
        }
        
        System.out.print(answer);
    }
}