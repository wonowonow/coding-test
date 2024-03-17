class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] temp = s.split(" ");
        
        for (int i = 0; i < temp.length; i++) {
            
            if (temp[i].length() == 0) {
                answer += " ";
            } else {
                String firstChar = temp[i].substring(0, 1).toUpperCase();
                String otherChar = temp[i].substring(1).toLowerCase();
                answer += firstChar + otherChar + " ";
            }
        }
        
        if (s.substring(s.length() - 1).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length() - 1);
    }
}