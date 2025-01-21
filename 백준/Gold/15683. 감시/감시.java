import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] board;
    static int[][][] cctvDirections = {
            {{0}},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 3}, {3, 2}, {2, 1}, {1, 0}},
            {{0, 1, 3}, {0, 2, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}
    };
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> cctvs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cctvs.add(new int[] {i, j, board[i][j]});
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == cctvs.size()) {
            recordMinSize();
            return;
        }

        int[] cctv = cctvs.get(depth);
        int y = cctv[0];
        int x = cctv[1];
        int type = cctv[2];

        int[][] backup = copyBoard();

        for (int[] directions : cctvDirections[type]) {
            for (int dir : directions) {
                watch(x, y, dir);
            }
            dfs(depth + 1);
            backupBoard(backup);
        }
    }

    private static int[][] copyBoard() {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    public static void backupBoard(int[][] backup) {
        for (int i = 0; i < board.length; i++) {
            board[i] = backup[i].clone();
        }
    }

    public static void watch(int x, int y, int dir) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || ny < 0 || nx >= board[0].length || ny >= board.length || board[ny][nx] == 6) {
                break;
            }
            if (board[ny][nx] == 0) {
                board[ny][nx] = -1;
            }
        }
    }

    public static void recordMinSize() {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.min(cnt, answer);
    }
}
