import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 노드 개수
    int M = Integer.parseInt(st.nextToken()); // 에지 개수
    long[] distance = new long[N + 1];
    Edge[] Edges = new Edge[M + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      Edges[i] = new Edge(start, end, time);
    }
    distance[1] = 0;
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < M; j++) {
        Edge edge = Edges[j];
        if (distance[edge.start] != Integer.MAX_VALUE &&
            distance[edge.end] > distance[edge.start] + edge.time) {
          distance[edge.end] = distance[edge.start] + edge.time;
        }
      }
    }

    boolean mCycle = false;
    for (int i = 0; i < M; i++) {
      Edge edge = Edges[i];
      if (distance[edge.start] != Integer.MAX_VALUE &&
          distance[edge.end] > distance[edge.start] + edge.time) {
        mCycle = true;
        break;
      }
    }

    if (!mCycle) {
      for (int i = 2; i <= N; i++) {
        if (distance[i] == Integer.MAX_VALUE) {
          System.out.println(-1);
        } else {
          System.out.println(distance[i]);
        }
      }
    } else {
      System.out.println(-1);
    }
  }
}

class Edge {
  int start;
  int end;
  int time;

  public Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}