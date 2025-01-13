import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String original = br.readLine();
        String target = br.readLine();

        for (char c : original.toCharArray()) {
            stack.push(c);
            if (stack.size() >= target.length()) {
                boolean flag = true;
                for (int i = 0; i < target.length(); i++) {
                    if (stack.get(stack.size() - target.length() + i) != target.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < target.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(stack.isEmpty() ? "FRULA" : sb.toString());
    }

}
