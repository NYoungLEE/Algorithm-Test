import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수열 개수
        int[] A = new int[N];   // 수열 배열
        int[] ans = new int[N]; // 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++){
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
