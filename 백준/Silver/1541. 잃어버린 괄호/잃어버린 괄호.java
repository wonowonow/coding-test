import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] A = br.readLine().split("-");

        for (int i = 0; i < A.length; i++) {

            int temp = getSum(A[i]);

            if (i == 0) {
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
    }

    private static int getSum(String a) {
        
        int sum = 0;
        String temp[] = a.split("[+]");
        
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        
        return sum;
    }
}