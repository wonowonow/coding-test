import java.util.*;
import java.io.*;

public class Main {
    
    static int[] arr;
    static int[] tmp;
    
    // 병합 정렬
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = Integer.parseInt(br.readLine());
        arr = new int[size];
        tmp = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(0, size - 1);
        
        for (int i = 0; i < size; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    public static void mergeSort(int l, int r) {
        
        if (l < r) {
            
            int m = l + (r - l) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            
            merge(l, m, r);
        }
    }
    
    public static void merge(int l, int m, int r) {
        
        for (int i = l; i <= r; i++) {
            tmp[i] = arr[i];
        }
        
        int k = l;
        int in1 = l;
        int in2 = m + 1;
        
        while (in1 <= m && in2 <= r) {
            
            if (tmp[in1] <= tmp[in2]) {
                arr[k] = tmp[in1];
                in1++;
            } else {
                arr[k] = tmp[in2];
                in2++;
            }
            k++;
        }
        
        while (in1 <= m) {
            arr[k] = tmp[in1];
            in1++;
            k++;
        }
        
        while (in2 <= r) {
            arr[k] = tmp[in2];
            in2++;
            k++;
        }
    }
}