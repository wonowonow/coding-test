import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            
            String call = callings[i];
            
            int now = map.get(call);
            String front = players[now - 1];
            
            map.replace(front, now);
            players[now] = front;
            
            map.replace(call, now - 1);
            players[now - 1] = call;
        }
        
        return players;
    }
}