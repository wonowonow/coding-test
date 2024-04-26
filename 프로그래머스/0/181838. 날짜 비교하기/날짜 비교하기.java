class Solution {
    public int solution(int[] date1, int[] date2) {
        int d1 = Integer.parseInt("" + date1[0] + date1[1] + date1[2]);
        int d2 = Integer.parseInt("" + date2[0] + date2[1] + date2[2]);
        return d1 < d2 ? 1 : 0;
    }
}