import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 레슨 개수
    int M = sc.nextInt(); // 블루레이 개수
    int[] A = new int[N]; // 기타 레슨 데이터 저장 배열

    int start = 0; int end = 0;
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      start = Math.max(start, A[i]);
      end += A[i];
    }

    while (start <= end) {
      int middle = (start + end) / 2;
      int sum = 0;
      int count = 0;

      for (int i = 0; i < N; i++) {
        if (sum + A[i] > middle) {
          count++;
          sum = 0;
        }
        sum += A[i];
      }

      if (sum != 0) count++;
      if (count > M) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    System.out.println(start);
  }
}
