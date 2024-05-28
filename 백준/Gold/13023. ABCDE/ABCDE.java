import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean check;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드(사람)의 수 n
        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visited = new boolean[n];
        
        // 엣지(관계) 수 m
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }
        
        int answer = check ? 1 : 0;
        
        System.out.println(answer);
    }
    
    public static void dfs(int v, int depth) {
        if (depth == 5 || check) {
            check = true;
            return;
        }
        
        ArrayList<Integer> friends = list[v];
        visited[v] = true;
        
        for (Integer num : friends) {
            
            if (!visited[num]) {                
                dfs(num, depth + 1);
            }
        }
        visited[v] = false;
    }
}