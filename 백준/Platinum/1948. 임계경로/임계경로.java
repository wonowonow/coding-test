import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> listReverse = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int citys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int roads = Integer.parseInt(st.nextToken());
        
        int[] indegree = new int[citys + 1];
        int[] result = new int[citys + 1];
        
        // 인접 리스트 초기화
        for (int i = 0; i <= citys; i++) {
            list.add(new ArrayList<>());
            listReverse.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            list.get(start).add(new Edge(goal, time));
            listReverse.get(goal).add(new Edge(start, time));
            indegree[goal]++;
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        
        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (Edge next : list.get(now)) {
                result[next.target] = Math.max(result[next.target], result[now] + next.val);
                indegree[next.target]--;
                if (indegree[next.target] == 0) {
                    q.add(next.target);
                }
            }
        }
        
        System.out.println(result[goal]);
        int cnt = 0;
        q = new LinkedList<>();
        q.add(goal);
        boolean[] visited = new boolean[citys + 1];
        visited[goal] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (Edge next : listReverse.get(now)) {
                
                if (result[now] == result[next.target] + next.val) {
                    cnt++;
                    if (!visited[next.target]) {
                        visited[next.target] = true;
                        q.add(next.target);
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
    
    static class Edge {
        
        int target;
        int val;
        
        public Edge(int target, int val) {
            this.target = target;
            this.val = val;
        }
    }
}