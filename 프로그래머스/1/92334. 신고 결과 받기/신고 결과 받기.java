import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 1. 중복 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 2. 특정 유저에 대한 신고를 담는... 그런 것
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (String r : reportSet) {
            String[] arr = r.split(" ");
            String to = arr[1];
            String from = arr[0];
            
            if (map.containsKey(to)) {
                map.get(to).add(from);
            } else {
                ArrayList<String> fromList = new ArrayList<>();
                fromList.add(from);
                map.put(to, fromList);
            }
        }
        
        // 3. List Size 가 k 이상일 때 해당 리스트에 있는 id에 메일 ㄱㄱ
        Map<String, Integer> mailCnt = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            // 신고 받은 사람 map 에서 검색 && k 이상 신고 받았다면?
            String id = id_list[i];
            if (map.containsKey(id) && map.get(id).size() >= k) {
                // 메일 카운트에 신고한 사람 메일 받을 갯수 올려줌
                for (String from : map.get(id)) {
                    mailCnt.put(from, mailCnt.getOrDefault(from, 0) + 1);
                }
            }
        }
        // answer[i] 에다가 채울 시간
        // mailCnt 에 있으면 ㄱㄱ
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if (mailCnt.containsKey(id)) {
                answer[i] = mailCnt.get(id);
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}