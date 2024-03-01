import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄 표의 크기 N / 구하는 횟수 M
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(stringTokenizer.nextToken());
        int guess = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[arrSize + 1][arrSize + 1];
        // 둘째 줄 N개의 줄 1행부터 마지막행 끝까지
        for(int i = 1; i <= arrSize; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 1; j <= arrSize; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 2차원 합 배열 만들기
        int[][] sumArr = new int[arrSize + 1][arrSize + 1];
        for(int i = 1; i <= arrSize; i++) {
            for(int j = 1; j <= arrSize; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + arr[i][j];
            }
        }

        // 뒤 부턴 구하는 횟수 x1 y1 x2 y2
        for(int i = 0; i < guess; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int answer = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            System.out.println(answer);
        }
    }
}