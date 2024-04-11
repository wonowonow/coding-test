class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int oriNumer1 = numer1;
        int oriNumer2 = numer2;
        int oriDenom1 = denom1;
        int oriDenom2 = denom2;
        
        while(denom1 != denom2) {
            if (denom1 > denom2) {
                denom2 += oriDenom2;
                numer2 += oriNumer2;
            } else {
                denom1 += oriDenom1;
                numer1 += oriNumer1;
            }
        }
        
        int sum = numer1 + numer2;
        int gcb = gcb(sum, denom1);
        
        answer[0] = sum / gcb;
        answer[1] = denom1 / gcb;
        
        return answer;
    }
    
    public int gcb(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}