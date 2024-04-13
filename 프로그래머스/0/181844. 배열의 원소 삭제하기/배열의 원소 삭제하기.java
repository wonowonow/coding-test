import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int delete : delete_list) {
            deleteSet.add(delete);
        }
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                list.add(num);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}