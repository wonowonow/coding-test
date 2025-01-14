import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> stack = new Stack<>();
        long n = Long.parseLong(br.readLine());
        long answer = 0;

        for (int i = 0; i < n; i++) {
            long now = Long.parseLong(br.readLine());
            long cnt = 1;

            // 같거나 클 때
            while (!stack.isEmpty() && stack.peek().val <= now) {
                answer += stack.peek().cnt;
                // 같으면
                if (stack.peek().val == now) {
                    cnt = stack.peek().cnt + 1;
                } else { // 크면
                    cnt = 1;
                }
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(new Node(now, cnt));
        }

        System.out.println(answer);
    }


    public static class Node {

        long val;
        long cnt;

        public Node(long val, long cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
