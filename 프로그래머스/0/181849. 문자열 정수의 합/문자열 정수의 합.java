class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        for (char c : num_str.toCharArray()) {
            
            answer += (int) c - 48;
        }
        
        return answer;
    }
}