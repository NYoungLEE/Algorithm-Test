class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int hp = health;
        int combo = 0; int idx = 0;
        
        for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            if (idx < attacks.length && time == attacks[idx][0]) {
                hp -= attacks[idx][1];
                if (hp <= 0) return -1;
                combo = 0;
                idx++;
            } else {
                hp = Math.min(health, hp + bandage[1]);
                combo++;
                if (combo == bandage[0]) {
                    combo = 0;
                    hp += bandage[2];
                    hp = Math.min(health, hp);
                }
            }
        }
        
        return hp;
    }
}