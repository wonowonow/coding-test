class Solution {
    public int solution(String s) {
        int answer = 0;
        String s2 = s;
        String s3 = s;
        
        for(int i = 0; i < s.length()-1; i++) {
            s3 = s2;
            
            for(int j = 0; j < s.length(); j++) {
                s3 = s3.replace("()", "");
                s3 = s3.replace("{}", "");
                s3 = s3.replace("[]", "");
            }
            
            if(s3.length() == 0) {
                answer++;
            }
            
            s2 = s2.substring(1) + s2.charAt(0);
        }
        return answer;
    }
}