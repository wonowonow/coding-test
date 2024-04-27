class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = s.split(" ");
        
        for (int i = 0; i < arr.length; i++) {
            
            if (i + 1 < arr.length && arr[i + 1].equals("Z")) {
                i++;
                continue;
            } else {
                answer += Integer.parseInt(arr[i]);
            }
        }
        
        return answer;
    }
}