import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<cNode>[] A;
  static boolean[] visited;
  static long[] D;
  static long lcm;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 재료 개수
    A = new ArrayList[N]; // 인접 리스트
    visited = new boolean[N]; // 탐색 여부 저장 배열
    D = new long[N];  // 각 노드값 저장 배열
    lcm = 1;
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<>();
    }
    for (int i = 1; i < N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();
      A[a].add(new cNode(b, p, q));
      A[b].add(new cNode(a, q, p));
      lcm *= (p * q / gcd(p, q));
    }

    D[0] = lcm;
    DFS(0);

    long mgcd = D[0];
    for (int i = 1; i < N; i++) {
      mgcd = gcd(mgcd, D[i]);
    }
    for (int i = 0; i < N; i++) {
      System.out.print(D[i] / mgcd + " ");
    }
  }

  private static long gcd(long num1, long num2) {
    if (num2 == 0) {
      return num1;
    } else {
      return gcd(num2, num1 % num2);
    }
  }

  private static void DFS(int node) {
    visited[node] = true;
    for (cNode i : A[node]) {
      int next = i.getB();
      if (!visited[next]) {
        D[next] = D[node] * i.getQ() / i.getP();
        DFS(next);
      }
    }
  }
}

class cNode {
  int b;
  int p;
  int q;

  public cNode(int b, int p, int q) {
    this.b = b;
    this.p = p;
    this.q = q;
  }

  public int getB() {
    return b;
  }

  public int getP() {
    return p;
  }

  public int getQ() {
    return q;
  }
}