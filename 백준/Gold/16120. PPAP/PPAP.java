import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ppap = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : ppap.toCharArray()) {

            sb.append(c);

            if (sb.length() >= 4 &&
                    sb.charAt(sb.length() - 1) == 'P' &&
                    sb.charAt(sb.length() - 2) == 'A' &&
                    sb.charAt(sb.length() - 3) == 'P' &&
                    sb.charAt(sb.length() - 4) == 'P') {
                sb.delete(sb.length() - 4, sb.length());
                sb.append('P');
            }
        }

        System.out.println((sb.toString().equals("P")) ? "PPAP" : "NP");
    }
}
