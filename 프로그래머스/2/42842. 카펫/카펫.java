class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        int sum = brown + yellow;
        int x = sum;
        int y = 3;
        
        while (true) {
            if (x * y > sum) {
                x--;
            } else if (x * y < sum) {
                y++;
            } else {
                int[] size = {x, y};
                if (canMiddle(brown, yellow, size)) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                } else {
                    y++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean canMiddle(int brown, int yellow, int[] size) {
        
        int needBrownMin = (size[0] * 2) + (size[1] * 2) - 4;
        int needYellowMin = size[0] * size[1] - needBrownMin;
        
        if (brown == needBrownMin && yellow == needYellowMin) {
            return true;
        }
        
        return false;
    }
}