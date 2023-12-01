import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 도난 당한 학생 기준으로 바로 아래 번호에 있는 애한테 먼저 빌려야함
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                // 여벌 체육복을 가져온 학생이 도난을 당했다면?
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                // 만약 lost가 있는데 앞 번호에 여분의 체육복을 갖고 있는 학생이 있다면?
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    if (reserve[j] != -1) {
                        answer++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}