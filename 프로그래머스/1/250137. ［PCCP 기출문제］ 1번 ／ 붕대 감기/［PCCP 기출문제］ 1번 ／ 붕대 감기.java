class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHP = health;
        int bandCnt = 0;
        int attackCnt = 0;
        int last = attacks[attacks.length - 1][0];
        
        for (int i = 1; i <= last; i++) {
            
            if (i == attacks[attackCnt][0]) {
                bandCnt = 0;
                health -= attacks[attackCnt][1];
                attackCnt++;
            } else if (i != attacks[attackCnt][0]) {
                health += bandage[1];
                bandCnt++;
            }
            
            if (bandCnt == bandage[0]) {
                health += bandage[2];
                bandCnt = 0;
            }
            
            if (maxHP < health) {
                health = maxHP;
            }
            
            if (health <= 0) {
                health = -1;
                break;
            }
        }
        
        return health;
    }
}