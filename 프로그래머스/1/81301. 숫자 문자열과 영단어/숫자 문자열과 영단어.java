class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // String의 replaceAll 메서드 사용
        
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(numArr[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}