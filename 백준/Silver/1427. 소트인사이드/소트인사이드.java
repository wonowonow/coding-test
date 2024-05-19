import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split("");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }


        for (int i = 0; i < arr.length; i++) {

            int max = Integer.MIN_VALUE;
            int idx = 0;

            for (int j = i; j < arr.length; j++) {

                if (arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }

            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}