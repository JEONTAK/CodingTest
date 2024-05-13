package BaekJoon.Gold4.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {

    static class Ground{
        int x;
        int y;

        public Ground(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited, open;
    static boolean flag = true;
    static int cnt = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (flag) {
            compute();
        }
        System.out.println(cnt);
    }

    static void compute() {
        Queue<Ground> q = new LinkedList<>();
        Queue<Ground> nq = new LinkedList<>();
        visited = new boolean[N][N];
        open = new boolean[N][N];
        flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    q.add(new Ground(i, j));
                    int sum = 0;
                    int sumCnt = 0;
                    while (!q.isEmpty()) {
                        Ground cur = q.poll();
                        if (visited[cur.x][cur.y]) continue;
                        visited[cur.x][cur.y] = true;
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (isAvailable(nx, ny) && !visited[nx][ny]) {
                                int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                                if (diff >= L && diff <= R) {
                                    q.add(new Ground(nx, ny));
                                    flag = true;
                                }
                            }
                        }
                        nq.add(new Ground(cur.x, cur.y));
                        sum += map[cur.x][cur.y];
                        sumCnt++;
                    }
                    while (!nq.isEmpty()) {
                        Ground cur = nq.poll();
                        map[cur.x][cur.y] = (sum / sumCnt);
                    }
                }
            }
        }
        if (flag) {
            cnt++;
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }



    public static void main(String[] args) throws IOException {
        BOJ16234.solution();
    }
}
