import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt() - 1;
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        quickSort(arr, 0, size - 1, target);
        
        System.out.println(arr[target]);
    }
    
    public static void quickSort(int[] arr, int start, int end, int target) {
        
        if (start < end) {
            int pivot = partition(arr, start, end);
            
            if (pivot == target) {
                return;
            } else if (pivot < target) {
                quickSort(arr, pivot + 1, end, target);
            } else {
                quickSort(arr, start, pivot - 1, target);
            }
        }
    }
    
    public static int partition(int[] arr, int start, int end) {
        
        if (start + 1 == end) {
            
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
                return end;
            }
        }
        
        // 중앙값 피벗 선택
        int middle = (start + end) / 2;
        swap(arr, start, middle);
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        
        while (i <= j) {
            
            while (j > start && pivot < arr[j]) {
                j--;
            }
            
            while (i <= end && pivot > arr[i]) {
                i++;
            }
            
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        
        arr[start] = arr[j];
        arr[j] = pivot;
        
        return j;
    }
    
    public static void swap(int[] arr, int i, int j) {
        
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}