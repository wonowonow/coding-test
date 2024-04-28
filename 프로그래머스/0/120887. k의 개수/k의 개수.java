class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int u = i; u <= j; u++) {
            
            String val = String.valueOf(u);
            
            if (val.contains(String.valueOf(k))) {
                
                String[] arr = val.split("");
                for (String num : arr) {
                    if (num.equals(String.valueOf(k))) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}