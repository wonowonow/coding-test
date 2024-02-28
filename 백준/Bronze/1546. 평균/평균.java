import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scoresInt = new int[N];

        for(int i = 0; i < scoresInt.length; i++) {

            scoresInt[i] = scanner.nextInt();
        }

        long maxScore = 0;
        long scoreSum = 0;

        for(int i = 0; i < scoresInt.length; i++) {

            maxScore = Math.max(maxScore, scoresInt[i]);
            scoreSum = scoreSum + scoresInt[i];
        }

        System.out.println(scoreSum * 100.0 / maxScore / N);
    }
}