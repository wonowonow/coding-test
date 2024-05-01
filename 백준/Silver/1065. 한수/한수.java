import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        for (int i = 1; i <= n; i++) {

            String str = String.valueOf(i);

            if (str.length() == 1 || str.length() == 2) {
                answer++;
            } else if (str.length() == 3) {
                String[] arr = str.split("");
                int cha = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                if (Integer.parseInt(arr[1]) - Integer.parseInt(arr[2]) == cha) {
                    answer++;
                }
            } else if (str.length() == 4) {
                String[] arr = str.split("");
                int cha = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                if (Integer.parseInt(arr[1]) - Integer.parseInt(arr[2]) == cha) {
                    if (Integer.parseInt(arr[2]) - Integer.parseInt(arr[3]) == cha) {
                        answer++;
                    }
                }
            }
        }

        System.out.print(answer);
    }

}
