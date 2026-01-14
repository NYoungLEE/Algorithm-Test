import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt(); // 노드 개수
    int E = sc.nextInt(); // 에지 개수
    PriorityQueue<pEdge> queue = new PriorityQueue<>();
    parent = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < E; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      int v = sc.nextInt();
      queue.add(new pEdge(s, e, v));
    }
    int count = 0;
    int result = 0;
    while (count < V - 1) {
      pEdge now = queue.poll();
      if (find(now.s) != find(now.e)) {
        union(now.s, now.e);
        result += now.v;
        count++;
      }
    }
    System.out.println(result);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if (a == parent[a])
      return a;
    else
      return parent[a] = find(parent[a]);
  }
}

class pEdge implements Comparable<pEdge> {
  int s, e, v;

  public pEdge(int s, int e, int v) {
    this.s = s;
    this.e = e;
    this.v = v;
  }

  @Override
  public int compareTo(pEdge o) {
    return this.v - o.v;
  }
}
