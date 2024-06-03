import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] distance;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nodes = Integer.parseInt(st.nextToken());
        list = new ArrayList[nodes + 1];
        visited = new boolean[nodes + 1];
        distance = new int[nodes + 1];
        
        for (int i = 1; i <= nodes; i++) {
            
            list[i] = new ArrayList<Node>();
        }
        
        for (int i = 0; i < nodes; i++) {
            st = new StringTokenizer(br.readLine());
            int nowNode = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) {
                    break;
                }
                int nextWeight = Integer.parseInt(st.nextToken());
                list[nowNode].add(new Node(nextNode, nextWeight));
            }
        }
        
        bfs(1);
        int max = 1;
        
        for (int i = 2; i <= nodes; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        visited = new boolean[nodes + 1];
        distance = new int[nodes + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[nodes]);
    }
    
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        
        while (!q.isEmpty()) {
            
            int nowIndex = q.poll();
            
            for (Node node : list[nowIndex]) {
                int num = node.num;
                int weight = node.weight;
                
                if (!visited[num]) {
                    q.add(num);
                    visited[num] = true;
                    distance[num] = distance[nowIndex] + weight;
                }
            }
        }
    }
    
    private static class Node {
        
        int num;
        int weight;
        
        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}