class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int max = numbers.length / 2;
        if(numbers.length % 2 == 0) {
            int a = (k-1) % max;
            answer = numbers[a*2];
        } else {
            int oddMax = max + 1;
            int a = (k-1) % oddMax;
            int b = (k-1) / oddMax;
            answer = numbers[(a*2+b)%numbers.length];
        }
        
        return answer;
    }
}