package BaekJoon.Gold3.세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

    static int N;
    static long[] seq;
    static long[] result = new long[3];
    static long min = 3_000_000_001L;
    static int left, mid, right;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        for (int i = 0; i < N - 2; i++) {
            left = i;
            mid = i + 1;
            right = N - 1;
            while (mid < right) {
                long sum = seq[left] + seq[mid] + seq[right];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result[0] = seq[left];
                    result[1] = seq[mid];
                    result[2] = seq[right];
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        Arrays.sort(result);
        for (int i = 0; i < 3; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2473.solution();
    }
}
