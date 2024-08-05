import java.util.*;

class Solution {
    
    static char[] alp = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        
        return list.indexOf(word);
    }
    
    public void dfs(String word) {
        
        list.add(word);
        
        if (word.length() >= 5) {
            return;
        }
        
        for (char c : alp) {
            dfs(word + c);
        }
    }
}