class Solution {
    public String solution(int[] food) {
        String left = "";
        String right = "";
        
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                left += i;
            }
        }
        
        System.out.println(left);

        for(int i = food.length-1; i > 0; i--) {
            for(int j = 0; j < food[i] / 2; j++) {
                right += i;
            }
        }
        
        System.out.print(right);
        
        String answer = left + "0" + right;
        
        return answer;
    }
}