class Solution {
    public int[] solution(int[] arr, int n) {
        int size = arr.length;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (size % 2 == 0) {
                if (i % 2 != 0) {
                    arr[i] += n;
                }
            } else {
                if (i % 2 == 0) {
                    arr[i] += n;
                }
            }
        }
        
        return arr;
    }
}