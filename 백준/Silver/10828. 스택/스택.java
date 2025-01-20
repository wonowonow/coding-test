import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            if (str.equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }

            if (str.equals("size")) {
                System.out.println(stack.size());
            }

            if (str.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }

            if (str.equals("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}
