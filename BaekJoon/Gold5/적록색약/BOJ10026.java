package BaekJoon.Gold5.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
    static int N;
    static int[][] grid;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int result;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char tmp = temp.charAt(j);
                if (tmp == 'R') {
                    grid[i][j] = 0;
                } else if (tmp == 'G') {
                    grid[i][j] = 1;
                } else{
                    grid[i][j] = 2;
                }
            }
        }
        result = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    compute(i, j);
                    result++;
                }
            }
        }
        System.out.print(result + " ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                }
            }
        }
        result = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    compute(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void compute(int x, int y) {
        visited[x][y] = true;
        int cur = grid[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAvailable(nx, ny) && !visited[nx][ny] && grid[nx][ny] == cur) {
                compute(nx,ny);
            }
        }
    }

    static boolean isAvailable(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ10026.solution();
    }
}
