class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" \\+ ");
        
        int plus = 0;
        int x = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // x가 있는 경우
            if (arr[i].contains("x")) {
                
                if (arr[i].length() >= 2) { // 수가 있는 경우
                    x += Integer.parseInt(arr[i].replace("x", ""));
                } else { // 수가 없는 경우
                    x++;
                }
            } else {
                
                plus += Integer.parseInt(arr[i].replace(" ", ""));
            }
        }
        
        if (x != 0) {
            if (x == 1) {
                answer += "x";
            } else {
                answer += x + "x";
            }
        }
        
        if (plus != 0) {
            
            if (answer.length() > 0) {
                answer += " + " + plus;
            } else {
                answer += plus;
            }
        }
        
        return answer;
    }
}