import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static int[] Sender = {0, 0, 1, 1, 2, 2};
  static int[] Receiver = {1, 2, 0, 2, 0, 1};

  static int[] now;
  static boolean[][] visited;
  static boolean[] answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    now = new int[3];
    now[0] = sc.nextInt();
    now[1] = sc.nextInt();
    now[2] = sc.nextInt();
    visited = new boolean[201][201];
    answer = new boolean[201];
    BFS();
    for (int i = 0; i < answer.length; i++) {
      if (answer[i]) System.out.print(i + " ");
    }
  }

  private static void BFS() {
    Queue<AB> queue = new LinkedList<>();
    queue.add(new AB(0, 0));
    visited[now[0]][now[1]] = true;
    answer[now[2]] = true;
    while (!queue.isEmpty()) {
      AB p = queue.poll();
      int A = p.A;
      int B = p.B;
      int C = now[2] - A - B;
      for (int i = 0; i < 6; i++) {
        int[] next = {A, B, C};
        next[Receiver[i]] += next[Sender[i]];
        next[Sender[i]] = 0;
        if (next[Receiver[i]] > now[Receiver[i]]) {
          next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
          next[Receiver[i]] = now[Receiver[i]];
        }
        if (!visited[next[0]][next[1]]) {
          visited[next[0]][next[1]] = true;
          queue.add(new AB(next[0], next[1]));
          if (next[0] == 0) {
            answer[next[2]] = true;
          }
        }
      }
    }
  }
}

class AB {
  int A;
  int B;

  public AB(int a, int b) {
    this.A = a;
    this.B = b;
  }
}
