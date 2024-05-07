class Solution {
    public int[] solution(int[] arr) {
        double size = 2;
        int sq = 0;
        
        while (Math.pow(size, sq) < arr.length) {
            sq++;
        }
        
        size = Math.pow(size, sq);
        
        int[] answer = new int[(int)size];
        
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}