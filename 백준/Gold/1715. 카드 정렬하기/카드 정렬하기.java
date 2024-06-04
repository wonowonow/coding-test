import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int answer = 0;
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            cards.add(sc.nextInt());
        }

        while (cards.size() > 1) {

            int a = cards.poll();
            int b = cards.poll();
            answer += a + b;
            cards.add(a + b);
        }

        System.out.print(answer);
    }
}