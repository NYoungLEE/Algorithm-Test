import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static long[] tree;
  static int MOD;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 노드 개수
    int M = Integer.parseInt(st.nextToken()); // 변경 횟수
    int K = Integer.parseInt(st.nextToken()); // 구간 곱 횟수
    int treeHeight = 0;
    int length = N;
    while (length != 0) {
      length /= 2;
      treeHeight++;
    }
    int treeSize = (int) Math.pow(2, treeHeight + 1);
    int leftNodeStartIndex = treeSize / 2 - 1;
    MOD = 1000000007;
    tree = new long[treeSize + 1];
    Arrays.fill(tree, 1);
    for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }
    setTree(treeSize - 1);
    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      long e = Long.parseLong(st.nextToken());
      if (a == 1) {
        changeVal(leftNodeStartIndex + s, e);
      } else if (a == 2) {
        s += leftNodeStartIndex;
        e += leftNodeStartIndex;
        System.out.println(getMul(s, (int) e));
      }
    }
  }

  private static void setTree(int num) {
    while (num != 1) {
      tree[num / 2] = tree[num / 2] * tree[num] % MOD;
      num--;
    }
  }

  private static void changeVal(int index, long val) {
    tree[index] = val;
    while (index != 1) {
      index /= 2;
      tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
    }
  }

  private static long getMul(int s, int e) {
    long partMul = 1;
    while (s <= e) {
      if (s % 2 == 1) partMul = partMul * tree[s++] % MOD;
      if (e % 2 == 0) partMul = partMul * tree[e--] % MOD;
      s /= 2;
      e /= 2;
    }
    return partMul;
  }
}
