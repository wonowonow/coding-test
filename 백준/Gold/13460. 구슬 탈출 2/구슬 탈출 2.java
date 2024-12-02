import java.util.*;

public class Main {
    
    // 필요한 것.
    // 1. 두 구슬이 움직인 기록을 담을 4차원 boolean 배열
    // 2. 장애물 판단
    //    1씩 가다가 # 및 0 만나면 멈추거나 들어간다.
    // 3. 움직임 배열 (dx, dy) 걍 1씩

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][][] visited;
    static char[][] board;

    public static void main(String[] args) {

        // 1. 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
        // 2. 중력을 이용해서 이리 저리 굴려야 한다.
        // 3. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다.
        // 4. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다.
        // 5. 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다.
        //    기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
        // 주의점
        // 1. 어쨋든 구슬은 어디든 부딪히게 된다.

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine(); // 공백 지우기

        board = new char[x][y];
        // 레드가 앞에, 블루가 뒤에
        visited = new boolean[x][y][x][y];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        for (int i = 0; i < x; i++) {
            char[] cArr = sc.nextLine().toCharArray();
            for (int j = 0; j < y; j++) {
                board[i][j] = cArr[j];

                if (cArr[j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (cArr[j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }

        visited[redX][redY][blueX][blueY] = true;

        System.out.print(bfs(redX, redY, blueX, blueY));
    }

    public static int bfs(int frX, int frY, int fbX, int fbY) {

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(frX, frY, fbX, fbY, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int nrx = now.redX;
            int nry = now.redY;
            int nbx = now.blueX;
            int nby = now.blueY;
            int cnt = now.cnt + 1;

            if (cnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                
                int[] db = move(nbx, nby, i);
                int[] dr = move(nrx, nry, i);
                

                if (board[db[0]][db[1]] == 'O') { // 블루는 들어가면 안 된다.
                    continue;
                }

                if (board[dr[0]][dr[1]] == 'O') {
                    return cnt;
                }

                if (dr[0] == db[0] && dr[1] == db[1]) { // 서로 위치가 같다면

                    if (dr[2] > db[2]) { // 이동한 거리가 더 긴 것들 한 칸 전으로
                        dr[0] -= dx[i];
                        dr[1] -= dy[i];
                    } else {
                        db[0] -= dx[i];
                        db[1] -= dy[i];
                    }
                }
                if (!visited[dr[0]][dr[1]][db[0]][db[1]]) {
                    q.add(new Node(dr[0], dr[1], db[0], db[1], cnt));
                    visited[dr[0]][dr[1]][db[0]][db[1]] = true;
                }
            }
        }

        return -1;
    }

    public static int[] move(int x, int y, int i) {

        int distance = 0;

        while (x + dx[i] < board.length && x + dx[i] >= 0 && y + dy[i] < board[0].length
                && y + dy[i] >= 0 && board[x + dx[i]][y + dy[i]] != '#' && board[x][y] != 'O') {
            x += dx[i];
            y += dy[i];
            distance++;
        }

        return new int[]{x, y, distance};
    }

    static class Node {

        int redX, redY, blueX, blueY, cnt;

        public Node(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}