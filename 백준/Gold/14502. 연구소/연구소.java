import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        
        map = new int[xSize][ySize];
        
        for (int i = 0; i < xSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ySize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.print(answer);
    }
    
    public static void dfs(int wall) {
        
        if (wall >= 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    
    public static void bfs() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        visited = new boolean[map.length][map[0].length];
        
        Queue<Node> q = new LinkedList<>();
        int[][] copy = new int[map.length][map[0].length];
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copy[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                } 
            }
        }
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if (nx >= 0 && nx < copy.length &&
                    ny >= 0 && ny < copy[0].length &&
                    copy[nx][ny] == 0 &&
                    !visited[nx][ny]) {
                    
                    copy[nx][ny] = 2;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        
        int zeroCnt = 0;
        
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }
        
        answer = Math.max(zeroCnt, answer);
    }
    
    private static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}