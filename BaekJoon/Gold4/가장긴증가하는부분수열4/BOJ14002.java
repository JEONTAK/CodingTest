package BaekJoon.Gold4.가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {

    static int N;
    static int[] seq;
    static int[] dp;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(dp[i], result);
                }
            }
        }
        System.out.println(result);

        Stack<Integer> s = new Stack<>();
        for (int i = N; i >= 1; i--) {
            if (result == dp[i]) {
                s.push(seq[i]);
                result--;
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ14002.solution();
    }
}
