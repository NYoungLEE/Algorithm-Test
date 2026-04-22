class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for (int num : numbers) {
            int[] target = getPos(num);
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = target;
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = target;
            } else {
                int lDist = dist(left, target);
                int rDist = dist(right, target);
                
                if (lDist < rDist || (lDist == rDist && hand.equals("left"))) {
                    sb.append("L");
                    left = target;
                } else {
                    sb.append("R");
                    right = target;
                }
            }

        }
        
        return sb.toString();
    }
    
    private int[] getPos(int num) {
        if (num == 0) return new int[]{3, 1};
        return new int[]{(num - 1) / 3, (num - 1) % 3};
    }
    
    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}