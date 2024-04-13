import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < num_list.length; i++) {
            
            if (n >= 3) {
                
                if (i < slicer[0] || i > slicer[1]) {
                    continue;
                }
                list.add(num_list[i]);
                if (n == 4) {
                    i += slicer[2] - 1;
                }
            }
            
            if (n == 1) {
                list.add(num_list[i]);
                if (i == slicer[1]) {
                    break;
                }
            }
            
            if (n == 2) {
                if (i < slicer[0]) {
                    continue;
                }
                list.add(num_list[i]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}