import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        System.out.println("일 년 = " + 28*12);
        System.out.println("한 달 = " + 28);
        
        String[] todayStrArr = today.split("\\.");
        int todayYear = Integer.parseInt(todayStrArr[0]);
        int todayMonth = Integer.parseInt(todayStrArr[1]);
        int todayDay = Integer.parseInt(todayStrArr[2]);
        
        for(int i = 0; i < terms.length; i++) {
            String[] parts = terms[i].split(" ");
            String key = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            termMap.put(key, value);
        }
        
        for(int i = 0; i < privacies.length; i++) {
            
            String[] parts = privacies[i].split(" ");
            String[] dateParts = parts[0].split("\\.");
            
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            
            String pvTerm = parts[1];
            
            int termMonth = termMap.get(pvTerm);
            
            month += termMonth;
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            if (year < todayYear || (year == todayYear && (month < todayMonth || (month == todayMonth && day <= todayDay)))) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}