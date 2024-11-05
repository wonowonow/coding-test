import java.util.*;

public class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] unknown;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            
            System.out.println(bfs());
        }
        
    }
    
    public static int bfs() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int bc = sc.nextInt();
        int cnt = 0;
        unknown = new boolean[x][y];
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < bc; i++) {
            int scx = sc.nextInt();
            int scy = sc.nextInt();
            unknown[scx][scy] = true;
            q.add(new Node(scx, scy));
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            Queue<Node> wq = new LinkedList<>();
            int cx = now.x;
            int cy = now.y;
            
            if (unknown[cx][cy]) {
                cnt++;
                wq.add(new Node(cx, cy));
                while (!wq.isEmpty()) {
                    Node wqNode = wq.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = wqNode.x + dx[i];
                        int ny = wqNode.y + dy[i];
                        if (0 <= nx && nx < unknown.length && 
                            0 <= ny && ny < unknown[0].length && unknown[nx][ny]) {
                            
                            wq.add(new Node(nx, ny));
                            unknown[nx][ny] = false;
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
    
    static class Node {
        
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}