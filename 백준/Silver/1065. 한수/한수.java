import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        for (int i = 1; i <= n; i++) {

            String str = String.valueOf(i);

            if (str.length() <= 2) {
                answer++;
            } else {
                String[] arr = str.split("");
                int cha = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                boolean check = true;
                for (int j = 1; j < arr.length; j++) {
                    if (Integer.parseInt(arr[j - 1]) - Integer.parseInt(arr[j]) != cha) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
