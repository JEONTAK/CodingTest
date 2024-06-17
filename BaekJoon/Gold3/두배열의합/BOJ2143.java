package BaekJoon.Gold3.두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2143 {

    static int T, N, M;
    static int[] A, B;
    static long[] aSum, bSum;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            A[i] += A[i - 1];
        }
        for (int i = 1; i < M; i++) {
            B[i] += B[i - 1];
        }
        int aSize = N * (N + 1) / 2;
        int bSize = M * (M + 1) / 2;
        aSum = new long[aSize];
        bSum = new long[bSize];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = A[j];
                if(i > 0) temp -= A[i - 1];
                aSum[idx++] = temp;
            }
        }
        idx = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                int temp = B[j];
                if(i > 0) temp -= B[i - 1];
                bSum[idx++] = temp;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);
        int left = 0;
        int right = bSize - 1;
        long cnt = 0;
        while (left < aSize && right > -1) {
            long aS = aSum[left], bS = bSum[right];
            long sum = aS + bS;
            if (sum == T) {
                long ac = 0, bc = 0;
                while (left < aSize && aS == aSum[left]) {
                    left++;
                    ac++;
                }
                while (right > -1 && bS == bSum[right]) {
                    right--;
                    bc++;
                }
                cnt += ac * bc;
            }
            if (sum > T) {
                right--;
            } else if (sum < T) {
                left++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BOJ2143.solution();
    }
}
