class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        String x = "x".repeat(k);
        String dot = ".".repeat(k);
        
        for (int i = 0; i < picture.length; i++) {
            
            answer[i * k] = picture[i].replace("x", x).replace(".", dot);
            for (int j = 1; j < k; j++) {
                answer[i * k + j] = picture[i].replace("x", x).replace(".", dot);
            }
        }
        
        return answer;
    }
}