import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 배열의 크기
    int K = sc.nextInt(); // 구하고자 하는 인덱스
    long start = 1; long end = K;
    long ans = 0;

    while (start <= end) {
      long mid = (start + end) / 2;
      long cnt = 0; // 중앙값보다 작은 수의 개수
      for (int i = 1; i <= N; i++) {
        cnt += Math.min(mid / i, N);
      }
      if (cnt < K) {
        start = mid + 1;
      } else {
        ans = mid;
        end = mid - 1;
      }
    }

    System.out.println(ans);
  }
}