import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        Map<String, Integer> map1 = stringSplit(str1);
        Map<String, Integer> map2 = stringSplit(str2);
        
        if (map1.size() == 0 && map2.size() == 0) return 65536;
        
        double inter = 0; double union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                inter += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
                map2.remove(key);
            } else {
                union += map1.get(key);
            }
        }
        
        for (String key : map2.keySet()) {
            union += map2.get(key);
        }

        double similarity = inter / union;
        
        return (int) (similarity * 65536);
    }
    
    private Map<String, Integer> stringSplit(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String temp = str.toLowerCase().substring(i, i + 2).replaceAll("[^a-z]", "");
            if (temp.length() == 2) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return map;
    }
}