import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringBuilder sb = new StringBuilder();
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            
            if (num.equals(sb.append(num).reverse().toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}