import java.util.*;
import java.io.*;

public class Main {
    
    static String word;
    static String[] words;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int size = Integer.parseInt(br.readLine());
        words = new String[size];
        dp = new int[word.length()];
        Arrays.fill(dp, -1);

        for (int i = 0; i < size; i++) {
            words[i] = br.readLine();
        }

        System.out.print(dp(0));
    }

    public static int dp(int idx) {

        if (idx == word.length()) {
            return 1;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ret = 0;

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();

            if (len > word.length() - idx) {
                continue;
            }

            if (word.substring(idx, idx + len).equals(words[i])) {
                ret = ret + dp(idx + len);
            }
        }

        if (ret > 0) {
            ret = 1;
        }

        return dp[idx] = ret;
    }
}