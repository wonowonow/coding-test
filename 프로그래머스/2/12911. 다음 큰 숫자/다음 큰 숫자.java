class Solution {
    public int solution(int n) {
        int originalOneCount = 0;
        int oneCount = 0;
        
        String originalNStr = Integer.toBinaryString(n);
        
        for (int i = 0; i < originalNStr.length(); i++) {
            if (originalNStr.charAt(i) == '1') {
                originalOneCount++;
            }
        }
        
        int calN = n + 1;
        
        while (oneCount != originalOneCount) {
            oneCount = 0;
            String binary = Integer.toBinaryString(calN);
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    oneCount++;
                }
            }
            calN++;
        }
        
        return calN - 1;
    }
}