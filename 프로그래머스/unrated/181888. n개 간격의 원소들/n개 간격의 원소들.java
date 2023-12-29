class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(num_list.length + n -1) / n];
        
        for(int i = 0; i < answer.length; i++){
            if(i * n > num_list.length){
                break;
            }
            
            answer[i] = num_list[i*n];
        } 
        
        return answer;
    }
}