import java.util.*;

public class Main {
    
    static int cnt;
    static int min;
    static int max;
    static int target;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        target = sc.nextInt();
        cnt = 0;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        quickSort(arr, 0, size - 1);
        
        if (cnt < target) {
            System.out.print(-1);
        } else {
            System.out.print(min + " " + max);
        }
    }
    
    public static void quickSort(int[] arr, int l, int r) {
        
        if (l < r) {
            
            int pivot = partition(arr, l, r);
            
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }
    
    public static int partition(int[] arr, int l, int r) {
        
        int pivot = arr[r];
        int i = l - 1;
        
        for (int j = l; j < r; j++) {
            
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        if (i + 1 != r) {
            swap(arr, i + 1, r);
        }
        
        return i + 1;
    }
    
    public static void swap(int[] arr, int i, int j) {
        
        cnt++;
        if (cnt == target) {
            min = Math.min(arr[i], arr[j]);
            max = Math.max(arr[i], arr[j]);
        }
        
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}