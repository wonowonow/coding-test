import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[] visited;
    static ArrayList<Integer>[] nodes;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        nodes = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        
        for (int i = 0; i < nodeCnt + 1; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[x].add(y);
            nodes[y].add(x);
        }
        
        for (int i = 1; i < nodeCnt + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        System.out.print(answer);
    }
    
    public static void dfs(int now) {
        
        if (visited[now]) {
            return;
        }
        visited[now] = true;
        
        for (int i : nodes[now]) {
            
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}