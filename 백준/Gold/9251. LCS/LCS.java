import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        
        int aL = a.length();
        int bL = b.length();
        
        int[][] dp = new int[aL + 1][bL + 1];
        
        for (int i = 1; i < dp.length; i++) {
            
            for (int j = 1; j < dp[0].length; j++) {
                
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        System.out.print(dp[aL][bL]);
    }
}