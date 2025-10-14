import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 수열의 개수
        int M = sc.nextInt();   // 나누어떨어져야 하는 수

        long[] S = new long[N]; // 합 배열
        long[] C = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열
        long answer = 0;

        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if(remainder == 0) answer++;
            C[remainder]++;
        }

        for(int i = 0; i < M; i++) {
            if(C[i] > 1) {
                answer += C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(answer);

    }

}
