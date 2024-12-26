import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<Integer> set = new HashSet<>();
        set.add(S); // 시작 값
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int V = Integer.parseInt(st.nextToken());
            Set<Integer> tmp = new HashSet<>();
            
            for (int CV : set) {
                int MV = CV - V; // 감소
                int PV = CV + V; // 증가
                
                if (PV <= M) { // 최대 조건
                    tmp.add(PV);
                }
                
                if (MV >= 0) { // 최소 조건
                    tmp.add(MV);
                }
            }
            
            set = tmp;
        }
        
        if (set.isEmpty()) {
            System.out.print(-1);
        } else {
            int answer = 0;
            
            for (int i : set) {
                answer = Math.max(answer, i);
            }
            
            System.out.print(answer);
        }
    }
}