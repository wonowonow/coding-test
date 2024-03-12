import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 첫째줄에는 수의 개수 N
        // 둘째줄에는 i번째 수 개수 배열

        // 정렬 + 투포인터 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 받기
        int N = Integer.parseInt(br.readLine());

        // N 의 배열 받기
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // N의 배열 정렬
        Arrays.sort(A);

        int result = 0;

        // K를 잡고 그 K에 대해 돈다
        for (int k = 0; k < N; k++) {

            long find = A[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {

                if (A[i] + A[j] > find) {
                    j--;
                } else if (A[i] + A[j] < find) {
                    i++;
                } else if (A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                }
            }
        }

        System.out.println(result);
    }
}