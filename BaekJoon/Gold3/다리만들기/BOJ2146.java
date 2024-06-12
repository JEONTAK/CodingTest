package BaekJoon.Gold3.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {

    static class Island{
        int x;
        int y;
        int b;

        public Island(int x, int y, int b) {
            this.x = x;
            this.y = y;
            this.b = b;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 10000;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int landIdx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    compute(i, j, landIdx);
                    landIdx++;
                }
            }
        }

        for (int i = 1; i <= landIdx; i++) {
            int[][] temp = map.clone();
            makeBridge(temp, i);
        }
        System.out.println(result);
    }

    static void compute(int x, int y, int landIdx) {
        visited[x][y] = true;
        map[x][y] = landIdx;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isAvailable(nx, ny) && !visited[nx][ny]) {
                if (map[nx][ny] != 0) {
                    compute(nx, ny, landIdx);
                }
            }
        }
    }

    static void makeBridge(int[][] temp, int idx) {
        boolean[][] check = new boolean[N][N];
        Queue<Island> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == idx) {
                    q.add(new Island(i, j, 0));
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Island cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny)) {
                    if (temp[nx][ny] != idx && map[nx][ny] != 0) {
                        if(result > cur.b && cur.b != 0)result = cur.b;
                    }else{
                        if (temp[nx][ny] == 0 && !check[nx][ny]) {
                            check[nx][ny] = true;
                            q.add(new Island(nx, ny, cur.b + 1));
                        }
                    }
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ2146.solution();
    }
}
