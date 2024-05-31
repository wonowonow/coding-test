import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        
        String add = "";
        
        while (my_str.length() > 0) {
            
            if (my_str.length() > n) {
                add = my_str.substring(0, n);
                my_str = my_str.substring(n);
                list.add(add);
            } else {
                list.add(my_str);
                my_str = "";
            }
        }
        
        return list.stream().toArray(String[]::new);
    }
}