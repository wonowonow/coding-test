import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] sToStrArr = s.split("");
        char[] sToCharArr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int charInt = sToStrArr[i].charAt(0);
            if (charInt == ' ') {
                sToCharArr[i] = (char)charInt;
                continue;
            }
            // 범위 넘어가면 다시 빼기
            if (('A' <= charInt && charInt <= 'Z') && (charInt+n > 'Z')) {
                charInt -= 26;
            } else if (('a' <= charInt && charInt <= 'z') && (charInt+n > 'z')) {
                charInt -= 26;
            }
            for (int j = 0; j < n; j++) {
                charInt++;
                sToCharArr[i] = (char)charInt;
            }
        }
        answer = new String(sToCharArr);
        System.out.print(answer);
        
        return answer;
    }
}