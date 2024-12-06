import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        int[] arr = new int[26];
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine().toUpperCase();
        
        for (char c : str.toCharArray()) {
            arr[c - 'A']++;
        }
        
        int maxIdx = 0;
        int maxCnt = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxIdx] < arr[i]) {
                maxIdx = i;
                maxCnt = 1;
            } else if (arr[maxIdx] == arr[i]) {
                maxCnt++;
            }
        }
        
        if (maxCnt == 1) {
            System.out.print((char) (maxIdx + 'A'));
        } else {
            System.out.print("?");
        }
    }
}