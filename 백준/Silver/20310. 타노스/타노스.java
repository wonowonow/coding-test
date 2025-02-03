import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (char c : str.toCharArray()) {
            if (c == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        char[] chars = str.toCharArray();
        for (int i = 0 ; i < chars.length; i++) {

            if (oneCnt == 0) {
                break;
            }

            if (chars[i] == '1') {
                oneCnt--;
                chars[i] = '-';
            }
        }

        for (int i = chars.length - 1 ; i >= 0; i--) {

            if (zeroCnt == 0) {
                break;
            }

            if (chars[i] == '0') {
                zeroCnt--;
                chars[i] = '-';
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (c != '-') {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
