import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 정렬할 수 개수
    int[] A = new int[N]; // 정렬할 배열 선언하기
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    Arrays.sort(A);

    int M = sc.nextInt(); // 탐색할 숫자의 개수
    for (int i = 0; i < M; i++) {
      boolean find = false;
      int target = sc.nextInt();

      int start = 0;
      int end = A.length - 1;
      while (start <= end) {
        int mid = (start + end) / 2;
        int midV = A[mid];

        if (midV > target) {
          end = mid - 1;
        } else if (midV < target) {
          start = mid + 1;
        } else {
          find = true;
          break;
        }
      }

      if (find) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
