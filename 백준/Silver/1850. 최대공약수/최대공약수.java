import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = gcb(a, b);
        
        while (result > 0) {
            bw.write("1");
            result--;
        }
        
        bw.flush();
        
    }
    
    public static long gcb(long a, long b) {
        
        if (b == 0) {
            return a;
        } else {
            return gcb(b, a % b);
        }
    }
}