class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int i = 0; i < queries.length; i++) {
            
            for (int j = 0; j < arr.length; j++) {
                
                if (j >= queries[i][0] && j <= queries[i][1]) {
                    arr[j] += 1;
                }
            }
        }
        return arr;
    }
}