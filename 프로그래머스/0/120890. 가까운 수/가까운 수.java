import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int[] arr = new int[array.length];
        int idx = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            
            arr[i] = Math.abs(n - array[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] < min) {
                idx = i;
                min = arr[i];
            }
        }
        
        return array[idx];
    }
}