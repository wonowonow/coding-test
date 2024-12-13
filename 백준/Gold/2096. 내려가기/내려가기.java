import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        
        int[] prevMax = new int[3];
        int[] prevMin = new int[3];
        int[] nowMax = new int[3];
        int[] nowMin = new int[3];
        
        
        for (int i = 0; i < size; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                prevMax[0] = prevMin[0] = a;
                prevMax[1] = prevMin[1] = b;
                prevMax[2] = prevMin[2] = c;
            } else {
                nowMax[0] = a + Math.max(prevMax[0], prevMax[1]);
                nowMax[1] = b + Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
                nowMax[2] = c + Math.max(prevMax[1], prevMax[2]);
                
                nowMin[0] = a + Math.min(prevMin[0], prevMin[1]);
                nowMin[1] = b + Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
                nowMin[2] = c + Math.min(prevMin[1], prevMin[2]);
                
                arrayCopy(prevMax, nowMax);
                arrayCopy(prevMin, nowMin);
            }
        }
        
        int max = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
        int min = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
        
        System.out.print(max + " " + min);
    }
    
    public static void arrayCopy(int[] to, int[] from) {
        
        for (int i = 0; i < to.length; i++) {
            to[i] = from[i];
        }
    }
}