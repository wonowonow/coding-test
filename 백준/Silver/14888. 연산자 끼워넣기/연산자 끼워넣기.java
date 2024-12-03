import java.util.*;
import java.io.*;

public class Main {
    
    static int[] numbers;
    static int[] maths = new int[4];
    static int[] answers = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 주어지는 숫자의 갯수
        int size = Integer.parseInt(st.nextToken());
        numbers = new int[size];
        // 주어지는 숫자
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // 덧셈 뺄셈 곱셈 나눗셈 갯수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            maths[i] = Integer.parseInt(st.nextToken());
        }

        // 하기 전 answers 초기화
        answers[0] = Integer.MIN_VALUE;
        answers[1] = Integer.MAX_VALUE;

        for (int i = 0; i < maths.length; i++) {

            if (maths[i] > 0) {
                maths[i]--;
                dfs(numbers[0], 1, i);
                maths[i]++;
            }
        }

        // 정답 출력
        for (int i = 0; i < 2; i++) {
            System.out.println(answers[i]);
        }

    }

    public static void dfs(int sum, int depth, int type) {
        // 주어진 수의 순서를 바꾸면 안 된다.
        // depth 가 있는 이유
        if (type == 0) {
            sum += numbers[depth];
        } else if (type == 1) {
            sum -= numbers[depth];
        } else if (type == 2) {
            sum *= numbers[depth];
        } else if (type == 3) {
            sum /= numbers[depth];
        }

        if (depth == numbers.length - 1) {
            answers[0] = Math.max(answers[0], sum);
            answers[1] = Math.min(answers[1], sum);
            return;
        }

        for (int i = 0; i < maths.length; i++) {

            if (maths[i] > 0) {
                maths[i]--;
                dfs(sum, depth + 1, i);
                maths[i]++;
            }
        }
    }
}