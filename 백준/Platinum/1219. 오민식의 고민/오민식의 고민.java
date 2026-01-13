import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());  // 노드 개수
    int sCity = Integer.parseInt(st.nextToken());  // 시작 도시
    int eCity = Integer.parseInt(st.nextToken()); // 종료 도시
    int M = Integer.parseInt(st.nextToken());  // 에지 개수
    Edge[] Edges = new Edge[M];
    long[] cityMoney = new long[N];
    long[] distance = new long[N];
    Arrays.fill(distance, Long.MIN_VALUE);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      Edges[i] = new Edge(start, end, value);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cityMoney[i] = Long.parseLong(st.nextToken());
    }

    distance[sCity] = cityMoney[sCity];
    for (int i = 0; i < N + 100; i++) {
      for (int j = 0; j < M; j++) {
        Edge edge = Edges[j];
        int start = edge.start;
        int end = edge.end;
        int value = edge.value;
        if (distance[start] == Long.MIN_VALUE) continue;
        else if (distance[start] == Long.MAX_VALUE) {
          distance[end] = Long.MAX_VALUE;
        } else if (distance[end] < distance[start] + cityMoney[end] - value) {
          distance[end] = distance[start] + cityMoney[end] - value;
          if (i >= N - 1) distance[end] = Long.MAX_VALUE;
        }
      }
    }

    if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
    else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
    else System.out.println(distance[eCity]);
  }
}

class Edge {
  int start, end, value;

  public Edge(int start, int end, int value) {
    this.start = start;
    this.end = end;
    this.value = value;
  }
}
