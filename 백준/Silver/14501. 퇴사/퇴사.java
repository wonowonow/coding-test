import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());

        int[] arr = new int[days + 1];
        int answer = 0;

        for (int i = 0; i < days; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int after = i + time;
            if (after <= days) {
                for (int j = after; j <= days; j++) {
                    arr[j] = Math.max(arr[j], arr[i] + value);
                }
            }
        }

        for (int i = 0; i <= days; i++) {
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);
    }
}