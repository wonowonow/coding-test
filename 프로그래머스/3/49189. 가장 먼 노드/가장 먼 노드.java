import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            list.add(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        answer = bfs();
        
        return answer;
    }
    
    public int bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        visited[1] = true;
        int cnt = 0;
        
        while (true) {
            
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int next = queue.poll();
                
                for (int nnn : list.get(next)) {
                    if (!visited[nnn]) {
                        temp.add(nnn);
                        visited[nnn] = true;
                    }
                }
            }
            
            if (temp.isEmpty()) {
                break;
            }
            queue.addAll(temp);
            cnt = temp.size();
        }
        
        return cnt;
    }
}