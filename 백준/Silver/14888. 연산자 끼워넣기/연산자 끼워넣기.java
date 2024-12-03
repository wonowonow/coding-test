import java.util.*;
import java.io.*;

public class Main {
    
    static int[] numbers;
    static int[] maths = new int[4];
    static int[] answers = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        numbers = new int[size];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            maths[i] = Integer.parseInt(st.nextToken());
        }

        answers[0] = Integer.MIN_VALUE;
        answers[1] = Integer.MAX_VALUE;

        dfs(numbers[0], 0, maths[0], maths[1], maths[2], maths[3]);
        
        for (int i = 0; i < 2; i++) {
            System.out.println(answers[i]);
        }

    }

    public static void dfs(int sum, int depth, int plus, int minus, int multi, int div) {

        if (depth == numbers.length - 1) {
            answers[0] = Math.max(answers[0], sum);
            answers[1] = Math.min(answers[1], sum);
            return;
        }
        
        depth++;

        if (plus > 0) {
            dfs(sum + numbers[depth], depth, plus - 1, minus, multi, div);
        }
        if (minus > 0) {
            dfs(sum - numbers[depth], depth, plus, minus - 1, multi, div);
        }
        if (multi > 0) {
            dfs(sum * numbers[depth], depth, plus, minus, multi - 1, div);
        }
        if (div > 0) {
            dfs(sum / numbers[depth], depth, plus, minus, multi, div - 1);
        }
    }
}