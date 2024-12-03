import java.util.*;

public class Main {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        board = new int[x][y];
        visited = new boolean[x][y];

        sc.nextLine();

        for (int i = 0; i < x; i++) {

            String str = sc.nextLine();

            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j))); // 이거 어케했더라
            }
        }

        System.out.print(bfs());

    }


    public static int bfs() {

        int answer = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == board.length - 1 && now.y == board[0].length - 1) {
                answer = now.cnt + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (now.x + dx[i] < board.length && now.x + dx[i] >= 0 &&
                        now.y + dy[i] < board[0].length && now.y + dy[i] >= 0) {

                    if (!visited[now.x + dx[i]][now.y + dy[i]] &&
                            board[now.x + dx[i]][now.y + dy[i]] != 0) {
                        visited[now.x + dx[i]][now.y + dy[i]] = true;
                        q.add(new Node(now.x + dx[i], now.y + dy[i], now.cnt + 1));
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