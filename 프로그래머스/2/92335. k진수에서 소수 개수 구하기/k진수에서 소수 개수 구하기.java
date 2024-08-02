class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String zin = Integer.toString(n, k);
        
        String[] arr = zin.split("0");
        
        for (String s : arr) {
            if (s.isEmpty()){
                continue;
            }
            Long num = Long.parseLong(s);
            if (num >= 2) {
                if (isPrime(num)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(Long a) {
        
        if (a == 1) {
            return false;
        }
        
        if (a == 2) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}