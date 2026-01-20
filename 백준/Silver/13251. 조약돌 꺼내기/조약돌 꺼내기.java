import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    int[] D = new int[51];
    double[] probability = new double[51];
    int total = 0;
    double ans = 0.0;

    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken()); // 조약돌의 색상
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      D[i] = Integer.parseInt(st.nextToken());
      total += D[i];
    }
    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken()); // 뽑는 횟수
    for (int i = 0; i < M; i++) {
      if (D[i] >= K) {
        probability[i] = 1.0;
        for (int k = 0; k < K; k++) {
          probability[i] *= (double) (D[i] - k) / (total - k);
        }
        ans += probability[i];
      }
    }
    System.out.println(ans);
  }
}