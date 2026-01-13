import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static int[][] W;
  static PriorityQueue<Integer>[] distQueue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 도시 수
    M = Integer.parseInt(st.nextToken()); // 도로 수
    K = Integer.parseInt(st.nextToken());
    W = new int[N + 1][N + 1];
    distQueue = new PriorityQueue[N + 1];
    Comparator<Integer> cp = new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    };
    for (int i = 0; i <= N; i++) {
      distQueue[i] = new PriorityQueue<>(K, cp);
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      W[u][v] = w;
    }
    dijkstra();
    for (int i = 1; i <= N; i++) {
      if (distQueue[i].size() == K) {
        bw.write(distQueue[i].peek() + "\n");
      } else {
        bw.write(-1 + "\n");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static void dijkstra() {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(1, 0));
    distQueue[1].add(0);
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      int node = now.node;
      int cost = now.cost;
      for (int adjNode = 1; adjNode <= N; adjNode++) {
        if (W[node][adjNode] != 0) {
          if (distQueue[adjNode].size() < K) {
            distQueue[adjNode].add(cost + W[node][adjNode]);
            queue.add(new Node(adjNode, cost + W[node][adjNode]));
          } else if (distQueue[adjNode].peek() > cost + W[node][adjNode]) {
            distQueue[adjNode].poll();
            distQueue[adjNode].add(cost + W[node][adjNode]);
            queue.add(new Node(adjNode, cost + W[node][adjNode]));
          }
        }
      }
    }
  }
}

class Node implements Comparable<Node> {
  int node;
  int cost;

  public Node(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}
