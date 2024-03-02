import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 N개가 주어지고 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램

        long answer = 0;

        // N 과 M
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long[] nArr = new long[n];
        long[] mArr = new long[m];

        // 숫자 N개가 있는 배열
        stringTokenizer = new StringTokenizer(br.readLine());

        // 합배열 만들기
        nArr[0] = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 1; i < nArr.length; i++) {
            nArr[i] = nArr[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // M으로 나누어 떨어지는 갯수 구하기
        for (int i = 0; i < nArr.length; i++) {
            int etc = (int) (nArr[i] % m);

            if (etc == 0) {
                answer++;
            }
            
            mArr[etc]++;
        }
        
        for (int i = 0; i < m; i++) {
            if (mArr[i] > 1) {
                answer = answer + (mArr[i] * (mArr[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}