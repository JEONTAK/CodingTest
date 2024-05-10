package BaekJoon.Gold4.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2573 {

    static class Ice implements Comparable<Ice>{
        int x;
        int y;
        int year;

        public Ice(int x, int y, int year) {
            this.x = x;
            this.y = y;
            this.year = year;
        }

        @Override
        public int compareTo(Ice o) {
            return this.year - o.year;
        }
    }
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] exist;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        exist = new boolean[N][M];
        PriorityQueue<Ice> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    exist[i][j] = true;
                    pq.add(new Ice(i, j, 0));
                }
            }
        }
        int yIdx = 0;
        while (!pq.isEmpty()) {
            Ice cur = pq.poll();
            if (cur.year > yIdx) {
                yIdx++;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 0 && exist[i][j]) {
                            exist[i][j] = false;
                        }
                    }
                }
                int cnt = countIceBerg();
                if (cnt > 1) {
                    System.out.println(yIdx);
                    System.exit(0);
                }
            }
            int remove = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !exist[nx][ny]) {
                    remove++;
                }
            }
            map[cur.x][cur.y] = Math.max(0, map[cur.x][cur.y] - remove);
            if (map[cur.x][cur.y] > 0) {
                pq.add(new Ice(cur.x, cur.y, cur.year + 1));
            }
        }
        System.out.println(0);
    }

    static int countIceBerg(){
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (exist[i][j] && !visited[i][j]) {
                    compute(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void compute(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isAvailable(nx, ny) && exist[nx][ny] && !visited[nx][ny]) {
                compute(nx, ny, visited);
            }
        }
    }
    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    public static void main(String[] args) throws IOException {
        BOJ2573.solution();
    }
}
