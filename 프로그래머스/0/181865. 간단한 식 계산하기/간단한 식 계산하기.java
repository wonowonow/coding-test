class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] arr = returnArr(binomial);
        
        if (binomial.contains("+")) {
            answer = Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]);
        } else if (binomial.contains("-")) {
            answer = Integer.valueOf(arr[0]) - Integer.valueOf(arr[1]);
        } else {
            answer = Integer.valueOf(arr[0]) * Integer.valueOf(arr[1]);
        }
        
        return answer;
    }
    
    public String[] returnArr(String str) {
        
        return str.replaceAll("[^0-9]", " ").split("   ");
    }
}