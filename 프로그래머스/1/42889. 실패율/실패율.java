import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] currentStages = new int[N + 1];
        int[] clearStages = new int[N + 1];
        
        for (int num : stages) {
            for (int i = 0; i < num; i++) {
                currentStages[i]++;
            }
            clearStages[num - 1]++;
        }
        
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            if(clearStages[i] == 0 || currentStages[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                map.put(i + 1, (double) clearStages[i] / (double) currentStages[i]);   
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(i -> i).toArray();
    }
}