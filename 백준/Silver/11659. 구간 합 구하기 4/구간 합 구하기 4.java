import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 수의 갯수 N / 합을 구해야 하는 횟수 M
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] NArr = new int[N + 1];

        // 2번째는 N 개의 수가 주어진다.
        stringTokenizer = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            NArr[i] = NArr[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // M개의 합을 구해야 하는 i와 j -> i 부터 j 까지 구해라
        for(int q = 0; q < M; q++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(NArr[j]-NArr[i - 1]);
        }
    }
}