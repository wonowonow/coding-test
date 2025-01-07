import java.util.*;
import java.io.*;

public class Main {
    
    static int white = 0;
    static int blue = 0;
    static boolean[][] visited;
    static String[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로

        arr = new String[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < arr.length; i++) {
            String[] sp = br.readLine().split("");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sp[j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!visited[i][j]) {
                    int cnt = search(j, i, 0, arr[i][j]);
                    if (arr[i][j].equals("W")) {
                        white += cnt * cnt;
                    } else {
                        blue += cnt * cnt;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    public static int search(int x, int y, int cnt, String color) {

        visited[y][x] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 범위가 넘어가면 PASS
            if (nx < 0 || nx >= arr[0].length || ny < 0 || ny >= arr.length) {
                continue;
            }
            // 방문 했다면 PASS
            if (visited[ny][nx]) {
                continue;
            }
            // 컬러가 같지 않다면 PASS
            if (!arr[ny][nx].equals(color)) {
                continue;
            }

            cnt = search(nx, ny, cnt, color);
        }

        return cnt;
    }
}