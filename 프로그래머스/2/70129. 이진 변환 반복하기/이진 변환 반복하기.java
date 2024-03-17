class Solution {
    
    public int[] solution(String s) {
        
        int[] answer = {0, 0};
        while (s.length() > 1) {
            
            int lengthCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    lengthCnt++;
                }
            }
            
            String binary = Integer.toBinaryString(lengthCnt);
            
            s = binary;
            answer[0]++;
        }
        
        return answer;
    }
}