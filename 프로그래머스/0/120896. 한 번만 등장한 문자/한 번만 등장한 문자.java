import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<String> list = new ArrayList<>();
        
        String[] sArr = s.split("");
        
        for (int i = 0; i < sArr.length; i++) {
            
            String a = sArr[i];
            boolean isAgain = false;
            for (int j = 0; j < sArr.length; j++) {
                if (i != j) {
                    
                    if (a.equals(sArr[j])) {
                        isAgain = true;
                    }
                }
            }
            
            if (!isAgain) {
                list.add(a);
            }
        }
        
        Collections.sort(list);
        
        return String.join("", list);
    }
}