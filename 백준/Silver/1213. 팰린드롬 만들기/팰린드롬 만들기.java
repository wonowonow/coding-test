import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[26];

        String str = sc.nextLine();

        for (char c : str.toCharArray()) {
            arr[(int) c - 'A']++;
        }

        int oddCnt = 0;
        int middle = 27;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCnt++;
                middle = i;
            }
        }

        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < arr.length; i++) {

                for (int j = 0; j < arr[i] / 2; j++) {
                    sb.append((char)(i + 'A'));
                }
            }
            String l = sb.toString();
            String r = sb.reverse().toString();

            if (middle == 27) {
                System.out.println(l + r);
            } else {
                System.out.println(l + ((char)(middle+'A')) + r);
            }

        }
    }
}