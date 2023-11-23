class Solution {
    public String solution(int[] food) {
        String left = "";
        String right = "";
        
        for(int i = 1; i < food.length; i++) {
            for(int j = 1; j <= food[i] / 2; j++) {
                left += i;
            }
        }

        for(int i = food.length-1; i > 0; i--) {
            for(int j = 1; j <= food[i] / 2; j++) {
                right += i;
            }
        }
        
        String answer = left + "0" + right;
        
        return answer;
    }
}