class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] arr = my_string.replaceAll("[^0-9]", " ").split(" ");
        
        for (String s : arr) {
            if (!s.isEmpty()) {
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}