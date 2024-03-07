import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int canTake = nums.length / 2;
        
        Set<Integer> numsSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            numsSet.add(nums[i]);
        }
        
        int setSize = numsSet.size();
        
        if (setSize > canTake) {
            answer = canTake;
        } else {
            answer = setSize;
        }
        
        return answer;
    }
}