package BaekJoon.Gold4.TwoDots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16929 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int fx, fy;
    static boolean flag = false;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            if(flag)break;
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                visited[i][j] = true;
                fx = i;
                fy = j;
                compute(i, j, 1);
                if(flag)break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    static void compute(int x, int y, int idx) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAvailable(nx, ny) && map[x][y] == map[nx][ny]) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    compute(nx, ny, idx + 1);
                }else{
                    if (idx >= 4 && nx == fx && ny == fy) {
                        flag = true;
                        return;
                    }
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ16929.solution();
    }
}
