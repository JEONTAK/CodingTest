package BaekJoon.Gold3.말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

    static class Monkey{
        int x;
        int y;
        int k;
        int t;

        public Monkey(int x, int y, int k, int t) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.t = t;
        }
    }

    static int K, W, H;
    static int[][] map;
    static int[][] delta = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MAX_VALUE;
    static boolean[][][] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0][0] = true;
        compute(0, 0, 0, 0);
        System.out.println((result != Integer.MAX_VALUE) ? result : -1);
    }

    static void compute(int x, int y, int k, int cnt) {
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Monkey cur = q.poll();
            if (result < cur.t)continue;
            if (cur.x == H - 1 && cur.y == W - 1) {
                result = cur.t;
                continue;
            }

            if (cur.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + delta[i][0];
                    int ny = cur.y + delta[i][1];
                    if (isAvailable(nx, ny) && !visited[nx][ny][cur.k + 1] && map[nx][ny] == 0) {
                        visited[nx][ny][cur.k + 1] = true;
                        q.offer(new Monkey(nx, ny, cur.k + 1, cur.t + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny][cur.k] && map[nx][ny] == 0) {
                    visited[nx][ny][cur.k] = true;
                    q.offer(new Monkey(nx, ny, cur.k, cur.t + 1));
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static void main(String[] args) throws IOException {
        BOJ1600.solution();
    }
}
