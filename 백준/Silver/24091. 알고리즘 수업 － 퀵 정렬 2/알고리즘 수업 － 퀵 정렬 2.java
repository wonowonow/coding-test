import java.util.*;

public class Main {
    
    static int cnt;
    static int target;
    static ArrayList<Integer> snapshot = new ArrayList<>();
    
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
        
        if (snapshot.isEmpty()) {
            System.out.print(-1);
        } else {
            for (int num : snapshot) {
                System.out.print(num + " ");
            }
        }
    }
    
    public static void quickSort(int[] arr, int l, int r) {
        
        if (snapshot.isEmpty() && l < r) {
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
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        
        if (cnt == target) {
            
            for (int num : arr) {
                snapshot.add(num);
            }
        }
    }
}