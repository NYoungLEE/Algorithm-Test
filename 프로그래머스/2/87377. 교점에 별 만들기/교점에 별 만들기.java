import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersect(
                    line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);
                
                if (intersection != null) points.add(intersection);
            }
        }
        
        Point min = getMinPoint(points);
        Point max = getMaxPoint(points);
        
        System.out.println(max.x + " " + max.y);
        
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) Arrays.fill(row, '.');
        
        for (Point p : points) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);    
        }
        
        return answer;
    }
    
    public static class Point {
        public long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        } 
    }
    
    private Point intersect(long a1, long b1, long c1, 
                            long a2, long b2, long c2) {
        long denominator = a1 * b2 - a2 * b1;

        if (denominator == 0) {
            return null;
        }

        long xNumerator = b1 * c2 - b2 * c1;
        long yNumerator = a2 * c1 - a1 * c2;

        if (xNumerator % denominator != 0 ||
            yNumerator % denominator != 0) {
            return null;
        }

        long x = xNumerator / denominator;
        long y = yNumerator / denominator;

        return new Point(x, y);
    }
    
    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE, y = Long.MAX_VALUE;
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE, y = Long.MIN_VALUE;
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
}