import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = myStr.split("[a-c]");
        List<String> list = new ArrayList<>();
        
        for (String str : arr) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        
        if (list.isEmpty()) {
            list.add("EMPTY");
        }
        
        return list.stream().toArray(String[]::new);
    }
}