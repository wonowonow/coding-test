import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            a *= a;
            b *= b;
            c *= c;
            
            if (a + b == c || a + c == b || c + b == a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}