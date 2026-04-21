class Solution {
    public String solution(String[] survey, int[] choices) {
        
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int[] result = new int[8];
        
        for (int i = 0; i < survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            
            if (choices[i] < 4) {
                int idx = new String(type).indexOf(c1);
                result[idx] += 4 - choices[i];
            } else if (choices[i] > 4) {
                int idx = new String(type).indexOf(c2);
                result[idx] += choices[i] - 4;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(result[0] >= result[1] ? 'R' : 'T');
        sb.append(result[2] >= result[3] ? 'C' : 'F');
        sb.append(result[4] >= result[5] ? 'J' : 'M');
        sb.append(result[6] >= result[7] ? 'A' : 'N');
        
        return sb.toString();
    }
}