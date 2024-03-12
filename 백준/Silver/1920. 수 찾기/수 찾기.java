import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 N개가 주어진다.
        int N = Integer.parseInt(br.readLine());
        // 숫자 N 크기의 배열
        int[] A = new int[N];
        // 배열 채우기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = A.length - 1;

            while (start <= end) {
                int middleIndex = (start + end) / 2;
                int current = A[middleIndex];

                if (current < target) {
                    start = middleIndex + 1;
                } else if (current > target) {
                    end = middleIndex - 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}