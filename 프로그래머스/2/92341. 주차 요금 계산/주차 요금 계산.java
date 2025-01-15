import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        TreeMap<String, Integer> map = new TreeMap<>();
        recordTime(records, map);
        return getTotalFees(fees, map);
    }
    
    public int[] getTotalFees(int[] fees, Map<String, Integer> map) {
        
        // 0: 기본 시간 1: 기본 요금 2: 단위 시간 3: 단위 요금
        int[] totalFees = new int[map.size()];
        int idx = 0;
        for (int time : map.values()) {
            int sum = 0;
            if (time <= 0) { // 출차 된 적이 없다면
                time += 1439; // 23:59 에 나갔다고 가정
            }
            time -= fees[0]; // 기본 주차 선 계산
            sum += fees[1];
            if (time > 0) {
                if (time % fees[2] == 0) { // 단위 시간이랑 딱 맞으면
                    sum += (time / fees[2]) * fees[3];
                } else { // 안 맞으면 올림
                    sum += (time / fees[2] + 1) * fees[3];
                }
            }
            totalFees[idx++] = sum;
        }
        return totalFees;
    }
    
    public void recordTime(String[] records, Map<String, Integer> map) {
        // 차의 총 입-출차 시간 계산
        for (String record : records) {
            String[] split = record.split(" ");
            int time = getTime(split[0]);
            if (split[2].equals("IN")) {
                time *= -1; // 입차 (음) - 출차 (양) = 무조건 양
            }
            map.put(split[1], map.getOrDefault(split[1], 0) + time);
        }
    }
    
    public int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}