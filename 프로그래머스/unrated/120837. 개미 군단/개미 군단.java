class Solution {
    public int solution(int hp) {
        int answer = 0; 
        
        for(int i = 0; i < 10000; i++) {
            
            if(hp - 5 >= 0) {
                answer++;
                hp -= 5;
            } else if(hp - 3 >= 0) {
                answer++;
                hp -= 3;
            } else if(hp - 1 >= 0) {
                answer++;
                hp -= 1;
            }
            
            if(hp == 0) {
                break;
            }
        }

        return answer;
    }
}