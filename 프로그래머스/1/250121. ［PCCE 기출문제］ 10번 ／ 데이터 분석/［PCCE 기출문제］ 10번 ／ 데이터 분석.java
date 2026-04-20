import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] criteria = {"code", "date", "maximum", "remain"};
        int extIdx = Arrays.asList(criteria).indexOf(ext);
        int sortIdx = Arrays.asList(criteria).indexOf(sort_by);
        
        List<int[]> list = new ArrayList<>();

        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }
        list.sort((a, b) -> a[sortIdx] - b[sortIdx]);
        
        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}