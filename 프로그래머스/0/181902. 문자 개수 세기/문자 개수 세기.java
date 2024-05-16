class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (char c : my_string.toCharArray()) {
            
            if ('a' <= c && c <= 'z') {
                int i = c - 'a' + 26;
                answer[i]++;
            } else {
                int i = c - 'A';
                answer[i]++;
            }
        }
        
        return answer;
    }
}