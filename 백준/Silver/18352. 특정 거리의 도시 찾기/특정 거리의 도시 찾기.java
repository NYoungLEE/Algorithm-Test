import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static ArrayList<Integer>[] A;
  static int[] dist;
  static List<Integer> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 도시 개수
    int M = Integer.parseInt(st.nextToken()); // 도로 개수
    int K = Integer.parseInt(st.nextToken()); // 거리 정보
    int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
    A = new ArrayList[N + 1];
    answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E);
    }

    dist = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      dist[i] = -1;
    }
    BFS(X);

    for (int i = 1; i <= N; i++) {
      if (dist[i] == K) {
        answer.add(i);
      }
    }
    if (answer.isEmpty()) {
      System.out.println(-1);
    } else {
      Collections.sort(answer);
      for (int num : answer) {
        System.out.println(num);
      }
        
    }
  }

  private static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    dist[node]++;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i : A[now]) {
        if (dist[i] == -1) {
          dist[i] = dist[now] + 1;
          queue.add(i);
        }
      }
    }
  }
}