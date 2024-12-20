import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        parent = new int[V + 1];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Edge(value, a, b));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o1.value - o2.value;
        });
        int answer = 0;
        for (Edge e : list) {
            
            if (find(e.nodeA) != find(e.nodeB)) {
                union(e.nodeA, e.nodeB);
                answer += e.value;
            }
        }
        
        System.out.print(answer);
    }
    
    public static void union(int a, int b) {
        
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    public static int find(int n) {
        
        if (parent[n] == n) {
            return n;
        }
        
        return parent[n] = find(parent[n]);
    }
    
    static class Edge {
        int value;
        int nodeA;
        int nodeB;
        
        public Edge(int value, int nodeA, int nodeB) {
            this.value = value;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }
}