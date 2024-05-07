package BaekJoon.Gold4.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1987 {

    static int R, C;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j) - 'A';
            }
        }
        compute(0,0,1);
        System.out.println(max);
    }

    static void compute(int x, int y, int cnt) {
        visited[board[x][y]] = true;
        max = Math.max(max, cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAvailable(nx, ny) && !visited[board[nx][ny]]) {
                visited[board[nx][ny]] = true;
                compute(nx, ny, cnt + 1);
                visited[board[nx][ny]] = false;
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) throws IOException {
        BOJ1987.solution();
    }
}
