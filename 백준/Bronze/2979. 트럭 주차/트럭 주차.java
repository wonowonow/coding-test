import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[101];
        int one = sc.nextInt();
        int two = sc.nextInt() * 2;
        int three = sc.nextInt() * 3;
        
        for (int i = 0; i < 3; i++) {
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();
            
            for (int j = startIndex; j < endIndex; j++) {
                arr[j]++;
            }
        }
        int sum = 0;
        for (int num : arr) {
            if (num == 1) {
                sum += one;
            } else if (num == 2) {
                sum += two;
            } else if (num == 3) {
                sum += three;
            }
        }
        
        System.out.print(sum);
    }
}