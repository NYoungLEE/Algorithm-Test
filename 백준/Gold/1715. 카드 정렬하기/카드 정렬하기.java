import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 카드 묶음 개수
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      pq.add(num);
    }

    int num1 = 0;
    int num2 = 0;
    int sum = 0;

    while (pq.size() != 1) {
      num1 = pq.remove();
      num2 = pq.remove();
      sum += num1 + num2;
      pq.add(num1 + num2);
    }

    System.out.println(sum);
  }
}