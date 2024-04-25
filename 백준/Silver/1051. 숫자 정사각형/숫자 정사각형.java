import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int solution(int[][] arr) {
        int answer = 0;
        int y = arr.length;
        int x = arr[0].length;
        int max = Math.max(y, x);

        for (int k = 0; k < max; k++) { // 정사각형 크기 결정 요소

            for (int i = 0; i < arr.length; i++) { // 여기랑 밑에 정사각형 크기보다 넘으면 안됨

                for (int j = 0; j < arr[i].length; j++) {
                    int m = arr[i][j];
                    if (i + k < arr.length && j + k < arr[i].length) {
                        if (m == arr[i+k][j] && m == arr[i][j+k] && m == arr[i+k][j+k]) {
                            answer = Math.max(answer, (k+1) * (k+1));
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] arr = new int[y][x];

        for (int i = 0; i < y; i++) {

            st = new StringTokenizer(br.readLine());
            String[] strArr = st.nextToken().split("");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        System.out.println(solution(arr));
    }
}