class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] sum = new int[3];
        int cnt = 0;
        String value = "";
        
        for (char c : dartResult.toCharArray()) {
            
            if ('0' <= c && c <= '9') {
                value += String.valueOf(c);
            }
            
            if (c == 'S' || c == 'D' || c == 'T') {
                int n = Integer.parseInt(value);
                if (c == 'S') {
                    sum[cnt++] = (int) Math.pow(n, 1);
                } else if (c == 'D') {
                    sum[cnt++] = (int) Math.pow(n, 2);
                } else if (c == 'T') {
                    sum[cnt++] = (int) Math.pow(n, 3);
                }
                value = "";
            }
            
            if (c == '*') {
                sum[cnt - 1] *= 2;
                if (cnt - 2 >= 0) {
                    sum[cnt - 2] *= 2;
                }
            } else if (c == '#') {
                sum[cnt - 1] *= (-1);
            }
        }
        
        answer = sum[0] + sum[1] + sum[2];
        
        return answer;
    }
}