import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 데이터 개수
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int index = i;
            int value = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if(A[j] < A[i]) {
                    index = j + 1;
                    break;
                }
                if(j == 0) index = 0;
            }

            for (int j = i; j > index; j--) {
                A[j] = A[j - 1];
            }
            A[index] = value;
        }

        int[] S = new int[N];
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += S[i];
        }

        System.out.println(result);
    }
}
