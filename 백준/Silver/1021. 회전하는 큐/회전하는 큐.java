import java.util.*;

public class Main {

    public static void main(String[] args) {

        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {

            deque.add(i);
        }

        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            list.add(sc.nextInt());
        }

        while (!list.isEmpty()) {

            int target = list.get(0);
            int targetIndex = 0;
            int[] arr = new int[deque.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = deque.pollFirst();
                if (target == arr[i]) {
                    targetIndex = i;
                }
            }

            for (int i = 0; i < arr.length; i++) {

                deque.add(arr[i]);
            }

            int r = arr.length - targetIndex;

            if (r > targetIndex) {
                answer += targetIndex;

                for (int i = 0; i < targetIndex; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                answer += r;

                for (int i = 0; i < r; i++) {

                    deque.addFirst(deque.pollLast());
                }
            }
            deque.pollFirst();
            list.remove(0);
        }

        System.out.println(answer);
    }

}
