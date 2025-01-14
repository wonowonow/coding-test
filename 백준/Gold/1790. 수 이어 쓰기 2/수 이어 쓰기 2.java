import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // k 가 자릿수 보다 크면
        if (getDigit(N) < k) {
            System.out.println(-1);
            return;
        }

        long l = 1;
        long r = N;
        long answer = 0;

        while (l <= r) {
            long m = (l + r) / 2;
            if (getDigit(m) >= k) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        long answerBefore = getDigit(answer - 1);
        long index = k - answerBefore - 1;
        String ansString = String.valueOf(answer);
        System.out.println(ansString.charAt((int) index));
    }

    public static long getDigit(long target) {
        long digit = 0;
        long start = 1;
        long length = 1;

        while (start <= target) {
            // 현재 자릿수의 마지막 수
            long end = Math.min(start * 10 - 1, target);
            // 현재 자릿수에서 자릿수 총합
            digit += (end - start + 1) * length;
            // 다음 자릿수
            start *= 10;
            // 길이++
            length++;
        }

        return digit;
    }
}
