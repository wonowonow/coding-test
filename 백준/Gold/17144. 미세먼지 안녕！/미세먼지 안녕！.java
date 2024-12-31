import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int top = -1;
    static int bottom = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // Y
        C = Integer.parseInt(st.nextToken()); // X
        T = Integer.parseInt(st.nextToken()); // 몇 회

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (top == -1) {
                        top = i;
                    } else {
                        bottom = i;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            vacuum();
        }

        System.out.println(getDustSum());
    }

    public static void spread() {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= 0 && ny < R && nx >= 0 && nx < C && arr[ny][nx] != -1) {
                        cnt++;
                    }
                }
                int value = arr[i][j] / 5;
                arr[i][j] = arr[i][j] - (value * cnt);
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                        continue;
                    }
                    if (arr[ny][nx] == -1) {
                        continue;
                    }
                    tmp[ny][nx] += value;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += tmp[i][j];
            }
        }
    }

    public static void vacuum() {
        for (int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            arr[0][j] = arr[0][j + 1];
        }
        for (int i = 0; i < top; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            arr[top][j] = arr[top][j - 1];
        }
        arr[top][1] = 0;

        for (int i = bottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            arr[R - 1][j] = arr[R - 1][j + 1];
        }
        for (int i = R - 1; i > bottom; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            arr[bottom][j] = arr[bottom][j - 1];
        }
        arr[bottom][1] = 0;
    }

    public static int getDustSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] < 0) {
                    continue;
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
