package BaekJoon.Gold5.알약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4811 {

    static int N;
    static long[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][31];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 5;
        compute(30,0);
        N = Integer.parseInt(br.readLine());
        while (N != 0) {
            System.out.println(dp[N][0]);
            N = Integer.parseInt(br.readLine());
        }
    }

    static long compute(int w, int h) {
        if (w == 0) {
            return 1;
        }
        if (dp[w][h] != 0) {
            return dp[w][h];
        }
        long cnt = 0;
        if (w != 0) {
            cnt += compute(w - 1, h + 1);
        }
        if (h != 0) {
            cnt += compute(w, h - 1);
        }
        return dp[w][h] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BOJ4811.solution();
    }
}
