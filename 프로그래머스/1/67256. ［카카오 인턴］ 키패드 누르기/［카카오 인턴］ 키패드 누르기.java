import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}, 
            {10, 0, 20}
        };
        
        int lNow = 10;
        int rNow = 20;
        
        for (int number : numbers) {
            
            if (number == 1 || number == 4 || number == 7) {
                lNow = number;
                answer += "L";
            }
            if (number == 3 || number == 6 || number == 9) {
                rNow = number;
                answer += "R";
            }
            
            if (number == 2 || number == 5 || number == 8 || number == 0) {
                int Tx = -1;
                int Ty = -1;
                int Lx = -1;
                int Ly = -1;
                int Rx = -1;
                int Ry = -1;
                
                for (int i = 0; i < keypad.length; i++) {
                    for (int j = 0; j < keypad[i].length; j++) {
                        if (keypad[i][j] == number) {
                            Tx = j;
                            Ty = i;
                        }
                        
                        if (keypad[i][j] == rNow) {
                            Rx = j;
                            Ry = i;
                        }
                        
                        if (keypad[i][j] == lNow) {
                            Lx = j;
                            Ly = i;
                        }
                    }
                }
                
                int rLen = Math.abs(Rx - Tx);
                rLen += Math.abs(Ry - Ty);
                int lLen = Math.abs(Lx - Tx);
                lLen += Math.abs(Ly - Ty);
                
                if (rLen == lLen && hand.equals("right")) {
                    rNow = number;
                    answer += "R";
                } else if (rLen == lLen && hand.equals("left")) {
                    lNow = number;
                    answer += "L";
                } else if (rLen < lLen) {
                    rNow = number;
                    answer += "R";
                } else if (rLen > lLen) {
                    lNow = number;
                    answer += "L";
                }
            }
        }
        
        return answer;
    }
}