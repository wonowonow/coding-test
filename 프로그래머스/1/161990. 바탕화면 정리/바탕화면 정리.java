import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int maxTop = -1;
        int maxRight = -1;
        int maxBottom = -1;
        int maxLeft = 60;
        
        for(int i = 0; i < wallpaper.length; i++) {
            
            for(int j = 0; j < wallpaper[i].length(); j++) {
                
                if(maxTop < 0 && wallpaper[i].charAt(j) == '#') {
                    maxTop = i;
                }
                
                if(wallpaper[i].charAt(j) == '#') {
                    maxLeft = Math.min(maxLeft, j);
                    maxRight = Math.max(maxRight, j);
                    maxBottom = Math.max(maxBottom, i);
                }
            }
        }
        
        int[] answer = new int[4];
        
        answer[0] = maxTop;
        answer[1] = maxLeft;
        answer[2] = maxBottom+1;
        answer[3] = maxRight+1;
        
        return answer;
    }
}