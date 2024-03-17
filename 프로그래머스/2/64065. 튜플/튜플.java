import java.util.*;

class Solution {
    
    static String[] sSplit;
    
    public int[] solution(String s) {
        // 1. s에서 "{{", "}}" 를 다 지운다.
        s = s.substring(2);
        s = s.substring(0, s.length() - 2);
        
        // 2. },{ 가 있다면 이걸 기준으로 split을 한다. / 없다면 s 반환
        if (s.contains("},{")) {
            sSplit = s.split("\\},\\{");
        } else {
            int[] answer = new int[1];
            answer[0] = Integer.parseInt(s);
            return answer;
        }
        
        // 3. split 한 Array 를 Array 길이 기준으로 정렬을 한다.
        Arrays.sort(sSplit, new Comparator<String>() {
            public int compare(String o1, String o2) {
                
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        // 4. Array for 문을 돌리면서 , 기준으로 스플릿 -> 그 배열을 또 for문 돌리면서 ArrayList 에 번호가 없다면 넣는다.
        
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < sSplit.length; i++) {
            
            String[] addSplit = sSplit[i].split(",");
            for (int j = 0; j < addSplit.length; j++) {
                
                if (!ansList.contains(addSplit[j])) {
                    ansList.add(addSplit[j]);
                }
            }
        }
        
        // 5. ArrayList에 담긴 순서대로 answer에 채운다. (answer 사이즈는 ArrayList size)
    
        int[] answer = new int[ansList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(ansList.get(i));
        }
        
        return answer;
    }
}