class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = t.length() - p.length();
        Long pToInt = Long.parseLong(p);
        
        if(length < 0) {
            return answer;
        }
        
        for(int i = 0; i <= length; i++) {
            
            Long tSubStrToInt = Long.parseLong(t.substring(i,i+p.length()));
            
            if(tSubStrToInt <= pToInt) answer++;
        }
        
        return answer;
    }
}