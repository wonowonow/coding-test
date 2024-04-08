import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> table = new HashMap<>();
        int[] giftScore = new int[friends.length];
        int[] giftSum = new int[friends.length];
        
        // 선물 DB 셋팅
        for (String name : friends) {
            
            for (String friend : friends) {
                if (table.containsKey(name)) {
                    table.get(name).put(friend, 0);
                } else {
                    table.put(name, new HashMap<>());
                    table.get(name).put(friend, 0);
                }
            }
        }
        for (String history : gifts) {
            String[] fromTo = history.split(" ");
            String from = fromTo[0];
            String to = fromTo[1];
            int giftCnt = table.get(from).get(to);
            table.get(from).replace(to, giftCnt + 1);
        }
        
        // 선물 지수
        for (int i = 0; i < friends.length; i++) {
            
            String name = friends[i];
            
            for (String main : table.keySet()) {
                if (main.equals(name)) {
                    
                    for (String friend : table.get(main).keySet()) {
                        giftScore[i] += table.get(main).get(friend);
                    }
                } else {
                    
                    for (String friend : table.get(main).keySet()) {
                        
                        if (friend == name) {
                            giftScore[i] -= table.get(main).get(friend);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < friends.length; i++) {
            
            for (int j = 0; j < friends.length; j++) {
                String me = friends[i];
                String you = friends[j];
                
                if (me != you) {
                    int meCnt = table.get(me).get(you);
                    int youCnt = table.get(you).get(me);
                    
                    if (meCnt == youCnt) {
                        
                        if (giftScore[i] > giftScore[j]) {
                            giftSum[i]++;
                        } else if (giftScore[i] < giftScore[j]) {
                            giftSum[j]++;
                        }
                    } else if (meCnt > youCnt) {
                        giftSum[i]++;
                    } else if (meCnt < youCnt) {
                        giftSum[j]++;
                    }
                }
            }
        }

        for (int ea : giftSum) {
            answer = Math.max(ea, answer);
        }
        
        return answer / 2;
    }
}