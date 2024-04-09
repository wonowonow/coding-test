import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<String> twinNumList = new ArrayList<>();
        Map<String, Integer> xMap = new HashMap<>();
        
        String[] xSplit = X.split("");
        String[] ySplit = Y.split("");
        
        for (int i = 0; i < xSplit.length; i++) {
            
            if (!xMap.isEmpty() && xMap.containsKey(xSplit[i])) {
                xMap.replace(xSplit[i], xMap.get(xSplit[i]) + 1);
            } else {
                xMap.put(xSplit[i], 1);
            }
        }
        
        for (int i = 0; i < ySplit.length; i++) {
            
            if (xMap.containsKey(ySplit[i]) && xMap.get(ySplit[i]) > 0) {
                twinNumList.add(ySplit[i]);
                xMap.replace(ySplit[i], xMap.get(ySplit[i]) - 1);
            }
        }
        
        if (twinNumList.size() < 1) {
            return "-1";
        }
        
        twinNumList.sort(Comparator.reverseOrder());
        
        if(twinNumList.get(0).equals("0")) {
            return "0";
        }
        
        for(String num : twinNumList) {
            answer.append(num);
        }
        
        return answer.toString();
    }
}