import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int[][] box;
  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
    N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수

    box = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 1) {
          queue.add(new int[] {i, j});
        }
      }
    }
    BFS(queue);

    int answer = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        answer = Math.max(answer, box[i][j]);
      }
    }

    System.out.println(answer - 1);
  }

  private static void BFS(Queue<int[]> queue) {
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int x = now[0] + dx[i];
        int y = now[1] + dy[i];

        if (x >= 0 && x < N && y >= 0 && y < M) {
          if (box[x][y] == 0) {
            box[x][y] = box[now[0]][now[1]] + 1;
            queue.add(new int[] {x, y});
          }
        }
      }
    }
  }
}
