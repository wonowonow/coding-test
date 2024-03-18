import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int originalMax = 0;
        for (int i = 0; i < arr.length; i++) {
            originalMax = Math.max(originalMax, arr[i]);
        }
        int max = originalMax;
        
        while (true) {
            boolean isLCM = true;
            for (int i = 0; i < arr.length; i++) {
                if (max % arr[i] != 0) {
                    max += originalMax;
                    isLCM = false;
                    break;
                }
            }
            if (isLCM) {
                break;
            }
        }
        
        return max;
    }
}