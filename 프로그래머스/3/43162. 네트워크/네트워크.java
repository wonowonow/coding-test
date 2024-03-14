import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        count = 0;
        
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        
        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= n; j++) {
                if (computers[i-1][j-1] == 1) {
                    tree[i].add(j);
                } else {
                    tree[i].add(0);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " = ");
            for (int j = 1; j <= n; j++) {
                System.out.print(tree[i].get(j-1) + " ");
            }
            System.out.println();
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        
        answer = count;
        
        return answer;
    }
    
    public void DFS (int n) {
        if (visited[n]) {
            return;
        }
        
        visited[n] = true;
        
        for (int i : tree[n]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}