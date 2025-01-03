import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시
        int M = Integer.parseInt(st.nextToken()); // 도로

        // 플로이드 워셜 정리를 위한 2차원 배열
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], 10001);
            arr[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 플로이드 워셜 정리
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    arr[a][b] = Integer.min(arr[a][b], arr[a][k] + arr[b][k]);
                }
            }
        }
        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmp = 0;
                for (int k = 1; k <= N; k++) {
                    tmp += Math.min(arr[i][k], arr[j][k]);
                }

                if (sum > tmp) {
                    result[0] = i;
                    result[1] = j;
                    sum = tmp;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
        System.out.println(sum * 2);
    }
}
