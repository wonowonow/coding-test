class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxLength = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int widthNow = Math.max(sizes[i][0], sizes[i][1]);
            int lengthNow = Math.min(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, widthNow);
            maxLength = Math.max(maxLength, lengthNow);
        }
        
        return answer = maxWidth * maxLength;
    }
}