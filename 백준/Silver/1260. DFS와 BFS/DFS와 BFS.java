import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        visited = new boolean[nodes + 1];
        list = new ArrayList[nodes + 1];
        
        // 인접 리스트 초기화
        for (int i = 0; i <= nodes; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        // Node 연결 양방향
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for (int i = 0; i <= nodes; i++) {
            Collections.sort(list[i]);
        }
        
        dfs(start);
        visited = new boolean[nodes + 1];
        sb.append("\n");
        bfs(start);
        System.out.print(sb.toString());
    }
    
    public static void dfs(int now) {
        if (visited[now]) {
            return;
        }
        
        visited[now] = true;
        sb.append(now + " ");
        
        for (int i = 0; i < list[now].size(); i++) {
            
            int next = list[now].get(i);
            
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            
            for (int i : list[now]) {
                
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}