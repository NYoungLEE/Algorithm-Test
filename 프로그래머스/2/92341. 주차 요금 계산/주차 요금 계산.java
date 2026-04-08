import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String record : records) {
            String[] sArr = record.split(" ");
            if (sArr[2].equals("IN")) {
                map.put(sArr[1], sArr[0]);
            } else {
                String[] inArr = map.get(sArr[1]).split(":");
                int minute1 = Integer.parseInt(inArr[0]) * 60 + Integer.parseInt(inArr[1]);
                
                String[] outArr = sArr[0].split(":");
                int minute2 = Integer.parseInt(outArr[0]) * 60 + Integer.parseInt(outArr[1]);
                
                result.put(sArr[1], result.getOrDefault(sArr[1], 0) + minute2 - minute1);
                map.remove(sArr[1]);
            }
        }
        
        for (String car : map.keySet()) {
                String[] inArr = map.get(car).split(":");
                int minute1 = Integer.parseInt(inArr[0]) * 60 + Integer.parseInt(inArr[1]);
                int minute2 = 23 * 60 + 59;
                
                result.put(car, result.getOrDefault(car, 0) + minute2 - minute1);
        }
                                         
        List<String> cars = new ArrayList<>(result.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int time = result.get(cars.get(i));
            
            if (time <= fees[0]) answer[i] = fees[1];
            else {
                answer[i] = fees[1] + (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}