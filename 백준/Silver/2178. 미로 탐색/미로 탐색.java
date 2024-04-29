import java.util.*;

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            String[] sArr = str.split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(sArr[j]);
                visited[i][j] = false;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        int cnt = 1;

        q.add(new Node(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {

                Node node = q.poll();

                for (int j = 0; j < 4; j++) {

                    int nx = dx[j] + node.x;
                    int ny = dy[j] + node.y;
                    if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length) {
                        if (!visited[ny][nx] && arr[ny][nx] == 1) {
                            q.add(new Node(nx, ny));
                            visited[ny][nx] = true;
                        }

                        if (ny == arr.length - 1 && nx == arr[0].length - 1) {
                            return cnt + 1;
                        }
                    }
                }
            }
            cnt++;
        }

        return 0;
    }

    static class Node {

        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}