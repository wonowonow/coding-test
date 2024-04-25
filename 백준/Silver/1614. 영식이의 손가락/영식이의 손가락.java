// 엄지 → 검지 → 중지 → 약지 → 새끼 → 약지 → 중지 → 검지 → 엄지 → 검지
// 1 2 3 4 5 4 3 2 1 하

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // n - 다친 손가락
        // m - 다친 손가락 사용 가능 횟수

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        
        long cnt = n - 1;
        
        if (m > 0) {
            if (n % 4 == 1) {
                cnt += 8 * m;
            } else {
                cnt += m / 2 * 8 + m % 2 * (8 - (n - 1) * 2);
            }
        }

        System.out.print(cnt);
    }
}