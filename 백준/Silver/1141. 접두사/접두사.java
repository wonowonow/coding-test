import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        int cnt = 1;

        for (int i = 1; i < size; i++) {
            if (!arr[i].startsWith(arr[i - 1])) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
