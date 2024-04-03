class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        int max = board.length;
        
        for (int i = 0; i < 4; i++) {
            if (h - 1 >= 0 && board[h - 1][w].equals(color)) {
                answer++;
                board[h - 1][w] = "check!";
            } else if (h + 1 < max && board[h + 1][w].equals(color)) {
                answer++;
                board[h + 1][w] = "check!";
            } else if (w - 1 >= 0 && board[h][w - 1].equals(color)) {
                answer++;
                board[h][w - 1] = "check!";
            } else if (w + 1 < max && board[h][w + 1].equals(color)) {
                answer++;
                board[h][w + 1] = "check!";
            }
        }
        
        return answer;
    }
}