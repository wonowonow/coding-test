import java.util.*;

class Solution {
    public int solution(String before, String after) {
        String[] brr = before.split("");
        String[] arr = after.split("");
        
        Arrays.sort(brr);
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            if (!brr[i].equals(arr[i])) {
                return 0;
            }
        }
        
        return 1;
    }
}