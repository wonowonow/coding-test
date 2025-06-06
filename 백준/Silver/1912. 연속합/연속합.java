import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        int[] dp = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int maxSum = dp[0];

        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}
