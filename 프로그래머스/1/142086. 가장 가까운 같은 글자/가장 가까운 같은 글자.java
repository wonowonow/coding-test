class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] sToArr = s.split("");
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        
        for(int i = 0; i < sToArr.length; i++) {
            
            for(int j = 0; j < sToArr.length; j++) {
                if(i < j || i == j) {
                    continue;
                }
                if(sToArr[i].equals(sToArr[j])) {
                    answer[i] = i - j;
                }
            }
        }
        return answer;
    }
}