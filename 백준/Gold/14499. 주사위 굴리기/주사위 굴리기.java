import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {

            int command = Integer.parseInt(st.nextToken());
            int nx = x + dx[command - 1];
            int ny = y + dy[command - 1];

            if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                continue;
            }

            int tmp = dice[1];

            // 동쪽
            if (command == 1) {
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            } else if (command == 2) { // 서쪽
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            } else if (command == 3) { // 북쪽
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
            } else if (command == 4) { // 남쪽
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
            }

            if (arr[nx][ny] == 0) {
                arr[nx][ny] = dice[6];
            } else {
                dice[6] = arr[nx][ny];
                arr[nx][ny] = 0;
            }

            x = nx;
            y = ny;

            sb.append(dice[1]);
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}