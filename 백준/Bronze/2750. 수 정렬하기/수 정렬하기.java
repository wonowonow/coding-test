import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int size = arr.length - 1;
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < size; j++) {
                if (arr[j] > arr[j + 1]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            size--;
        }
        
        for (int i = 0; i < arr.length; i++) {
            
            System.out.println(arr[i]);
        }
    }
}