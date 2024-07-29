import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static Deque<Integer> deque;
    static boolean first;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            System.out.println(AC());
        }
    }

    public static String AC() throws IOException {

        first = true;
        deque = new LinkedList<>();

        String[] controls = br.readLine().trim().split("");

        int arrSize = Integer.parseInt(br.readLine().trim());

        String arrSt = br.readLine().trim();

        String[] arr;

        if (arrSize == 0) {
            arr = new String[0];
        } else if (arrSize == 1) {
            arrSt = arrSt.substring(1, arrSt.length() - 1);
            arr = new String[1];
            arr[0] = arrSt;
        } else {
            arrSt = arrSt.substring(1, arrSt.length() - 1);
            arr = arrSt.split(",");
        }

        for (int i = 0; i < arr.length; i++) {
            deque.add(Integer.parseInt(arr[i]));
        }

        for (String control : controls) {

            if (control.equals("R")) {
                first = !first;
            } else {

                if (deque.size() <= 0) {
                    return "error";
                }

                if (first) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int dequeSize = deque.size();
        for (int i = 0; i < dequeSize; i++) {
            if (i == dequeSize - 1) {
                if (first) {
                    sb.append(deque.pollFirst());
                } else {
                    sb.append(deque.pollLast());
                }
            } else {
                if (first) {
                    sb.append(deque.pollFirst()).append(",");
                } else {
                    sb.append(deque.pollLast()).append(",");
                }
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
