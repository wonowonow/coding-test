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
        
        // 현재 디스플레이에 표현되는 수 만큼 0 채우기
        while (cur.length() < K) {
            cur = "0" + cur;
        }
        
        for (int i = 1; i <= N; i++) {
            
            // 같은 층이면 건너 뛰기
            if (i == X) {
                continue;
            }
            
            // 호석이가 테스트 해 볼 층 수
            String hoseock = String.valueOf(i);
            
            // 빌런 디스플레이에 표현되는 수 만큼 0 채우기
            while(hoseock.length() < K) {
                hoseock = "0" + hoseock;
            }
            
            // 반전 수 체크하기 위한 변수
            int cnt = 0;
            
            // K 자리수 까지 돌기
            for (int j = 0; j < K; j++) {
                // 현재 j번째 Led
                String curLed = num[cur.charAt(j) - '0'];
                // 호석 j번째 Led
                String hoLed = num[hoseock.charAt(j) - '0'];
                
                // 현재랑 호석이랑 Led 바뀐 곳 체크
                for (int k = 0; k < 7; k++) {
                    if (curLed.charAt(k) != hoLed.charAt(k)) {
                        cnt++;
                    }
                }
            }
            
            // P보다 바뀐게 적다면 answer++;
            if (cnt <= P) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}