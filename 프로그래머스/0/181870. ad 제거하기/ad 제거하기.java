import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        return Arrays.stream(strArr).filter(o -> !o.contains("ad")).toArray(String[]::new);
    }
}