import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String KKRKK = br.readLine();

        List<Integer> lk = new ArrayList<>(); // 왼쪽 K
        List<Integer> rk = new ArrayList<>(); // 오른쪽 K

        int cnt = 0;
        for (char c : KKRKK.toCharArray()) {
            if (c == 'K') {
                cnt++; // K 갯수 카운트
            } else {
                lk.add(cnt); // R 나오면 리스트에 저장
                // cnt 는 초기화 하지 않는다. 이유는 부분 수열이기 때문에 중간에 R을 떼어내어 다시 계산 할 수 있기 때문
            }
        }

        cnt = 0;
        for (int i = KKRKK.length() - 1; i >= 0; i--) {
            if (KKRKK.charAt(i) == 'K') {
                cnt++;
            } else {
                rk.add(cnt);
            }
        }
        Collections.reverse(rk); // 역순으로 저장해서 다시 돌리기

        int l = 0;
        int r = lk.size() - 1;
        int answer = 0;
        while (l <= r) {
            // R 로만 이루어진 중심 길이 + 왼K 오K 중 작은 것 (같은 수로 감쌀 수 있어야 하니까) * 2
            int len = r - l + 1 + (Math.min(lk.get(l), rk.get(r)) * 2);
            answer = Math.max(answer, len);


            if (lk.get(l) < rk.get(r)) {
                l++; // 오른쪽의 K 가 더 많을 때
            } else {
                r--; // 왼쪽의 K 가 더 많을 때
            }
        }
        System.out.println(answer);
    }
}
