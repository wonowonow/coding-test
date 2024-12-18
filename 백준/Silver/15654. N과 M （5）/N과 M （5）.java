import java.util.*;
import java.io.*;

public class Main {
    
    static int[] arr;
    static int[] numbers;
    static int n;
    static int m;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        numbers = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        search(0);
    }
    
    public static void search(int depth) {
        
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : numbers) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
            return;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (!visited[i]) {
                numbers[depth] = arr[i];
                visited[i] = true;
                search(depth + 1);
                visited[i] = false;
            }
        }
    }
}