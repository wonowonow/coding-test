import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][2];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int answer = 0;
        int min = arr[0][0];
        int max = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (max >= arr[i][0]) {
                max = Math.max(arr[i][1], max);
            } else {
                answer += max - min;
                min = arr[i][0];
                max = arr[i][1];
            }
        }
        answer += max - min;
        System.out.println(answer);
    }
}
