import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        int spy1 = 10;
        int spy2 = 11;
        boolean check = false;
        
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 1; i++) {
            
            if (check) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {

                if (sum - (arr[i] + arr[j]) == 100) {
                    spy1 = i;
                    spy2 = j;
                    check = true;
                    break;
                }
            }
            
        }
        
        for (int i = 0; i < 9; i++) {
            
            if (i != spy1 && i != spy2) {
                System.out.println(arr[i]);
            }
        }
    }
}