package BaekJoon.Gold4.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {

    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Move{
        int cnt;
        String m;

        public Move(int cnt, String m) {
            this.cnt = cnt;
            this.m = m;
        }
    }
    static int N, K, L;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }
        L = Integer.parseInt(br.readLine());
        Queue<Move> m = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            m.add(new Move(cnt, temp));
        }
        int curX = 0;
        int curY = 0;
        int d = 0;
        int time = 0;
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(curX, curY));
        map[curX][curY] = 2;
        while (true) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];
            time++;

            if (!isAvailable(nx, ny))break;
            if(map[nx][ny] == 2) break;

            if (map[nx][ny] == 0) {
                Location curLoc = q.poll();
                map[curLoc.x][curLoc.y] = 0;
            }
            if (!m.isEmpty()) {
                if (time == m.peek().cnt) {
                    Move mv = m.poll();
                    if (mv.m.equals("L")) {
                        d = (d - 1 < 0) ? 3 : d - 1;
                    } else {
                        d = (d + 1 > 3) ? 0 : d + 1;
                    }
                }
            }
            map[nx][ny] = 2;
            q.offer(new Location(nx, ny));
            curX = nx;
            curY = ny;
        }
        System.out.println(time);
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ3190.solution();
    }
}
