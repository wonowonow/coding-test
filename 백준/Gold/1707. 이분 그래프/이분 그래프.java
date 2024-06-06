import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cases = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            list = new ArrayList[nodes + 1];
            visited = new boolean[nodes + 1];
            check = new int[nodes + 1];
            isEven = true;
            
            for (int j = 1; j <= nodes; j++) {
                list[j] = new ArrayList<Integer>();
            }
            
            for (int j = 0; j < edges; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                list[to].add(from);
            }
            
            for (int j = 1; j <= nodes; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }
            
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static void dfs(int now) {
        
        visited[now] = true;
        
        for (int num : list[now]) {
            if (!visited[num]) {
                check[num] = (check[now] + 1) % 2;
                dfs(num);
            } else if (check[num]== check[now]) {
                isEven = false;
            }
        }
    }
}