package BaekJoon.Gold4.두동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16197 {

    static class Location implements Comparable<Location>{
        int c1x;
        int c1y;
        int c2x;
        int c2y;
        int t;

        public Location(int c1x, int c1y, int c2x, int c2y, int t) {
            this.c1x = c1x;
            this.c1y = c1y;
            this.c2x = c2x;
            this.c2y = c2y;
            this.t = t;
        }

        @Override
        public int compareTo(Location o) {
            return this.t - o.t;
        }
    }

    static int N, M;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][][] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N + 2][M + 2];
        int[] coin = new int[4];
        int idx = 0;
        PriorityQueue<Location> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = temp.charAt(j - 1);
                if (board[i][j] == 'o') {
                    coin[idx] = i;
                    idx++;
                    coin[idx] = j;
                    idx++;
                }
            }
        }

        pq.add(new Location(coin[0], coin[1], coin[2], coin[3], 0));
        visited = new boolean[N + 2][M + 2][N + 2][M + 2];
        while (!pq.isEmpty()) {
            Location cur = pq.poll();
            if (cur.t > 10) {
                System.out.println(-1);
                System.exit(0);
            }
            int o = isEnd(cur);
            if (o == 1) {
                System.out.println(cur.t);
                System.exit(0);
            } else if (o == 2) {
                continue;
            }

            if(visited[cur.c1x][cur.c1y][cur.c2x][cur.c2y]) continue;
            visited[cur.c1x][cur.c1y][cur.c2x][cur.c2y] = true;
            for (int i = 0; i < 4; i++) {
                int n1x = cur.c1x + dx[i];
                int n1y = cur.c1y + dy[i];
                int n2x = cur.c2x + dx[i];
                int n2y = cur.c2y + dy[i];
                if (isAvailable(n1x, n1y) && isAvailable(n2x, n2y)) {
                    if (board[n1x][n1y] == '#') {
                        n1x = cur.c1x;
                        n1y = cur.c1y;
                    }
                    if (board[n2x][n2y] == '#') {
                        n2x = cur.c2x;
                        n2y = cur.c2y;
                    }
                    if (!visited[n1x][n1y][n2x][n2y]) {
                        pq.add(new Location(n1x, n1y, n2x, n2y, cur.t + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }
    static boolean isAvailable(int x, int y) {
        return x >= 0 && x <= N + 1 && y >= 0 && y <= M + 1;
    }

    static int isEnd(Location cur) {
        boolean flag1 = false, flag2 = false;
        if ((cur.c1x == 0 || cur.c1x == N + 1) || (cur.c1y == 0 || cur.c1y == M + 1)) {
            flag1 = true;
        }
        if ((cur.c2x == 0 || cur.c2x == N + 1) || (cur.c2y == 0 || cur.c2y == M + 1)) {
            flag2 = true;
        }

        if (flag1 && flag2) {
            return 2;
        } else if (flag1 || flag2) {
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ16197.solution();
    }
}
