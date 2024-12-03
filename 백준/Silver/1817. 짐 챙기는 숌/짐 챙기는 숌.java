import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int jims = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[jims];

        for (int i = 0; i < jims; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < jims; i++) {

            sum += arr[i];

            if (sum > target) {
                answer++;
                sum = arr[i];
            } else if (sum == target) {
                answer++;
                sum = 0;
            }
        }

        if (sum > 0) {
            answer++;
        }

        System.out.print(answer);
    }
}