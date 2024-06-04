package BaekJoon.Gold4.타일채우기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14852 {

    static int N;
    static long[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(2);
        } else if (N == 2) {
            System.out.println(7);
        }else{
            dp = new long[N + 1][2];
            dp[0][0] = 0;
            dp[1][0] = 2;
            dp[2][0] = 7;
            dp[2][1] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i][1] = (dp[i - 1][1] + dp[i - 3][0]) % 1000000007L;
                dp[i][0] = (3 * dp[i - 2][0] + 2 * dp[i - 1][0] + 2 * dp[i][1]) % 1000000007L;
            }
            System.out.println(dp[N][0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ14852.solution();
    }
}
