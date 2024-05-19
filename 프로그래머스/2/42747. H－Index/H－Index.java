class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 연습 한 Quick Sort ㄱㄱ
        quickSort(citations, 0, citations.length - 1);
        
        int size = citations.length;
        
        for (int i = 0; i < size; i++) {
            
            answer = Math.max(Math.min(size - i, citations[i]), answer);
        }
        
        return answer;
    }
    
    public void quickSort(int[] arr, int l, int r) {
        
        if (l < r) {
            
            int pivot = partition(arr, l, r);
            
            quickSort(arr, pivot + 1, r);
            quickSort(arr, l, pivot - 1);
        }
    }
    
    public int partition(int[] arr, int l, int r) {
        
        int pivot = arr[r];
        int i = l - 1;
        
        for (int j = l; j < r; j++) {
            
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, r);
        
        return i + 1;
    }
    
    public void swap(int[] arr, int i, int j) {
        
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}