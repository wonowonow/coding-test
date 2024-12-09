import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[x][y];
        visited = new boolean[x][y];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            
            arr[sx - 1][sy - 1] = 1;
        }
        
        int answer = 0;
        
        for (int i = 0; i < x; i++) {
            
            for (int j = 0; j < y; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    
                    arr[i][j] = search(1, i, j);
                    answer = Math.max(answer, arr[i][j]);
                }
            }
        }
        
        System.out.print(answer);
    }
    
    public static int search(int cnt, int x, int y) {
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length &&
               !visited[nx][ny] && arr[nx][ny] == 1) {
                cnt = search(++cnt, nx, ny);
            }
        }
        
        return cnt;
    }
}