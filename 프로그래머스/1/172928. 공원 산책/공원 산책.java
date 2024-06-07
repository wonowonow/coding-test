import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        // E - 오른쪽
        // W - 왼쪽
        // S - 아래
        // N - 위
        int maxX = park[0].length()-1;
        int maxY = park.length-1;
        
        int curX = 0;
        int curY = 0;
        
        for(int i = 0; i < park.length; i++) {
            
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    curY = i;
                    curX = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] routeArr = routes[i].split(" ");
            String route = routeArr[0];
            int num = Integer.parseInt(routeArr[1]);
            
            int exX = curX;
            int exY = curY;
            
            for(int j = 1; j <= num; j++) {
                
                if(route.equals("E")) {
                    exX++;
                }
                if(route.equals("W")) {
                    exX--;
                }
                if(route.equals("S")) {
                    exY++;
                }
                if(route.equals("N")) {
                    exY--;
                }
                
                if((exX >= 0 && exX <= maxX) && (exY >= 0 && exY <= maxY)) {
                    
                    if(park[exY].charAt(exX) == 'X') {
                        break;
                    }
                    
                    if(j == num) {
                        curY = exY;
                        curX = exX;
                    }
                    
                }
            }
        }
        
        answer[0] = curY;
        answer[1] = curX;
        
        return answer;
    }
}