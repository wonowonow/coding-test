import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, ArrayList<String>> codi = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String genre = clothes[i][1];
            String cloth = clothes[i][0];
            
            if (codi.containsKey(genre)) {
                codi.get(genre).add(cloth);
            } else {
                ArrayList<String> c = new ArrayList<>();
                c.add(cloth);
                codi.put(genre, c);
            }
        }
        
        for (String genre : codi.keySet()) {
            answer *= codi.get(genre).size() + 1;
        }
        
        return answer - 1;
    }
}