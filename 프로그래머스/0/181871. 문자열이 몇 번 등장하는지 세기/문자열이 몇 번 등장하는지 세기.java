class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int search = 0;
        while (myString.indexOf(pat, search) != -1) {
            
            search = myString.indexOf(pat, search) + 1;
            answer++;
        }
        
        return answer;
    }
}