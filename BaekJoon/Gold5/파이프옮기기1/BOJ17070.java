package BaekJoon.Gold5.파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {

    static int N;
    static int[][] map;
    static int[][][] dp;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (j - 1 >= 0 && map[i][j] == 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if (i - 1 >= 0 && map[i][j] == 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }
                if (i - 1 >= 0 && j - 1 >= 0 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }

            }
        }

        int result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ17070.solution();
    }
}
