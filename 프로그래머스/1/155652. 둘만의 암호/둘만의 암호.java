class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            int count = 0;
            while(count < index) {
                do {
                    c++;
                    if(c > 'z') {
                        c = 'a';
                    } 
                } while(skip.indexOf(c) != -1);
                
                count++;
            }
            
            answer += c;
        }
        
        return answer;
    }
}