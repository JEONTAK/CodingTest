package BaekJoon.Gold3.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1937 {

    static int N;
    static int[][] map, dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, compute(i, j));
            }
        }
        System.out.println(result);
    }

    static int compute(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isAvailable(nx, ny)) {
                if (map[x][y] < map[nx][ny]) {
                    dp[x][y] = Math.max(dp[x][y], compute(nx, ny) + 1);
                    compute(nx, ny);
                }
            }
        }
        return dp[x][y];
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ1937.solution();
    }
}
