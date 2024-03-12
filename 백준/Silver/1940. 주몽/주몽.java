import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 첫째 줄에는 재료의 개수 N
        // 둘째줄에는 재료 몇개로 만들 수 있는지 M
        // 셋째 줄에는 재료 번호 배열
        
        // N 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // M 받기
        int M = Integer.parseInt(br.readLine());
        
        // 배열 받기
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        
        int count = 0;
        int i = 0;
        int j = N - 1;
        
        while (i < j) {
            if(A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}