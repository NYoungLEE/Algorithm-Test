import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int[][] map;
  static boolean[][] visited;
  static int N, count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 지도의 크기

    map = new int[N][N];
    visited = new boolean[N][N];
    
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
    
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count = 0;
          DFS(i, j);
          result.add(count);
        }
      }
    }
    
    Collections.sort(result);
    System.out.println(result.size());
    for (int x : result) {
      System.out.println(x);
    }
  }

  public static void DFS(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
        if (map[nx][ny] == 1 && !visited[nx][ny]){
          DFS(nx, ny);
        }
      }
    }
  }
}