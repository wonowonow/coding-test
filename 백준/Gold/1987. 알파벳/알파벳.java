import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean[][] visited;
    static int answer;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }

        search(0, 0, 0);
        System.out.println(answer);
    }

    public static void search(int x, int y, int cnt) {

        visited[y][x] = true;
        cnt++;
        set.add(arr[y][x]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= arr[0].length || ny < 0 || ny >= arr.length) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            if (set.contains(arr[ny][nx])) {
                continue;
            }

            search(nx, ny, cnt);
        }

        answer = Math.max(answer, cnt);

        visited[y][x] = false;
        set.remove(arr[y][x]);
    }
}
