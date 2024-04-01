class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr2.length > arr1.length) {
            return -1;
        }
        
        int arr1Sum = 0;
        int arr2Sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1Sum += arr1[i];
            arr2Sum += arr2[i];
        }
        
        if (arr1Sum > arr2Sum) {
            return 1;
        } else if (arr2Sum > arr1Sum) {
            return -1;
        }
        
        return answer;
    }
}