class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int i = 0; i < array.length; i++) {
            
            String[] arr = String.valueOf(array[i]).split("");
            for (String num : arr) {
                if(num.equals("7")) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}