import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), idx++);
        }
        
        Queue<String> queue = new LinkedList<>();
        for (String str : msg.split("")) {
            queue.offer(str);
        }

        List<Integer> list = new ArrayList<>();
        
        String temp = "";
        while (!queue.isEmpty()) {
            temp += queue.poll();
            if(map.containsKey(temp + queue.peek())) {
                continue;
            } else {
                map.put(temp + queue.peek(), idx++);
                list.add(map.get(temp));
                temp = "";
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}