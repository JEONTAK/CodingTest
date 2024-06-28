package BaekJoon.Gold3.색상환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2482 {

    static int N, K;
    static int[][][] dp = new int[1002][1002][2];
    static final int mod = (int) (1e9 + 3);

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 1001; i++) {
            for (int j = 0; j <= 1001; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int result = (compute(0,0,0,-1) + compute(0,1,1,-1)) % mod;
        System.out.println(result);
    }

    static int compute(int d, int cur, int start, int last) {
        if (cur >= N) {
            if(d == K && start != (last + 1) % N) return 1;
            return 0;
        }
        if(dp[d][cur][start] != -1) return dp[d][cur][start];
        dp[d][cur][start] = (compute(d + 1, cur + 2, start, cur) + compute(d, cur + 1, start, cur)) % mod;
        return dp[d][cur][start];
    }

    public static void main(String[] args) throws IOException {
        BOJ2482.solution();
    }
}
