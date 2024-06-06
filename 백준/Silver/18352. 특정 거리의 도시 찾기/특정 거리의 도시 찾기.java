import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] score;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        int target = sc.nextInt();
        int start = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        
        list = new ArrayList[nodes + 1];
        visited = new boolean[nodes + 1];
        score = new int[nodes + 1];
        
        for (int i = 0; i <= nodes; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            list[a].add(b);
        }
        
        bfs(start);
        
        for (int i = 1; i <= nodes; i++) {
            if (score[i] == target) {
                answer.add(i);
            }
        }
        
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }
    
    public static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visited[now] = true;
        
        while(!q.isEmpty()) {
            
            int from = q.poll();
            
            for (int to : list[from]) {
                
                if (!visited[to]) {
                    visited[to] = true;
                    q.add(to);
                    score[to] = score[from] + 1;
                }
            }
        }
    }
}