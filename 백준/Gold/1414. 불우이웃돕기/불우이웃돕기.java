import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 컴퓨터의 개수
    int sum = 0;
    PriorityQueue<lEdge> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      char[] chars = sc.next().toCharArray();
      for (int j = 0; j < N; j++) {
        int tmp = 0;
        if (chars[j] >= 'a' && chars[j] <= 'z') {
          tmp = chars[j] - 'a' + 1;
        } else if (chars[j] >= 'A' && chars[j] <= 'Z') {
          tmp = chars[j] - 'A' + 27;
        }
        sum += tmp;
        if (i != j && tmp != 0) pq.add(new lEdge(i, j, tmp));
      }
    }

    parent = new int[N];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    int result = 0;
    int count = 0;
    while (!pq.isEmpty()) {
      lEdge now = pq.poll();
      if (find(now.s) != find(now.e)) {
        union(now.s, now.e);
        result += now.v;
        count++;
      }
    }

    if (count == N - 1) {
      System.out.println(sum - result);
    } else {
      System.out.println(-1);
    }
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}

class lEdge implements Comparable<lEdge> {
  int s, e, v;

  public lEdge(int s, int e, int v) {
    this.s = s;
    this.e = e;
    this.v = v;
  }

  @Override
  public int compareTo(lEdge o) {
    return this.v - o.v;
  }
}
