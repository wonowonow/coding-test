import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {

            String key = keymap[i];

            for (int j = 0; j < key.length(); j++) {

                if (!hashMap.containsKey(key.charAt(j))) {
                    hashMap.put(key.charAt(j), j + 1);
                }
                if (hashMap.containsKey(key.charAt(j)) && hashMap.get(key.charAt(j)) > j + 1) {
                    hashMap.put(key.charAt(j), j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {

            String target = targets[i];

            for (int e = 0; e < target.length(); e++) {

                if (hashMap.containsKey(target.charAt(e))) {
                    answer[i] += hashMap.get(target.charAt(e));
                }
                
                if (!hashMap.containsKey(target.charAt(e))) {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}