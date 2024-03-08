class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            
            for (int j = i + 1; j < nums.length; j++) {
                
                for (int k = j + 1; k < nums.length; k++) {
                    
                    int number = nums[i] + nums[j] + nums[k];
                    
                    if (isSosu(number)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public boolean isSosu(int number) {
        if (number == 2) {
            return true;
        }
        
        for (int i = 2; i < number; i++) {
            
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}