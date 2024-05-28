package BaekJoon.Gold4.RGB거리2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {

    static int N;
    static int[][] house;
    static int[][] dp;
    static final int INF = 1_000_000_000;
    static int result = INF;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        house = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N + 1][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = house[1][j];
                }else{
                    dp[1][j] = INF;
                }
            }

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + house[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + house[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + house[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(j != i) result = Math.min(result, dp[N][j]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ17404.solution();
    }
}
