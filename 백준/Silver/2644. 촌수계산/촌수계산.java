import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int start;
    static int end;
    static int cnt;
    static boolean check;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int nodes = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        int edges = sc.nextInt();
        
        list = new ArrayList[nodes + 1];
        visited = new boolean[nodes + 1];
        
        for (int i = 1; i <= nodes; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        
        bfs(start);
        
        if (check) {
            System.out.print(cnt);
        } else {
            System.out.print(-1);
        }
    }
    
    public static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visited[now] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            cnt++;
            
            for (int i = 0; i < size; i++) {
                int from = q.poll();
                for (int to : list[from]) {
                    if (!visited[to]) {
                        if (to == end) {
                            check = true;
                            return;
                        }
                        q.add(to);
                        visited[to] = true;
                    }
                }
            }
        }
    }
}