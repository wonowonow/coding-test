import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[y][x];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for (int j = ly; j < ry; j++) {
                
                for (int u = lx; u < rx; u++) {
                    visited[j][u] = true;
                }
            }
        }
        
        int idx = 0;
        
        for (int i = 0; i < y; i++) {
            
            for (int j = 0; j < x; j++) {
                
                if (!visited[i][j]) {
                    list.add(0);
                    search(idx, i, j);
                    idx++;
                }
            }
        }
        
        System.out.println(idx);
        
        Collections.sort(list);
        
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
    
    public static void search(int idx, int y, int x) {
        visited[y][x] = true;
        list.set(idx, list.get(idx) + 1);
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= visited.length || nx < 0 || nx >= visited[0].length) {
                continue;
            }
            
            if (!visited[ny][nx]) {
                
                search(idx, ny, nx);
            }
        }
    }
}