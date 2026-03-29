import java.util.*;

class Solution {
    public int[] solution(String s) {

        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] sArr = s.split("-");
        
        Arrays.sort(sArr, Comparator.comparingInt(String::length));
        
        List<Integer> list = new ArrayList<>();
        
        for (String str : sArr) {
            String[] temp = str.split(",");
            
            for (int i = 0; i < temp.length; i++) {
                int num = Integer.parseInt(temp[i]);
                
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}