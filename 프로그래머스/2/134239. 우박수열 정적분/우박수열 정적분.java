import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(k);
            
            if(k == 1) break;
            
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
        }
        
        double[] area = new double[list.size() - 1];
        for (int i = 0; i < area.length; i++) {
            area[i] = (list.get(i) + list.get(i + 1)) / 2.0;
        }
        
        double[] sum = new double[list.size()];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + area[i - 1];
        }
        
        double[] answer = new double[ranges.length];
        int idx = 0;
        
        for (int[] range : ranges) {
            int start = range[0];
            int end = list.size() - 1 + range[1];
            
            if (start > end) {
                answer[idx++] = -1;
            } else {
                answer[idx++] = sum[end] - sum[start];
            }
        }
        
        return answer;
    }
}