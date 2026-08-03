import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
 
        Map<String, HashSet<String>> reports = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
            count.put(id, 0);
        }
        
        for (String r : report) {
            String[] sArr = r.split(" ");
            reports.get(sArr[1]).add(sArr[0]);
        }
        
        for (String reportedUser : reports.keySet()) {
            HashSet<String> reporters = reports.get(reportedUser);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    count.put(reporter, count.get(reporter) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.get(id_list[i]);
        }
        
        return answer;
    }
}