package BaekJoon.Gold4.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

    static int N, M;
    static int[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean visited[][];
    static int max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                compute(i, j, 1, board[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void compute(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        if (cnt == 2) {
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nnx = x + dx[i + 1];
                int nny = y + dy[i + 1];
                if (isAvailable(nx, ny) && isAvailable(nnx, nny)) {
                    if (!visited[nx][ny] && !visited[nnx][nny]) {
                        max = Math.max(max, (sum + board[nx][ny] + board[nnx][nny]));
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isAvailable(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                compute(nx, ny, cnt + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ14500.solution();
    }
}
