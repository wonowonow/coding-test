import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int answer = 0;

        int[] intArr = new int[a];

        for(int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(Character.toString(b.charAt(i)));
            answer += intArr[i];
        }

        System.out.println(answer);
    }
}