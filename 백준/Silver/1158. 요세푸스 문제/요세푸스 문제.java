// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고,
// 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
// 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
// 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
// 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
// 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

import java.util.*;

public class Main {

    public static List<Integer> solution(int n, int k) {

        LinkedList<Integer> circle = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }
        int idx = 0;
        while (!circle.isEmpty()) {

            idx = (idx + k - 1) % circle.size();
            answer.add(circle.remove(idx));
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.print("<");
        List<Integer> answer = solution(n, k);
        int size = answer.size();
        for (int i = 0; i < size; i++) {
            int num = answer.get(i);
            if (i == size - 1) {
                System.out.print(num);
                break;
            }
            System.out.print(num + ", ");
        }
        System.out.print(">");
    }
}