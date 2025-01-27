import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == map.length - 1 && now.y == map[0].length - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][now.breakCount]) {
                        visited[nx][ny][now.breakCount] = true;
                        q.add(new Node(nx, ny, now.count + 1, now.breakCount));
                    }
                }

                if (now.breakCount == 0 && map[nx][ny] == 1) {
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, now.count + 1, 1));
                    }
                }
            }
        }

        return -1;
    }

    private static class Node {
        int x;
        int y;
        int count;
        int breakCount;

        public Node(int x, int y, int count, int breakCount) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breakCount = breakCount;
        }
    }
}
