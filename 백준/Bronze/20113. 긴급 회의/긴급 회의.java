import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] votes = new int[N + 1];
        int skippedVotes = 0;

        for (int i = 0; i < N; i++) {
            int vote = sc.nextInt();
            if (vote == 0) {
                skippedVotes++;
            } else {
                votes[vote]++;
            }
        }
        int maxVotes = 0;
        int maxPlayer = 0;
        int maxCount = 0;
        
        for (int i = 1; i <= N; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                maxPlayer = i;
                maxCount = 1;
            } else if (votes[i] == maxVotes) {
                maxCount++;
            }
        }
        
        if (maxCount > 1 || skippedVotes > maxVotes) {
            System.out.println("skipped");
        } else {
            System.out.println(maxPlayer);
        }
    }
}