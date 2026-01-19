import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static long[] tree;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 노드 개수
    int M = Integer.parseInt(st.nextToken()); // 질의 개수
    int treeHeight = 0;
    int length = N;
    while (length != 0) {
      length /= 2;
      treeHeight++;
    }
    int treeSize = (int) Math.pow(2, treeHeight + 1);
    int leftNodeStartIndex = treeSize / 2 - 1;
    tree = new long[treeSize + 1];
    Arrays.fill(tree, Long.MAX_VALUE);
    for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }
    setTree(treeSize - 1);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      s += leftNodeStartIndex;
      e += leftNodeStartIndex;
      System.out.println(getMin(s, e));
    }
  }

  private static void setTree(int num) {
    while (num != 1) {
      if (tree[num / 2] > tree[num])
        tree[num / 2] = tree[num];
      num--;
    }
  }

  private static long getMin(int s, int e) {
    long min = Long.MAX_VALUE;
    while (s <= e) {
      if (s % 2 == 1) min = Math.min(min, tree[s++]);
      if (e % 2 == 0) min = Math.min(min, tree[e--]);
      s /= 2;
      e /= 2;
    }
    return min;
  }

}
