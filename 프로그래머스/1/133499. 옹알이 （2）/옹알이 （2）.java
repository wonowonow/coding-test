class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String babb : babbling) {
            
            babb = babb.replace("ayaaya", "1");
            babb = babb.replace("yeye", "1");
            babb = babb.replace("woowoo", "1");
            babb = babb.replace("mama", "1");
            
            babb = babb.replace("aya", " ");
            babb = babb.replace("ye", " ");
            babb = babb.replace("woo", " ");
            babb = babb.replace("ma", " ");
            
            babb = babb.replace(" ", "");
            
            if(babb.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}