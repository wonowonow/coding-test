class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int otherCount = 0;
        
        char x = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++) {
            
            if(x != s.charAt(i)) {
                otherCount++;
            } else {
                sameCount++;
            }
            
            if(otherCount == sameCount) {
                answer++;
                otherCount = 0;
                sameCount = 0;
                if(s.length() > i+1) {
                    x = s.charAt(i+1);
                }
            }
            
            if(otherCount != sameCount && i == s.length()-1) {
                answer++;
            }
        }
        
        return answer;
    }
}