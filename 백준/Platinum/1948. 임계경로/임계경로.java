import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 도시 수
    int M = Integer.parseInt(br.readLine());  // 도로 수
    ArrayList<ArrayList<dNode>> A = new ArrayList<>();
    ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      A.add(new ArrayList<>());
      reverseA.add(new ArrayList<>());
    }
    int[] indegree = new int[N + 1];
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      int T = Integer.parseInt(st.nextToken());
      A.get(S).add(new dNode(E, T));
      reverseA.get(E).add(new dNode(S, T));
      indegree[E]++;
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    int[] result = new int[N + 1];
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (dNode next : A.get(now)) {
        indegree[next.target]--;
        result[next.target] = Math.max(result[next.target], result[now] + next.value);
        if (indegree[next.target] == 0) queue.add(next.target);
      }
    }

    int count = 0;
    boolean[] visited = new boolean[N + 1];
    queue = new LinkedList<>();
    queue.add(end);
    visited[end] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (dNode next : reverseA.get(now)) {
        if (result[next.target] + next.value == result[now]) {
          count++;
          if (!visited[next.target]) {
            visited[next.target] = true;
            queue.add(next.target);
          }
        }
      }
    }
    System.out.println(result[end]);
    System.out.println(count);
  }
}

class dNode {
  int target;
  int value;

  public dNode(int target, int value) {
    this.target = target;
    this.value = value;
  }
}