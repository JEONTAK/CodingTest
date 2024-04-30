package BaekJoon.Gold5.체스판다시칠하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25682 {

    static int N, M, K;
    static int[][] board;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];
        boolean color = false;
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = tmp.charAt(j - 1);
                if (!color && c == 'W') {
                    board[i][j] = 1;
                } else if (color && c == 'B') {
                    board[i][j] = 1;
                }
                color = !color;
            }
            if ((M) % 2 == 0) {
                color = !color;
            }
        }
        for (int i = 1; i <= N; i++) {
            int temp = board[i][1];
            for (int j = 2; j <= M; j++) {
                temp += board[i][j];
                board[i][j] = temp;
            }
        }
        for (int i = 1; i <= M; i++) {
            int temp = board[1][i];
            for (int j = 2; j <= N; j++) {
                temp += board[j][i];
                board[j][i] = temp;
            }
        }
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int temp = board[i][j] - (board[i - K][j] + board[i][j - K] - board[i - K][j - K]);
                min = Math.min(min, temp);
                max = Math.max(max,temp);
            }
        }
        int ans = Math.min(min, K * K - max);
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        BOJ25682.solution();
    }
}
