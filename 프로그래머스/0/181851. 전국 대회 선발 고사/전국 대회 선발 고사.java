import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        List<Student> list = new ArrayList<>();
        
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                list.add(new Student(i, rank[i]));
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o1.rank - o2.rank;
        });
        
        return list.get(0).idx * 10000 + list.get(1).idx * 100 + list.get(2).idx;
    }
}

class Student {
    int idx;
    int rank;
    
    public Student(int idx, int rank) {
        this.idx = idx;
        this.rank = rank;
    }
}