import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] arr = new LinkedList[T];

        for (int i = 0; i < T; i++) {
            String[] strs = br.readLine().split("");
            arr[i] = new LinkedList<>();
            for (int j = 0; j < strs.length; j++) {
                arr[i].add(Integer.parseInt(strs[j]));
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] rotate = new int[T];
            rotate[num] = direction;

            for (int l = num - 1; l >= 0; l--) {
                if (!checkSame(arr[l], arr[l + 1])) {
                    rotate[l] = rotate[l + 1] * -1;
                } else {
                    break;
                }
            }

            for (int r = num + 1; r < T; r++) {
                if (!checkSame(arr[r - 1], arr[r])) {
                    rotate[r] = rotate[r - 1] * -1;
                } else {
                    break;
                }
            }

            for (int j = 0; j < T; j++) {
                if (rotate[j] == 1) { // 오
                    goRight(arr[j]);
                } else if (rotate[j] == -1) {
                    goLeft(arr[j]); // 왼
                }
            }
        }

        System.out.println(Arrays.stream(arr).map(list -> list.get(0)).reduce(0, Integer::sum));
    }

    public static void goLeft(LinkedList<Integer> list) {
        list.addLast(list.removeFirst());
    }

    public static void goRight(LinkedList<Integer> list) {
        list.addFirst(list.removeLast());
    }

    public static boolean checkSame(LinkedList<Integer> left, LinkedList<Integer> right) {

        return left.get(2) == right.get(6);
    }
}
