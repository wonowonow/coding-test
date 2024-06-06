import java.util.*;

public class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int size;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size][size];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
                max = Math.max(arr[i][j], max);
            }
        }

        int answer = 0;

        for (int i = 0; i <= max; i++) {

            int cnt = 0;
            visited = new boolean[size][size];

            for (int j = 0; j < size; j++) {

                for (int k = 0; k < size; k++) {
                    if (!visited[j][k] && arr[j][k] > i) {
                        bfs(j, k, i);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.print(answer);
    }

    public static void bfs(int x, int y, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                if (nx >= 0 && nx < size &&
                        ny >= 0 && ny < size &&
                        arr[nx][ny] > m &&
                        !visited[nx][ny]) {

                    visited[nx][ny] = true;
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