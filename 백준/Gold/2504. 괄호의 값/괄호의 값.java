import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();

        String[] arr = br.readLine().split("");

        int answer = 0;
        int multi = 1;

        for (int i = 0; i < arr.length; i++) {

            if (isOpen(arr[i])) {
                multi *= getNum(arr[i]);
            }

            if (!stack.isEmpty()) {
                if (getNum(stack.peek(), arr[i]) != 0) {
                    int num = getNum(stack.pop(), arr[i]);
                    if (getNum(arr[i - 1], arr[i]) != 0) {
                        answer += multi;
                    }
                    multi /= num;
                } else {
                    stack.push(arr[i]);
                }
            } else {
                stack.push(arr[i]);
            }
        }

        if (stack.isEmpty()) {
            System.out.print(answer);
        } else {
            System.out.print("0");
        }


    }

    public static boolean isOpen(String str) {

        return str.equals("(") || str.equals("[");
    }

    public static int getNum(String before, String now) {

        if (before.equals("(") && now.equals(")")) {
            return 2;
        }

        if (before.equals("[") && now.equals("]")) {
            return 3;
        }

        return 0;
    }

    public static int getNum(String now) {

        if (now.equals("(")) {
            return 2;
        } else {
            return 3;
        }
    }

}