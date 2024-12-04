import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cases = Integer.parseInt(br.readLine());
        int[] arr = new int[cases];
        
        for (int i = 0; i < cases; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int cut = (int) Math.round(cases * 0.15);
        
        double sum = 0;
        for (int i = cut; i < cases - cut; i++) {
            sum += arr[i];
        }
        
        System.out.println((int) Math.round(sum / (cases - cut * 2)));
    }
}