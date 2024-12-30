import java.io.*;
import java.util.*;

public class Main {
    
    static String[] num = {"1110111", "0010010", "1011101", 
                           "1011011", "0111010", "1101011", 
                           "1101111", "1010010", "1111111", 
                           "1111011"}; // 디스플레이를 숫자로 표현한 배열
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 최대 층
        int K = Integer.parseInt(st.nextToken()); // 디스플레이에 표현되는 수
        int P = Integer.parseInt(st.nextToken()); // 최대 반전 개수
        int X = Integer.parseInt(st.nextToken()); // 현재 층
        
        int answer = 0;
        
        String cur = String.valueOf(X);
        
        while (cur.length() < K) {
            cur = "0" + cur;
        }
        
        for (int i = 1; i <= N; i++) {
            
            if (i == X) {
                continue;
            }
            
            String hoseock = String.valueOf(i);
            
            while(hoseock.length() < K) {
                hoseock = "0" + hoseock;
            }
            
            int cnt = 0;
            
            for (int j = 0; j < K; j++) {
                String curLed = num[cur.charAt(j) - '0'];
                String hoLed = num[hoseock.charAt(j) - '0'];
                
                for (int k = 0; k < 7; k++) {
                    if (curLed.charAt(k) != hoLed.charAt(k)) {
                        cnt++;
                    }
                }
            }
            
            if (cnt <= P) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}