import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < y; j++) {
                visited[i][j] = str.charAt(j) == '1' ? false : true;
            }
        }

        System.out.print(bfs());
    }


    public static int bfs() {

        int answer = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 1));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == visited.length - 1 && now.y == visited[0].length - 1) {
                answer = now.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < visited.length && nx >= 0 && ny < visited[0].length && ny >= 0) {

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, now.cnt + 1));
                    }
                }
            }
        }

        return answer;
    }

    public static class Node {

        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}