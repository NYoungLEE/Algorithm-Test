import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int N, M, sNum;
  static int[][] map;
  static boolean[][] visited;
  static ArrayList<int[]> mList;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 가로 크기
    M = Integer.parseInt(st.nextToken()); // 세로 크기
    map = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    sNum = 1;
    ArrayList<ArrayList<int[]>> sumList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j] != 0) {
          BFS(i, j);
          sNum++;
          sumList.add(mList);
        }
      }
    }

    PriorityQueue<bEdge> pq = new PriorityQueue<>();
    for (int i = 0; i < sumList.size(); i++) {
      ArrayList<int[]> now = sumList.get(i);
      for (int j = 0; j < now.size(); j++) {
        int r = now.get(j)[0];
        int c = now.get(j)[1];
        int nowS = map[r][c];
        for (int d = 0; d < 4; d++) {
          int tempR = dr[d];
          int tempC = dc[d];
          int length = 0;
          while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
            if (map[r + tempR][c + tempC] == nowS) {
              break;
            } else if (map[r + tempR][c + tempC] != 0) {
              if (length > 1) {
                pq.add(new bEdge(nowS, map[r + tempR][c + tempC], length));
              }
              break;
            } else {
              length++;
            }
            if (tempR < 0) tempR--;
            else if (tempR > 0) tempR++;
            else if (tempC < 0) tempC--;
            else if (tempC > 0) tempC++;
          }
        }
      }
    }

    parent = new int[sNum];
    for (int i = 0; i < parent.length; i++) parent[i] = i;
    int count = 0;
    int result = 0;
    while (!pq.isEmpty()) {
      bEdge now = pq.poll();
      if (find(now.s) != find(now.e)) {
        union(now.s, now.e);
        result += now.v;
        count++;
      }
    }

    if (count == sNum - 2)
      System.out.println(result);
    else
      System.out.println(-1);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }

  private static int find(int a) {
    if (a == parent[a]) return a;
    else return parent[a] = find(parent[a]);
  }

  private static void BFS(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    mList = new ArrayList<>();
    int[] start = {x, y};
    queue.add(start);
    mList.add(start);
    map[x][y] = sNum;
    visited[x][y] = true;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int r = now[0];
      int c = now[1];
      for (int d = 0; d < 4; d++) {
        int tempR = dr[d];
        int tempC = dc[d];
        while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
          if (map[r + tempR][c + tempC] != 0 && !visited[r + tempR][c + tempC]) {
            addNode(r + tempR, c + tempC, queue);
          } else {
            break;
          }
          if (tempR < 0) tempR--;
          else if (tempR > 0) tempR++;
          else if (tempC < 0) tempC--;
          else if (tempC > 0) tempC++;
        }
      }
    }
  }

  private static void addNode(int x, int y, Queue<int[]> queue) {
    map[x][y] = sNum;
    visited[x][y] = true;
    int[] temp = {x, y};
    queue.add(temp);
    mList.add(temp);
  }
}

class bEdge implements Comparable<bEdge> {
  int s, e, v;
  public bEdge(int s, int e, int v) {
    this.s = s;
    this.e = e;
    this.v = v;
  }

  @Override
  public int compareTo(bEdge o) {
    return this.v - o.v;
  }
}
