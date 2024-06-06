import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int cnt;
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        cnt = 0;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    cnt++;
                    bfs(j, i);
                }
            }
        }

        int[] answer = new int[cnt + 1];

        System.out.println(cnt);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] != 0) {
                    answer[map[i][j]]++;
                }
            }
        }

        Arrays.sort(answer);

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        map[y][x] = cnt;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && map[ny][nx] == 1
                        && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    map[ny][nx] = cnt;
                    q.add(new Node(nx, ny));
                }
            }
        }
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