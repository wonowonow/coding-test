// class Solution {
//     public String solution(String[] cards1, String[] cards2, String[] goal) {
//         String answer = "";
        
//         int cards1Count = 0;
//         int cards2Count = 0;
        
//         for(String word : goal) {
            
//             if(cards1Count < cards1.length && cards1[cards1Count].equals(word)) {
//                 cards1Count++;
//             } else if(cards2Count < cards2.length && cards2[cards2Count].equals(word)) {
//                 cards2Count++;
//             } else {
//                 return "No";
//             }
//         }
        
//         return "Yes";
//     }
// }

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int cards1Count = 0;
        int cards2Count = 0;
        
        for(int i = 0; i < goal.length; i++) {
            
            if(cards1Count < cards1.length && cards1[cards1Count].equals(goal[i])) {
                cards1Count++;
            } else if(cards2Count < cards2.length && cards2[cards2Count].equals(goal[i])) {
                cards2Count++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}