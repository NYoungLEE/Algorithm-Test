import java.util.*;

class Solution {
    
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        
        map = new HashMap<>();
        
        for (String o : orders) {
            char[] arr = o.toCharArray();
            Arrays.sort(arr);
            String order = new String(arr);
            
            for (int c : course) {
                comb(order, "", 0, c);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            int max = 0;
            
            for (String menu : map.keySet()) {
                if (menu.length() == c) {
                    max = Math.max(max, map.get(menu));
                }
            }
            
            if (max >= 2) {
                for (String menu : map.keySet()) {
                    if (menu.length() == c && map.get(menu) == max) {
                        result.add(menu);
                    }
                }    
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    private void comb(String order, String cur, int idx, int targetLen) {
        if (cur.length() == targetLen) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            comb(order, cur + order.charAt(i), i + 1, targetLen);
        }
    }
}