import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] answer = new int[enroll.length];
        
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
 
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;
            
            while (money > 0 && !cur.equals("-")) {
                int pass = money / 10;
                int keep = money - pass;
                
                answer[index.get(cur)] += keep;
                cur = parent.get(cur);
                money = pass;
            }
        }
        
        return answer;
    }
}