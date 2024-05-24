import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String str : record) {
            
            String[] split = str.split(" ");
            
            if (split[0].equals("Enter")) {
                map.put(split[1], split[2]);
            } else if (split[0].equals("Change")) {
                map.put(split[1], split[2]);
            }
        }
        
        for (String str : record) {
            String[] split = str.split(" ");
            if (split[0].equals("Enter") || split[0].equals("Leave")) {
                String nickname = map.get(split[1]);
                
                if (split[0].equals("Enter")) {
                    answer.add(nickname + "님이 들어왔습니다.");
                } else {
                    answer.add(nickname + "님이 나갔습니다.");
                }
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}