import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 카드 묶음 개수
    PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());  // 양수 우선순위 큐
    PriorityQueue<Integer> minusPq = new PriorityQueue<>(); // 음수 우선순위 큐
    int one = 0;
    int zero = 0;

    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      if (num == 0) {
        zero++;
      } else if (num == 1) {
        one++;
      } else if (num > 1) {
        plusPq.add(num);
      } else {
        minusPq.add(num);
      }
    }

    int sum = 0;
    while (plusPq.size() > 1) {
      int num1 = plusPq.remove();
      int num2 = plusPq.remove();
      sum += num1 * num2;
    }
    if (!plusPq.isEmpty()) {
      sum += plusPq.remove();
    }

    while (minusPq.size() > 1) {
      int num1 = minusPq.remove();
      int num2 = minusPq.remove();
      sum += num1 * num2;
    }
    if (!minusPq.isEmpty()) {
      if (zero == 0) {
        sum += minusPq.remove();
      }
    }

    sum += one;
    System.out.println(sum);
  }
}