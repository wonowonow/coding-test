import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int citys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int buses = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[citys + 1];
        distance = new int[citys + 1];
        visited = new boolean[citys + 1];
        for (int i = 0; i <= citys; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < buses; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list[S].add(new Edge(E, V));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        distance[start] = 0;
        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));
        
        while (!q.isEmpty()) {
            Edge now = q.poll();
            int target = now.target;
            
            if (visited[target]) {
                continue;
            }
            
            visited[target] = true;
            
            for (Edge tmp : list[target]) {
                
                int next = tmp.target;
                int value = tmp.value;
                
                if (distance[next] > distance[target] + value) {
                    distance[next] = distance[target] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        System.out.println(distance[end]);
    }
    
    static class Edge implements Comparable<Edge> {
        int target;
        int value;
        
        public Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }
        
        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}