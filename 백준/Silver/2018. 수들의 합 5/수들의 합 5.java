import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 자연수 N의 연속된 자연수의 합을 나타내는 것
        // 이떄 사용하는 자연수는 N 이하여야한다.
        // ex. 15 = 15, 7+8, 4+5+6, 1+2+3+4+5
        // 투포인터 문제

        Scanner sc = new Scanner(System.in);

        // 첫 줄에 정수 N이 주어진다.
        int N = sc.nextInt();

        // 입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 구해라.
        // 시간제한 2초 N <= 10,000,000
        // log(n) 으로 풀어야한다.

        // startIndex, endIndex, sum 개념 존재
        // 투포인터 이동원칙
        // sum > N: sum = sum - startIndex; / startIndex++;
        // sum < N: endIndex++; / sum = sum + endIndex;
        // sum == N: endIndex++; / sum = sum + endIndex; / count++;

        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != N) {
            if(sum > N) {
                sum = sum - startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum = sum + endIndex;
            } else {
                endIndex++;
                sum = sum + endIndex;
                count++;
            }
        }
        System.out.println(count);
    }
}