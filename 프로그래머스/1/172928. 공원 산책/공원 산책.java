class Solution {
    
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        
        int row = 0; int col = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] command = route.split(" ");
            int direction = getDirection(command[0].charAt(0));
            int distance = Integer.parseInt(command[1]);
            
            if (canMove(park, row, col, direction, distance)) {
                row += dr[direction] * distance;
                col += dc[direction] * distance;
            }
        }
        
        return new int[] {row, col};
    }
    
    private int getDirection(char dir) {
        switch(dir) {
            case 'N':
                return 0;
            case 'S':
                return 1;
            case 'W':
                return 2;
            case 'E':
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private boolean canMove(String[] park, int row, int col, int dir, int dist) {
        int nextRow = row; int nextCol = col;
        
        for (int i = 0; i < dist; i++) {
            nextRow += dr[dir];
            nextCol += dc[dir];
            
            if (nextRow < 0 || nextRow >= park.length
               || nextCol < 0 || nextCol >= park[0].length()) {
                return false;    
            }
            
            if (park[nextRow].charAt(nextCol) == 'X') return false;
            
        }
            
        return true;
    }
}